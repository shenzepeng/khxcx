<template>
	<view>
		<view class="list-info">
			<view class="list-item">
				<text class="label">姓名:</text>
				<text class="info">{{detail.name}}</text>
			</view>
			<view class="list-item">
				<text class="label">性别:</text>
				<text class="info">{{detail.sex}}</text>
			</view>
			<view class="list-item">
				<text class="label">年龄:</text>
				<text class="info">{{detail.age}}</text>
			</view>
			<view class="list-item">
				<text class="label">个人介绍:</text>
				<text class="info">{{detail.personal}}</text>
			</view>
			<view class="list-item">
				<text class="label">当前价值:</text>
				<text class="info">¥{{detail.price}}</text>
			</view>
		</view>
		<button id="editInfo" type="primary" @tap="goEditList">编辑上市信息</button>
	</view>
</template>

<script>
	import BASEURL from "../../common/baseInfo.js";
	export default {
		data() {
			return {
				detail:{
					name: '',
					sex: '',
					age: 0,
					personal: '',
					price: 0
				},
				uerInfo: {},
				openId: '',
			};
		},
		onShow() {
			this.getUserAppInfo();
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
		},
		methods:{
			goEditList () {
				let that = this;
				uni.navigateTo({
					url: '../editList/editList?name='+that.detail.name+'&sex='+that.detail.sex+'&age='+that.detail.age+'&introduce='+that.detail.personal+'&price='+that.detail.price
				});
			},
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
						that.detail.age = res.data.data.age;
						that.detail.name = res.data.data.givenName;
						that.detail.sex = res.data.data.sex;
						that.detail.personal = res.data.data.introduce;
						that.detail.price = res.data.data.priece;
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
.list-info{
	display: flex;
	flex-direction: column;
	justify-content: flex-start;
	align-items: flex-start;
	padding: 0 30upx;
	margin: 30upx;
	border: 1upx solid #f2f2f2;
	.list-item{
		display: flex;
		justify-content: flex-start;
		align-items: flex-start;
		padding: 20upx 0;
		.label{
			padding-right: 20upx;
		}
		.info{
			max-width: 490upx;
		}
	}
}
#editInfo{
	width: 700upx;
}
</style>
