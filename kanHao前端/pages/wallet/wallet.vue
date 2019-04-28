<template>
	<view>
		<view class="money-info-box">
			<text class="title">账户余额(元)</text>
			<text class="money">{{money}}</text>
		</view>
		<view class="uni-list">
			<view class="uni-list-cell" @tap="getMoney">
				<view class="uni-list-cell-navigate uni-navigate-right">
					提现
				</view>
			</view>
		</view>
		<!-- 居中 -->
		<uni-popup :show="showPopupMiddle" :type="popType" v-on:hidePopup="hidePopup">
			<view class="wx-info">
				<image class="img" :src="userInfo.avatarUrl" mode=""></image>
				<text class="text-info">{{userInfo.nickName}}</text>
			</view>
			<view class="money-box">
				<view class="title">提现金额</view>
				<view id="allMoney">{{money}}</view>
			</view>
			<button id="getAllBtn" type="primary" @tap="getAll">全部提现</button>
			<!-- <view class="uni-center" style="font-size:0;">
				<image class="image" style="width:150upx;height:150upx;" mode="widthFix" src="../../../static/uni.png" />
			</view>
			<view class="uni-common-mt uni-helllo-text uni-center">
				消息内容使用 slot 形式定义
			</view> -->
		</uni-popup>
	</view>
</template>

<script>
	import BASEURL from "../../common/baseInfo.js";
	import uniPopup from "../../components/uni-popup.vue";
	export default {
		data() {
			return {
				userInfo:{},
				openId: null,
				money: null,
				popType: 'middle',
				showPopupMiddle: false,
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
				success: function(res) {
					// console.log(JSON.parse(res));
					console.log(res);
					that.openId = res.data;
					that.getUserAppInfo();
				}
			})
		},
		components: {
			uniPopup
		},
		methods:{
			getUserAppInfo() {
				let that = this;
				uni.request({
					url: `${BASEURL}/khxcx-0.0.1-SNAPSHOT/findUserByOpenId.action`,
					method: 'GET',
					data: {
						openId: that.openId
					},
					success: res => {
						console.log(res.data.data.money);
						that.money = res.data.data.money;
					},
					fail: (err) => {
						console.log(err);
					},
					complete: () => {}
				});
			},
			//统一的关闭popup方法
			hidePopup: function() {
				this.showPopupMiddle = false;
				this.showPopupTop = false;
				this.showPopupBottom = false;
			},
			getMoney() {
				this.hidePopup();
				this.popType = 'middle';
				this.showPopupMiddle = true;
			},
			getAll() {
				let that = this;
				uni.request({
					url: `${BASEURL}/khxcx-0.0.1-SNAPSHOT/insertDiscountRecord.action?openId=${that.openId}`,
					method: 'POST',
					data: {
						// openId: that.openId
					},
					success: res => {
						console.log(res);
						uni.showToast({
							title: '提现申请发起成功',
							icon: 'success',
							mask: true,
							duration: 2000
						});
						that.getUserAppInfo();
						setTimeout(() => {
							that.hidePopup();
						},2000)
					},
					fail: () => {},
					complete: () => {}
				});
			}
		}
		
	}
</script>

<style lang="less">
.money-info-box{
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	height: 300upx;
	background: linear-gradient(to right, #04a9fe , #468ff2);
	color: #ffffff;
	.title{
		font-size: 28upx;
	}
	.money{
		font-size:36upx;
	}
}
.wx-info{
	display: flex;
	justify-content: flex-start;
	width: 100%;
	height: 80upx;
	border-bottom: 1upx solid #f2f2f2;
	.img{
		width: 80upx;
		height: 80upx;
		margin-right: 20upx;
	}
	.text-info{
		
	}
}
.money-box{
	display: flex;
	flex-direction: column;
	justify-content: flex-start;
	align-items: flex-start;
	box-sizing: border-box;
	width: 100%;
	height: 200upx;
	padding: 20upx 0;
	.title{
		font-size: 28upx;
	}
	#allMoney{
		margin-left: 30upx;
		font-size: 34upx;
	}
}
#getAllBtn{
	width: 100%;
}
</style>
