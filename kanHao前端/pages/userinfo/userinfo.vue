<template>
	<view>
		<view class="uni-list">
			<view class="uni-list-cell" hover-class="uni-list-cell-hover">
				<view class="uni-list-cell-navigate">
					昵称
					<text class="info">{{userInfo.nickName}}</text>
				</view>
			</view>
			<view class="uni-list-cell" hover-class="uni-list-cell-hover">
				<view class="uni-list-cell-navigate">
					头像
					<image class="info info-img" :src="userInfo.avatarUrl" mode=""></image>
				</view>
			</view>
			<!-- <view class="uni-list-cell" hover-class="uni-list-cell-hover">
				<view class="uni-list-cell-navigate uni-navigate-right">
					微信
					<text class="info">{{}}</text>
				</view>
			</view> -->
			<view class="uni-list-cell" hover-class="uni-list-cell-hover">
				<view class="uni-list-cell-navigate">
					手机号
					<text class="info">{{userPhone ? userPhone : '未认证'}}</text>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	import BASEURL from "../../common/baseInfo.js";
	export default {
		data() {
			return {
				userInfo:{},
				userPhone: ''
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
						console.log(res);
						that.userPhone = res.data.data.phoneNumber;
// 						if (res.data.data.type === '上市者') {
// 							that.checkedInfo = true;
// 						} else {
// 							that.checkedInfo = false;
// 						}
					},
					fail: (err) => {
						console.log(err);
					},
					complete: () => {}
				});
			},
// 			checkInfo() {
// 				if (!this.userPhone) {
// 					uni.navigateTo({
// 						url: '../authPhone/authPhone'
// 					});
// 				}
// 			}
		}
	}
</script>

<style lang="less">
.info{
	// margin-right: 10upx;
	&.info-img{
		width: 50upx;
		height: 50upx;
		border-radius: 50%;
	}
}
</style>
