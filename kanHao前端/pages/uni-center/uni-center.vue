<template>
	<view class="center">
		<view class="logo">
			<image class="logo-img" :src="uerInfo.avatarUrl"></image>
			<view class="logo-title">
				<text class="uer-name">Hi，{{uerInfo.nickName}}</text>
			</view>
		</view>
		<view class="center-list">
			<view class="center-list-item border-bottom" @tap="goUserInfo">
				<text class="list-icon">&#xe60f;</text>
				<text class="list-text">帐号管理</text>
				<text class="navigat-arrow">&#xe65e;</text>
			</view>
			<view class="center-list-item" @tap="goWallet">
				<text class="list-icon">&#xe639;</text>
				<text class="list-text">看好钱包</text>
				<text class="navigat-arrow">&#xe65e;</text>
			</view>
		</view>
		<view class="center-list">
			<view class="center-list-item border-bottom" @tap="goMyInvest">
				<text class="list-icon">&#xe60b;</text>
				<text class="list-text">我的投资</text>
				<text class="navigat-arrow">&#xe65e;</text>
			</view>
			<view class="center-list-item" @tap="listInfo" v-if="checkedInfo">
				<text class="list-icon">&#xe65f;</text>
				<text class="list-text">上市信息</text>
				<text class="navigat-arrow">&#xe65e;</text>
			</view>
			<view class="center-list-item" @tap="checkShangshi" v-else>
				<text class="list-icon">&#xe65f;</text>
				<text class="list-text">立即验证，获得大家的投资吧</text>
				<text class="navigat-arrow">&#xe65e;</text>
			</view>
		</view>
	</view>
</template>

<script>
	import BASEURL from "../../common/baseInfo.js";
	import uniPopup from '../../components/uni-popup.vue';
	export default {
		components:{
			uniPopup
		},
		onShow() {
			let that = this;
			if (!this.isfirst) {
				that.getUserAppInfo();
			}
		},
		data() {
			return {
				avatarUrl: "",
				uerInfo: {},
				openId: '',
				showPopupBottom: false,
				checkedInfo: false,
				isfirst: true
			}
		},
		beforeCreate() {
		},
		onLoad() {
			let that = this;
			uni.getStorage({
				key: 'userInfo',
				success: function (res) {
					// console.log(JSON.parse(res));
					console.log(res.data);
					that.uerInfo = res.data;
				}
			})
			uni.getStorage({
				key: 'openIdInfo',
				success: function(res) {
					// console.log(JSON.parse(res));
					console.log(res);
					that.openId = res.data;
					that.getUserAppInfo();
				}
			})
			// this.getUserInfoFn();
  
		},
		methods: {
			getUserAppInfo() {
				let that = this;
				console.log(`${BASEURL}/khxcx-0.0.1-SNAPSHOT/findUserByOpenId.action`);
				uni.request({
					url: `${BASEURL}/khxcx-0.0.1-SNAPSHOT/findUserByOpenId.action`,
					method: 'GET',
					data: {
						openId: that.openId
					},
					success: res => {
						console.log(res);
						that.isfirst = false;
						if (res.data.data.type === '上市者') {
							that.checkedInfo = true;
						} else {
							that.checkedInfo = false;
						}
					},
					fail: (err) => {
						console.log(err);
					},
					complete: () => {}
				});
			},
			goUserInfo() {
				uni.navigateTo({
					url: '../userinfo/userinfo'
				});
			},
			bindGetUserInfo: function(e) {
			  console.log(e.detail.userInfo)
			  if (e.detail.userInfo){
			    //用户按了允许授权按钮
			  } else {
			    //用户按了拒绝按钮
			  }
			},
			checkShangshi() {
				uni.navigateTo({
					url: '../authPhone/authPhone'
				});
			},
			listInfo() {
				uni.navigateTo({
					url: '../goList/goList'
				});
			},
			goWallet() {
				uni.navigateTo({
					url: '../wallet/wallet'
				});
			},
			goMyInvest() {
				uni.navigateTo({
					url: '../myInvest/myInvest'
				});
			}
// 			getUserInfoFn () {
// 				let that = this;
// 				uni.getUserInfo({
// 				  provider: 'weixin',
// 				  success: function (infoRes) {
// 					console.log(infoRes.userInfo);
// 					that.uerInfo = infoRes.userInfo;
// 				  }
// 				});
// 			}
		}
	}
</script>

<style>
	@font-face {
		font-family: texticons;
		font-weight: normal;
		font-style: normal;
		src: url('https://at.alicdn.com/t/font_984210_5cs13ndgqsn.ttf') format('truetype');
	}

	page,
	view {
		display: flex;
	}

	page {
		background-color: #f8f8f8;
	}

	.center {
		flex-direction: column;
	}

	.logo {
		width: 750upx;
		height: 240upx;
		padding: 20upx;
		box-sizing: border-box;
		background: linear-gradient(to right, #04a9fe , #468ff2);
		flex-direction: row;
		align-items: center;
	}

	.logo-hover {
		opacity: 0.8;
	}

	.logo-img {
		width: 150upx;
		height: 150upx;
		border-radius: 150upx;
	}

	.logo-title {
		height: 150upx;
		flex: 1;
		align-items: center;
		justify-content: space-between;
		flex-direction: row;
		margin-left: 20upx;
	}

	.uer-name {
		height: 60upx;
		line-height: 60upx;
		font-size: 38upx;
		color: #FFFFFF;
		background-color: inherit;
		border: none;
		outline: none;
	}

	.go-login.navigat-arrow {
		font-size: 38upx;
		color: #FFFFFF;
	}

	.login-title {
		height: 150upx;
		align-items: self-start;
		justify-content: center;
		flex-direction: column;
		margin-left: 20upx;
	}

	.center-list {
		background-color: #FFFFFF;
		margin-top: 20upx;
		width: 750upx;
		flex-direction: column;
	}

	.center-list-item {
		height: 90upx;
		width: 750upx;
		box-sizing: border-box;
		flex-direction: row;
		padding: 0upx 20upx;
	}

	.border-bottom {
		border-bottom-width: 1upx;
		border-color: #c8c7cc;
		border-bottom-style: solid;
	}

	.list-icon {
		width: 40upx;
		height: 90upx;
		line-height: 90upx;
		font-size: 34upx;
		color: rgb(52,150,245);
		text-align: center;
		font-family: texticons;
		margin-right: 20upx;
	}

	.list-text {
		height: 90upx;
		line-height: 90upx;
		font-size: 34upx;
		color: #555;
		flex: 1;
		text-align: left;
	}

	.navigat-arrow {
		height: 90upx;
		width: 40upx;
		line-height: 90upx;
		font-size: 34upx;
		color: #555;
		text-align: right;
		font-family: texticons;
	}
</style>