<template>
	<view class="page-box">
		<view class="input-box">
			<text class="label">购入量</text>
			<input class="input" type="digit" value="" v-model="percentVal" placeholder="输入购买比例"/>
		</view>
		<view class="info-box person">
			<view class="title">
				<text>购买信息</text>
			</view>
			<view class="detail">
				<view class="item">
					<text class="label">姓名</text>
					<text class="value">{{personDetail.name}}</text>
				</view>
				<view class="item">
					<text class="label">性别</text>
					<text class="value">{{personDetail.sex}}</text>
				</view>
				<view class="item">
					<text class="label">年龄</text>
					<text class="value">{{personDetail.age}}</text>
				</view>
				<view class="item">
					<text class="label">个人介绍</text>
					<text class="value">{{personDetail.introduce}}</text>
				</view>
				<view class="item">
					<text class="label">当前价值</text>
					<text class="value">¥{{personDetail.price}}</text>
				</view>
			</view>
		</view>
		<view class="total-money">
			<text class="label">总金额</text>
			<text class="value">¥{{allMoney}}</text>
		</view>
		<button id="submitBtn" type="primary" @tap="submitFn">提交</button>
	</view>
</template>

<script>
	import BASEURL from "../../common/baseInfo.js";
	export default {
		data() {
			return {
				personDetail: {
					name: '',
					sex: '',
					age: 0,
					introduce: '',
					price: 0,
					lastPriece: 0,
					shengyugoumailaing: 0
				},
				percentVal: null,
				investOpenId: '',
				openId: ''
			};
		},
		computed:{
			allMoney () {
				return (this.percentVal/100)*this.personDetail.price
			}
		},
		beforeCreate() {
		},
		onLoad(e) {
			let that = this;
			uni.getStorage({
				key: 'openIdInfo',
				success: function(res) {
					// console.log(JSON.parse(res));
					console.log(res.data);
					that.uerInfo = res.data;
				}
			});
			uni.getStorage({
				key: 'openIdInfo',
				success: function(res) {
					// console.log(JSON.parse(res));
					console.log(res);
					that.openId = res.data;
				}
			})
			this.investOpenId = e.id;
			this.getData(e.id);
		},
		methods:{
			submitFn() {
				let that = this;
				
				if (that.openId == that.investOpenId) {
					uni.showToast({
						title: '很抱歉，不可以投资自己',
						icon: 'none',
						mask: false,
						duration: 2000
					});;
					return;
				}
				if (!(that.percentVal <= that.personDetail.shengyugoumailaing)) {
					uni.showToast({
						title: '超出购买限制，请重新输入购买量',
						icon: 'none',
						mask: false,
						duration: 2000
					});;
					return;
				}
// 				console.log(111);
				uni.request({
					url: `${BASEURL}/khxcx-0.0.1-SNAPSHOT/create.action?openId=${that.openId}&money=${that.allMoney}&beSellId=${that.investOpenId}&purchaseVolume=${that.percentVal}&purchasePrice=${that.personDetail.price}&shengyugoumailaing=${(that.personDetail.shengyugoumailaing-that.percentVal)}`,
					method: 'POST',
					data: {
						// 						openId: that.openId,
						// 						money: 0.01
					},
					success: res => {
						console.log(res);
						uni.requestPayment({
							provider: 'wxpay',
							timeStamp: res.data.data.payResponse.timeStamp,
							nonceStr: res.data.data.payResponse.nonceStr,
							package: res.data.data.payResponse.package,
							signType: 'MD5',
							paySign: res.data.data.payResponse.paySign,
							success: function(res) {
								console.log('success:' + JSON.stringify(res));
								uni.showToast({
									title: '支付成功',
									mask: false,
									duration: 2000
								});
								setTimeout(() => {
									uni.navigateBack();
								},2000)
							},
							fail: function(err) {
								console.log('fail:' + JSON.stringify(err));
							}
						});
					},
					fail: () => {},
					complete: () => {}
				});
			},
			getData(id) {
				let that = this;
				uni.request({
					url: `${BASEURL}/khxcx-0.0.1-SNAPSHOT/findUserByOpenId.action`,
					method: 'GET',
					data: {
						openId: id
					},
					success: res => {
						that.personDetail.age = res.data.data.age;
						that.personDetail.name = res.data.data.givenName;
						that.personDetail.sex = res.data.data.sex;
						that.personDetail.introduce = res.data.data.introduce;
						that.personDetail.price = res.data.data.priece;
						that.personDetail.lastPriece = res.data.data.lastPriece;
						that.personDetail.shengyugoumailaing = res.data.data.shengyugoumailaing;
					},
					fail: (err) => {
						console.log(err);
					},
					complete: () => {}
				});
				uni.request({
					url: `${BASEURL}/khxcx-0.0.1-SNAPSHOT/getCountsByUserId.action`,
					method: 'GET',
					data: {
						openId: id
					},
					success: res => {
						console.log(res);
						that.goodTimes = res.data.data;
					},
					fail: () => {},
					complete: () => {}
				});
			},
		}
	}
</script>

<style lang="less">
.page-box {
		display: flex;
		flex-direction: column;
		justify-content: flex-start;
		align-items: center;
		.input-box{
			display: flex;
			justify-content: space-between;
			align-items: center;
			width: 700upx;
			margin-top: 30upx;
			border: 1upx solid #f2f2f2;
			.label{
				width: 100upx;
				height: 60upx;
				padding: 0 20upx;
				line-height: 60upx;
			}
			.input{
				width: 550upx;
				height: 60upx;
				line-height: 60upx;
				text-align: right;
				padding-right: 20upx;
			}
		}
		.info-box {
			width: 700upx;
			margin-top: 30upx;
			border: 1upx solid #f2f2f2;

			.title {
				display: flex;
				justify-content: space-between;
				align-items: center;
				box-sizing: border-box;
				width: 100%;
				height: 80upx;
				line-height: 80upx;
				padding-left: 20upx;
				border-bottom: 1px solid #f2f2f2;
				.good-box{
					display: flex;
					justify-content: space-between;
					align-items: center;
					width: 105upx;
					margin-right: 20upx;
					font-size: 24upx;
					color: #999;
					#goodBtn{
						width: 40upx;
						height: 40upx;
						margin-right: 10upx;
					}
				}
			}

			.detail {
				box-sizing: border-box;
				width: 100%;
				padding: 0 20upx;

				.item {
					display: flex;
					justify-content: space-between;
					min-height: 60upx;
					line-height: 60upx;

					.value {
						max-width: 500upx;
					}
				}
			}
		}
		.total-money{
			display: flex;
			justify-content: space-between;
			align-items: center;
			width: 700upx;
			margin-top: 30upx;
			border: 1upx solid #f2f2f2;
			.label{
				width: 100upx;
				height: 60upx;
				padding: 0 20upx;
				line-height: 60upx;
			}
			.value{
				width: 550upx;
				height: 60upx;
				line-height: 60upx;
				text-align: right;
				padding-right: 20upx;
			}
		}
		#submitBtn{
			width: 700upx;
			margin-top: 50upx;
		}
	}
</style>
