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
				<text>价值</text>
			</view>
			<view class="detail">
				<view class="item">
					<text class="label">当前价值</text>
					<text class="value">¥{{personDetail.money}}</text>
				</view>
			<!-- 	<view class="item">
					<text class="label">近期浮动</text>
					<text class="value">{{((personDetail.money-personDetail.lastPriece) > 0) ? '+' : '-'}}¥{{(personDetail.money-personDetail.lastPriece)}}</text>
				</view> -->
				<view class="item">
					<text class="label">剩余可购买量</text>
					<text class="value">{{personDetail.shengyugoumailaing + 1}}%</text>
				</view>
			</view>
		</view>
		<view class="btn-box">
			<button class="btn" type="primary" @tap="wxPay">买入</button>
			<!-- <button class="btn" type="primary">卖出</button> -->
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
					shengyugoumailaing: 0
				},
				uerInfo: {},
				openId: '',
				good: false,
				goodTimes: 0,
				goodGrayIcon: '../../static/good_gray.png',
				goodIcon: '../../static/good.png',
				investOpenId: ''
			};
		},
		onShow() {
			this.getData(this.investOpenId);
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
			console.log(e);
			this.investOpenId = e.id;
			this.getData(e.id);
			this.getGoodCount(e.id);
		},
		methods: {
			goodFn() {
				let that = this;
				uni.request({
					url: `${BASEURL}/khxcx-0.0.1-SNAPSHOT/insertLikes.action?beiDianZanOpenId=${that.investOpenId}&dianZanOpenId=${that.openId}`,
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
						that.getGoodCount(that.investOpenId);
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
						that.personDetail.money = res.data.data.priece;
						that.personDetail.lastPriece = res.data.data.lastPriece;
						that.personDetail.shengyugoumailaing = res.data.data.shengyugoumailaing;
					},
					fail: (err) => {
						console.log(err);
					},
					complete: () => {}
				});
			},
			getGoodCount(id) {
				let that = this;
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
			wxPay() {
				let that = this;
				if (that.personDetail.money == 0 || that.personDetail.money == null) {
					uni.showToast({
						title: '该上市者没有设置价值，无法买入',
						icon: 'none',
						mask: false,
						duration: 2000
					});
					return;
				}
				uni.navigateTo({
					url: '../buy/buy?id='+that.investOpenId
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
