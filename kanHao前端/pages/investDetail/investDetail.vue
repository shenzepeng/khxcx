<template>
	<view class="page-box">
		<view class="info-box person">
			<view class="title">
				<text>个人信息</text>
				<view class="good-box">
					<image id="goodBtn" :src="good ? goodIcon : goodGrayIcon" mode="" @tap="goodFn"></image>
					{{goodTimes}}
				</view>
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
			</view>
		</view>
		<view class="info-box price">
			<view class="title">
				价值
			</view>
			<view class="detail">
				<view class="item">
					<text class="label">当前价值</text>
					<text class="value">¥{{personDetail.money}}</text>
				</view>
				<view class="item">
					<text class="label">买入价格</text>
					<text class="value">¥{{personDetail.buyPrice}}</text>
				</view>
				<view class="item">
					<text class="label">持有量</text>
					<text class="value">{{personDetail.purchaseVolume}}%</text>
				</view>
			</view>
		</view>
		<view class="btn-box">
			<!-- <button class="btn" type="primary" @tap="wxPay">买入</button> -->
			<button class="btn" type="primary" @tap="goSell(personDetail.id)">卖出</button>
		</view>
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
					money: 0,
					lastPriece: 0,
					purchaseVolume: 0,
					buyPrice: 0,
					id: 0
				},
				uerInfo: {},
				openId: '',
				good: false,
				goodTimes: 0,
				goodGrayIcon: '../../static/good_gray.png',
				goodIcon: '../../static/good.png',
				investId: '',
				sellerId: '',
			};
		},
		onShow() {
			this.getData(this.investId);
		},
		beforeCreate() {
		},
		onLoad (e) {
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
			console.log(e);
			this.getData(e.id);
			this.getGoodCount(e.sellerId);
			this.investId = e.id;
			this.sellerId = e.sellerId;
		},
		methods:{
			goodFn() {
				let that = this;
				uni.request({
					url: `${BASEURL}/khxcx-0.0.1-SNAPSHOT/insertLikesByThisWay.action?userId=${that.sellerId}&openId=${that.openId}`,
					method: 'GET',
					data: {
// 						beiDianZanOpenId: that.investOpenId,
// 						dianZanOpenId: that.openId
					},
					success: res => {
						that.good = true;
						uni.showToast({
							title: res.data.data,
							icon: 'none',
							mask: true,
							duration: 2000
						});
						that.getGoodCount(that.sellerId);
					},
					fail: () => {},
					complete: () => {}
				});
			},
			getData (id) {
				let that = this;
				uni.request({
					url: `${BASEURL}/khxcx-0.0.1-SNAPSHOT/findInvestmentStatementItemById.action`,
					method: 'GET',
					data: {
						id: id
					},
					success: res => {
						console.log(res);
						that.personDetail.age = res.data.data.userIfo.age;
						that.personDetail.name = res.data.data.userIfo.givenName;
						that.personDetail.sex = res.data.data.userIfo.sex;
						that.personDetail.introduce = res.data.data.userIfo.introduce;
						that.personDetail.money = res.data.data.userIfo.priece;
						that.personDetail.lastPriece = res.data.data.userIfo.lastPriece;
						that.personDetail.purchaseVolume = res.data.data.investmentStatementById.purchaseVolume;
						that.personDetail.buyPrice = res.data.data.investmentStatementById.purchasePrice;
						that.personDetail.id = res.data.data.investmentStatementById.id;
					},
					fail: () => {},
					complete: () => {}
				});
			},
			getGoodCount(id) {
				let that = this;
				uni.request({
					url: `${BASEURL}/khxcx-0.0.1-SNAPSHOT/getDianZanConntsByUserId.action`,
					method: 'GET',
					data: {
						userId: id
					},
					success: res => {
						console.log(res);
						that.goodTimes = res.data.data;
					},
					fail: () => {},
					complete: () => {}
				});
			},
			goSell(id) {
				let that = this;
				uni.navigateTo({
					url: '../sell/sell?id='+id
				});
			},
			wxPay() {
				let that = this;
				uni.request({
					url: `${BASEURL}/khxcx-0.0.1-SNAPSHOT/create.action?openId=${that.openId}&money=${0.01}`,
					method: 'POST',
					data: {
// 						openId: that.openId,
// 						money: 0.01
					},
					success: res => {
						console.log(res);
						let orderId = res.data.data.orderId;
						uni.requestPayment({
							provider: 'wxpay',
							timeStamp: res.data.data.payResponse.timeStamp,
							nonceStr: res.data.data.payResponse.nonceStr,
							package: res.data.data.payResponse.package,
							signType: 'MD5',
							paySign: res.data.data.payResponse.paySign,
							success: function (res) {
								console.log(res);
								
								uni.request({
									url: `${BASEURL}/khxcx-0.0.1-SNAPSHOT/makeSurePayIdOk.action`,
									method: 'GET',
									data: {
										orderId: orderId
									},
									success: res => {
										console.log(res);
									},
									fail: (err) => {
										console.log(err);
									},
									complete: () => {}
								});
							},
							fail: function (err) {
								console.log('fail:' + JSON.stringify(err));
							}
						});
					},
					fail: () => {},
					complete: () => {}
				});
				
			}
		}
	}
</script>

<style lang="less">
	.page-box {
		display: flex;
		flex-direction: column;
		justify-content: flex-start;
		align-items: center;

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

		.btn-box {
			display: flex;
			justify-content: space-between;
			width: 700upx;
			margin-top: 60upx;

			.btn {
				width: 100%;
			}
		}
	}
</style>
