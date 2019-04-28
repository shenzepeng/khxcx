<template>
	<view class="content">
		<view class="">
			<mSearch :mode="2" button="inside" :show="true" @search="search($event,3)"></mSearch>
		</view>
		<!-- <view class="search-box-demo">
			<view class="search">
				<view class="content">
					<view class="content-box center">
						<text class="icon icon-serach">&#xe61c;</text>
						<input type="text" class="input center" value="" placeholder="请输入关键字" disabled @tap="openSearch()"/>
					</view>
				</view>
			</view>
		</view> -->
	<!-- 	<view class="uni-padding-wrap search-box">
			<icon class="search-icon" type="search" size="20"></icon>
			<input class="uni-input search-input" confirm-type="search" placeholder="关键字/姓名/特点" />
		</view> -->
		<!-- <view>
			<view class="page-section swiper">
				<view class="page-section-spacing">
					<swiper class="swiper" :indicator-dots="indicatorDots" :autoplay="autoplay" :interval="interval" :duration="duration">
						<swiper-item>
							<view class="swiper-item uni-bg-red">A</view>
						</swiper-item>
						<swiper-item>
							<view class="swiper-item uni-bg-green">B</view>
						</swiper-item>
						<swiper-item>
							<view class="swiper-item uni-bg-blue">C</view>
						</swiper-item>
					</swiper>
				</view>
			</view>
		</view> -->
		<view class="uni-list">
			<view class="uni-list-cell" hover-class="uni-list-cell-hover" v-for="(value,key) in personList" :key="key" @tap="openDetail(value.openId)">
				<view class="uni-media-list">
					<view class="uni-media-list-logo">
						<image :src="value.imgUrl"></image>
					</view>
					<view class="uni-media-list-body">
						<view class="uni-media-list-text-top">{{value.givenName}}</view>
						<view class="uni-media-list-text-bottom uni-ellipsis">{{value.introduce}}</view>
						<view class="money-box">
							<text class="money">¥{{value.priece}}</text>
							<text class="change">{{value.change}}</text>
						</view>
					</view>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	import mSearch from '../../components/mehaotian-search.vue';
	import BASEURL from "../../common/baseInfo.js";
	const duration = 2000
	export default {
		components: {
			mSearch
		},
		data() {
			return {
				defaultKeyword:'请输入关键字',
				background: ['color1', 'color2', 'color3'],
				indicatorDots: true,
				autoplay: true,
				interval: 2000,
				requestOptions: {
					duration: 500,
					res: '',
				},
				personList:[]
// 				val0: '',
// 				val1: '',
// 				val2: '',
// 				val3: ''
			}
		},
		onShow() {
			this.checkLogin();
			this.sendRequest();
		},
		onLoad() {
			// this.sendRequest();
		},
		methods: {
			sendRequest(e) {
				let requestUrl = `${BASEURL}/khxcx-0.0.1-SNAPSHOT/findAllUser.action`;
				if (e) {
					// requestUrl = `${BASEURL}/khxcx-0.0.1-SNAPSHOT/findAllUser.action?keyword=${e}`
					requestUrl = `${BASEURL}/khxcx-0.0.1-SNAPSHOT/findUserIfoByString.action?string=${e}`;
				}
				uni.showLoading({
					title: '加载中'
				});
				uni.request({
					url: requestUrl,
					dataType: 'text',
					data: {
						// noncestr: Date.now()
					},
					success: (res) => {
						console.log('request success', JSON.parse(res.data));
						let data = JSON.parse(res.data);
						if (data.data.length == 0) {
							uni.showToast({
								title: '没有找的相关信息',
								icon: 'none',
								mask: false,
								duration: 1500
							});
						}
						this.res = '请求结果 : ' + JSON.stringify(res);
						this.personList = data.data;
						console.log(this.personList);
					},
					fail: (err) => {
						console.log('request fail', err);
						uni.showModal({
							content: err.errMsg,
							showCancel: false
						});
					},
					complete: () => {
						uni.hideLoading()
					}
				});
			},
			openDetail(id) {
				uni.navigateTo({
					url: '../indexInvestDetail/indexInvestDetail?id='+id
				});
			},
			search(e, val) {
				this.sendRequest(e);
			},
			checkLogin() {
				let that = this;
				uni.checkSession({
					success(res) {
						console.log(res);
						uni.login({
							provider: 'weixin',
							success: res => {
								uni.request({
									url: `${BASEURL}/khxcx-0.0.1-SNAPSHOT/wxLogin?code=${res.code}`,
									method: 'POST',
									data: {},
									success: res => {
										let openId = res.data.data.openid;
										console.log(res,'succ');
										uni.setStorage({
											key: 'openIdInfo',
											data: res.data.data.openid,
											success: function () {
												console.log('success');
											}
										});
										// 获取用户信息
										uni.getUserInfo({
										  provider: 'weixin',
										  success: function (infoRes) {
											// that.login = true;
											uni.request({
												url: `${BASEURL}/khxcx-0.0.1-SNAPSHOT/updateUserByOpenId.action`,
												method: 'GET',
												data: {
													nickName: infoRes.userInfo.nickName,
													imgUrl: infoRes.userInfo.avatarUrl,
													openId:openId
												},
												success: res => {
													console.log(res);
												},
												fail: () => {},
												complete: () => {}
											});
											uni.setStorage({
												key: 'userInfo',
												data: infoRes.userInfo,
												success: function () {
													console.log('success');
													// uni.navigateBack();
												}
											});
											// console.log(infoRes);
										  }
										});
									},
									fail: (err) => {
										
											console.log(err,'err');
									},
									complete: (data) => {
											console.log(data,'data');}
								});
							},
							fail: () => {},
							complete: () => {}
						});
						// that.getUserInfoFn()
					},
					fail(err) {
						console.log(err,'err');
						uni.navigateTo({
							url: '../login/login'
						});
					}
				})
			},
			getUserInfoFn () {
				let that = this;
				uni.getUserInfo({
				  provider: 'weixin',
				  success: function (infoRes) {
					console.log(infoRes.userInfo);
					uni.setStorage({
						key: 'userInfo',
						data: infoRes.userInfo,
						success: function () {
							console.log('success');
						}
					});
				  }
				});
				uni.request({
					url: '',
					method: 'GET',
					data: {},
					success: res => {},
					fail: () => {},
					complete: () => {}
				});
			}
// 			 search(e, val) {
// 				console.log(e, val);
// 				this['val'+val] = e;
// 			}
		}
	}
</script>

<style lang="less">
	.content {
		height: 400upx;

		.search-box {width:95%;background-color:rgb(242,242,242);padding:7.5px 2.5%;display:flex;justify-content:space-between;}
		.search-box-demo{
			width:95%;
			background-color:#f2f2f2;
			padding:7.5px 2.5%;
			display:flex;
			justify-content:space-between;
			.search{
				display:flex;
				width:100%;
				box-sizing:border-box;
				font-size:28upx;
				.content{
					display:flex;
					align-items:center;
					width:100%;
					height:60upx;
					background:#fff;
					overflow:hidden;
					transition:all 0.2s linear;
					border-radius:30px;
					text-align: center;
					.content-box{
						width:100%;
						display:flex;
						justify-content:center;
						align-items:center;
						.icon{
							font-family:iconfont;
							font-size:32rpx;
							font-style:normal;
							color:#999;
							padding:0 15upx;
						}
						.input{
							width:200upx;
							max-width:100%;
							line-height:60upx;
							height:60upx;
							transition:all 0.2s linear;
						}
					}
				}
			}
		}
		.swiper {
			height: 300upx;

			.swiper-item {
				display: block;
				height: 300upx;
				line-height: 300upx;
				text-align: center;
			}
		}
		.uni-media-list-body{
			position: relative;
		}
		.money-box{
			position: absolute;
			right: 0;
			top: 50%;
			transform: translateY(-50%);
			font-size: 26upx;
		}
	}
</style>
