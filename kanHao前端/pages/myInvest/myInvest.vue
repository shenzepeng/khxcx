<template>
	<view>
		<view class="uni-list">
			<view class="uni-list-cell" hover-class="uni-list-cell-hover" v-for="(value,key) in personList" :key="key" @tap="openDetail(value.investmentStatementId,value.userQueryVo.userId)" v-if="(value.blankSpaceOne != '已卖出')">
				<view class="uni-media-list">
					<view class="uni-media-list-logo">
						<image :src="value.userQueryVo.imgUrl"></image>
					</view>
					<view class="uni-media-list-body">
						<view class="uni-media-list-text-top">{{value.userQueryVo.givenName}}</view>
						<view class="uni-media-list-text-bottom uni-ellipsis">{{value.userQueryVo.introduce}}</view>
						<view class="money-box">
							<text class="money">¥{{value.userQueryVo.priece}}</text>
							<!-- <text class="change">{{value.change}}</text> -->
						</view>
					</view>
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
				personList:[],
				uerInfo: {},
				openId: '',
			};
		},
		onShow() {
			this.getData(this.openId);
		},
		onLoad() {
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
					that.getData(res.data)
				}
			})
		},
		methods:{
			openDetail(id,sellerId) {
				console.log(sellerId);
				uni.navigateTo({
					url: '../investDetail/investDetail?id='+id+'&sellerId='+sellerId
				});
			},
			getData (openId) {
				let that = this;
				uni.request({
					url: `${BASEURL}/khxcx-0.0.1-SNAPSHOT/findSellerByOwnOpenIdServiceByO.action`,
					method: 'GET',
					data: {
						openId: openId
					},
					success: res => {
						console.log(res.data.data);
						let personList = [];
						for (let value in res.data.data) {
							console.log(res.data.data[value]);
							personList.push(res.data.data[value]);
						}
// 						for (let [key,value] of res.data.data) {
// 							console.log(value);
// 						  }
						that.personList = personList;
					},
					fail: () => {},
					complete: () => {}
				});
			}
		}
	}
</script>

<style lang="less">
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
</style>
