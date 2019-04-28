<template>
	<view>
		<view class="user">
			<image class="user-img" :src="userInfo.avatarUrl" mode=""></image>
			<text class="user-nackName">{{userInfo.nickName}}</text>
		</view>
		<form class="auth-box">
			<view class="input-item">
				<input id="phoneInput" class="input" type="number" name="phone" v-model="phoneVal" value="" placeholder="请输入手机号" maxlength="11" />
				<text id="getCode" @tap="getCheckTextFn" v-if="!countdown">获取验证码</text>
				<text id="showCountdown" v-else>{{countdown}}</text>
			</view>
			<view class="input-item">
				<input class="input" type="number" name="code" v-model="codeVal" value="" placeholder="请输入验证码"/>
			</view>
		</form>
		<button id="submitBtn" type="primary" @tap="submitForm">提交</button>
		<!-- <view id="formBox">
		    <label id="mobileLabel" for="mobile">
		      <input id="mobile" type="tel" name="" placeholder="请输入手机号">
		      <button id="getCheckText" type="button" name="" class="active">获取验证码</button>
		    </label>
		    <label id="checkTextLabel" class="active" for="checkText"><input id="checkText" type="number" name="" placeholder="请输入验证码"></label>
		    <label id="passwordLabel" for="password"><input id="password" type="password" name="" placeholder="请输入密码"></label>
		    <button id="signIn" type="button" name="button" data-loginType="1">登录</button>
		</view> -->
	</view>
</template>

<script>
	import BASEURL from "../../common/baseInfo.js";
	import graceChecker from "../../common/graceChecker.js";
	export default {
		data() {
			return {
				openId: '',
				userInfo:{},
				userPhone: '',
				phoneVal: null,
				countdown: null,
				codeVal: null
			};
		},
		onLoad() {
			let that = this;
			uni.getStorage({
				key: 'userInfo',
				success: function (res) {
					// console.log(JSON.parse(res));
					console.log(res.data);
					that.userInfo = res.data;
				}
			})
			uni.getStorage({
				key: 'openIdInfo',
				success: function (res) {
					// console.log(JSON.parse(res));
					console.log(res);
					that.openId = res.data;
				}
			})
		},
		methods:{
			// 点击获取验证码
			getCheckTextFn:function () {
				console.log(111);
				var that = this,
					regphone = /^(13\d|14[57]|15[012356789]|18\d|17[013678])\d{8}$/;
				  //进行表单检查
				  console.log(that.phoneVal);
				  if(!regphone.test(that.phoneVal)) {
					  uni.showToast({title:"请输入正确的手机号", icon:"none"});
					  return;
				  }
// 				  var sn = 60;
// 				  var timer = setInterval(function(){
// 				  	sn--;
// 				  	that.countdown = '重新发送'+'('+sn+')';
// 				  	if(sn == 0){
// 				  		clearInterval(timer);
// 				  		that.countdown = null;
// 				  	}
// 				  },1000);
				  uni.request({
				  	url: `${BASEURL}/khxcx-0.0.1-SNAPSHOT/getSmsNumber.action`,
				  	method: 'GET',
				  	data: {
						"phoneNumber":that.phoneVal
					},
				  	success: res => {
						console.log(res);
						//服务器返回响应，根据响应结果，分析是否登录成功；
						var sn = 60;
						var timer = setInterval(function(){
							sn--;
							that.countdown = '重新发送'+'('+sn+')';
							if(sn == 0){
								clearInterval(timer);
								that.countdown = null;
							}
						},1000);
					},
				  	fail: (err) => {
						console.log(err);
					},
				  	complete: () => {}
				  });
			},
			submitForm() {
				var that = this,
					regphone = /^(13\d|14[57]|15[012356789]|18\d|17[013678])\d{8}$/;
				  //进行表单检查
				  console.log(that.phoneVal);
				  if(!regphone.test(that.phoneVal)) {
					  uni.showToast({title:"请输入正确的手机号", icon:"none"});
					  return;
				  }
				  if (that.codeVal == null || that.codeVal.length != 4) {
					  uni.showToast({title:"请输入正确的验证码", icon:"none"});
					  return;
				  }
				  uni.request({
				  	url: `${BASEURL}/khxcx-0.0.1-SNAPSHOT/verifyByMobileNumber.action`,
				  	method: 'GET',
				  	data: {
						openId: that.openId,
						phoneNumber:that.phoneVal,
						code:that.codeVal
						},
				  	success: res => {
						console.log(res);
						uni.showToast({
							title: '验证成功',
							icon: 'success',
							mask: true,
							duration: 2000
						});
						setTimeout(() => {
							uni.navigateBack();
						},2000)
					},
				  	fail: (err) => {
						console.log(err);
					},
				  	complete: () => {}
				  });
			}
		}
	}
</script>

<style lang="less">
.user{
	display: flex;
	flex-direction: column;
	justify-content: flex-start;
	align-items: center;
	.user-img{
		width: 200upx;
		height: 200upx;
		border-radius: 50%;
	}
	.user-nickName{
		
	}
}
.auth-box{
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: flex-start;
	padding-bottom: 60upx;
	.input-item{
		position: relative;
		width: 700upx;
		height: 80upx;
		margin-bottom: 30upx;
		.input{
			box-sizing: border-box;
			width: 100%;
			height: 100%;
			padding-left: 30upx;
			background-color: #f4f6f8;
			&#phoneInput{
				width: 500upx;
			}
		}
		#getCode,#showCountdown{
			position: absolute;
			right: 0;
			top: 50%;
			transform: translateY(-50%);
			width: 200upx;
			height: 80upx;
			line-height: 80upx;
			text-align: center;
			color: #ffffff;
			background-color: #00abec;
		}
	}
}
#submitBtn{
	width: 700upx;
}
</style>
