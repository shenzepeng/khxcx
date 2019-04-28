<template>
	<view class="page-box">
		<view class="input-box">
			<text class="label">卖出量</text>
			<text class="input">{{personDetail.purchaseVolume}}%</text>
			<!-- <input class="input" type="digit" value="" v-model=""/> -->
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
					purchaseVolume: 0,
					buyPrice: 0
				},
				percentVal: null,
				investId: '',
				openId: '',
				uerInfo:{}
			};
		},
		computed:{
			allMoney () {
				return (this.personDetail.purchaseVolume/100)*this.personDetail.price
			},
			sellPlaceholder () {
				return `共持有上市者${this.personDetail.purchaseVolume}%的价值`
			}
		},
		beforeCreate() {
		},
		onLoad(e) {
			let that = this;
			uni.getStorage({
				key: 'userInfo',
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
			this.investId = e.id;
			this.getData(e.id);
		},
		methods:{
			submitFn() {
				let that = this;
// 				if (!(that.percentVal <= that.personDetail.purchaseVolume)) {
// 					uni.showToast({
// 						title: '超出持有总量，请重新输入购买量',
// 						icon: 'none',
// 						mask: false,
// 						duration: 2000
// 					});;
// 					return;
// 				}
// 				console.log(111);https://www.shenzepengzuishuai.cn/khxcx-0.0.1-SNAPSHOT/sellOutEnd.action
				uni.request({
					url: `${BASEURL}/khxcx-0.0.1-SNAPSHOT/sellOutEnd.action?investmentStatementId=${that.investId}&purchaseVolume=${that.personDetail.purchaseVolume}&purchasePriceTotal=${that.allMoney}`,
					method: 'GET',
					data: {
						// 						openId: that.openId,purchaseVolume
						// 						money: 0.01，purchasePriceTotal，investmentStatementId
					},
					success: res => {
						console.log(res);
						uni.showToast({
							title: '卖出成功',
							mask: false,
							duration: 2000
						});
						setTimeout(() => {
							uni.navigateBack({
								delta: 2
							});
						},2000)
					},
					fail: () => {},
					complete: () => {}
				});
			},
			
			getData(id) {
				let that = this;
				uni.request({
					url: `${BASEURL}/khxcx-0.0.1-SNAPSHOT/findInvestmentStatementItemById.action`,
					method: 'GET',
					data: {
						id: id
					},
					success: res => {
						console.log(res.data.data);
						that.personDetail.age = res.data.data.userIfo.age;
						that.personDetail.name = res.data.data.userIfo.givenName;
						that.personDetail.sex = res.data.data.userIfo.sex;
						that.personDetail.introduce = res.data.data.userIfo.introduce;
						that.personDetail.price = res.data.data.userIfo.priece;
						that.personDetail.lastPriece = res.data.data.userIfo.lastPriece;
						that.personDetail.purchaseVolume = res.data.data.investmentStatementById.purchaseVolume;
						that.personDetail.buyPrice = res.data.data.investmentStatementById.purchasePrice;
						that.personDetail.id = res.data.data.investmentStatementById.id;
						// that.personDetail.price = res.data.data.investmentStatementById.id;
					},
					fail: (err) => {
						console.log(err);
					},
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
