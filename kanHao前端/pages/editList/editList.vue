<template>
	<view>
		<view class="uni-common-mt">
			<view class="uni-form-item uni-column">
				<view class="title">姓名</view>
				<input class="input" placeholder="请输入真实姓名" v-model="nameVal" />
			</view>
			<view class="uni-form-item uni-column">
				<view class="title">性别</view>
				<input type="text" class="input" name="emp_no" @tap='showEmpnoPicker' placeholder="请选择性别" v-model="sexVal"></input>
				<wzp-picker ref="wzpPicker" :mode="mode" :pickerList="pickerList" @onCancle="onCancle" @onConfirm="onConfirm"></wzp-picker>
			</view>
			<view class="uni-form-item uni-column">
				<view class="title">年龄</view>
				<input class="input" type="number" placeholder="请输入年龄" v-model="ageVal" />
			</view>
			<view class="uni-form-item uni-column">
				<view class="title">个人介绍</view>
				<textarea class="textarea" value="" placeholder="介绍一下自己吧" v-model="introduceVal" maxlength="50" />
			</view>
			<view class="uni-form-item uni-column">
				<view class="title">价值</view>
				<input class="input" type="number" placeholder="请设定你的价值" v-model="priceVal" />
			</view>
		</view>
		<button id="submitBtn" type="primary" @tap="submitFn">提交</button>
	</view>
</template>

<script>
	import BASEURL from "../../common/baseInfo.js";
	import wzpPicker from "../../components/wzp-picker/wzpPicker.vue"
	export default {
		data() {
			return {
				pickerList: [{
						label: "男"
					},
					{
						label: "女"
					}
				],
				sexVal: '',
				nameVal: '',
				ageVal: null,
				introduceVal: '',
				priceVal: null,
				uerInfo: {},
				openId: '',
			};
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
		components: {
			wzpPicker
		},
		methods: {
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
						that.ageVal = res.data.data.age;
						that.nameVal = res.data.data.givenName;
						that.sexVal = res.data.data.sex;
						that.introduceVal = res.data.data.introduce;
						that.priceVal = res.data.data.priece;
					},
					fail: (err) => {
						console.log(err);
					},
					complete: () => {}
				});
			},
			showEmpnoPicker: function(e) {
				this.$refs.wzpPicker.showPicker();
			},
			onCancle(res) {
				console.log(res);
			},
			onConfirm(res) {
				this.sexVal = this.pickerList[res[0]].label;
				console.log(this.sexVal);
				console.log(res);
			},
			submitFn() {
				let that = this;
				if (that.nameVal == '') {
					uni.showToast({
						title: '请填写真实姓名',
						icon: 'none',
						mask: false,
						duration: 2000
					});
					return;
				}
				if (that.sexVal == '') {
					uni.showToast({
						title: '请选择性别',
						icon: 'none',
						mask: false,
						duration: 2000
					});
					return;
				}
				if (that.ageVal == 0 || that.ageVal == null) {
					uni.showToast({
						title: '请填写年龄',
						icon: 'none',
						mask: false,
						duration: 2000
					});
					return;
				}
				if (that.priceVal == 0 || that.priceVal == null) {
					uni.showToast({
						title: '请填写个人价值',
						icon: 'none',
						mask: false,
						duration: 2000
					});
					return;
				}
				let submitData = {
					openId: that.openId,
					givenName: that.nameVal,
					age: that.ageVal,
					sex: that.sexVal,
					introduce: that.introduceVal,
					priece: that.priceVal
				}
				uni.request({
					url: `${BASEURL}/khxcx-0.0.1-SNAPSHOT/updateUserIfoByOpenId.action`,
					method: 'GET',
					data: submitData,
					success: res => {
						console.log(res);
						uni.showToast({
							title: '修改成功',
							mask: false,
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
.input{
	height: 60upx;
	line-height: 60upx;
}
.input,.textarea{
	box-sizing: border-box;
	width: 700upx;
	padding-left: 20upx;
	margin: 0 25upx;
	border: 1upx solid #f2f2f2;
}
#submitBtn{
	width: 700upx;
	margin-top: 40upx;
}
</style>
