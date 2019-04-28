<template>
	<view>
		<view class="logo-box">
			<image class="logo" src="../../static/logo.jpg" mode=""></image>
			<text class="appName">人人看好</text>
		</view>
		<view class="tips-box">
			“人人看好”申请获取你的微信授权
		</view>
		<button id="agreeBtn" type="primary" open-type="getUserInfo" @getuserinfo="agreeLogin">同意</button>
	</view>
</template>

<script>
	import BASEURL from "../../common/baseInfo.js";
	export default {
		data() {
			return {
				
			};
		},
		methods:{
			agreeLogin(res) {
				// console.log(res.detail.userInfo);
				let that = this;
				if (res.detail.userInfo) {
					uni.login({
					  provider: 'weixin',
					  success: function (loginRes) {
						// console.log(loginRes,'login');
						uni.request({
							url: `${BASEURL}/khxcx-0.0.1-SNAPSHOT/wxLogin?code=${loginRes.code}`,
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
											uni.navigateBack();
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
					  }
					});
				}
				
			}
		}
	}
</script>

<style lang="less">
	.logo-box{
		height: 200upx;
		padding-top: 100upx;
		display: flex;
		flex-direction: column;
		justify-content: flex-start;
		align-items: center;
		.logo{
			width: 150upx;
			height: 150upx;
		}
		.appName{
			font-size: 28upx;
			color: #999;
		}
	}
	.tips-box{
		display: flex;
		justify-content: center;
		align-items: center;
		height: 100upx;
	}
	#agreeBtn{
		width: 500upx;
		margin-top: 50upx;
	}
</style>
