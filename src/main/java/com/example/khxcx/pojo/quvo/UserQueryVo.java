package com.example.khxcx.pojo.quvo;

import com.example.khxcx.pojo.User;
import com.example.khxcx.pojo.UserIfo;
import com.example.khxcx.service.UserIfoService;

/**
 * @Auther: SualLabel
 * @Date: 2019-03-13 22:45
 * @Description: SualLabel, Write down some description!!!
 */
public class UserQueryVo {
    private long userId;
    //userIfo
    //主键
    private long id;
    //微信id
    private String uninId;
    //微信openid
    private String openId;
    //昵称
    private String nickName;
    //头像
    private String imgUrl;
    //钱包余额
    private double money;
    //userifo
    //主键id
    private long userIfoId;
    //用户类型
    private String type;
    //真实姓名
    private String givenName;
    //年龄
    private String age;
    //性别
    private String sex;
    //自我介绍
    private String introduce;
    //价值
    private double priece;
    //上一次的价值
    private double lastPriece;
    //剩余购买量
    private double shengyugoumailaing;
    //手机号
    private String phoneNumber;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserQueryVo{" +
                "userId=" + userId +
                ", id=" + id +
                ", uninId='" + uninId + '\'' +
                ", openId='" + openId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", money=" + money +
                ", userIfoId=" + userIfoId +
                ", type='" + type + '\'' +
                ", givenName='" + givenName + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", introduce='" + introduce + '\'' +
                ", priece=" + priece +
                ", lastPriece=" + lastPriece +
                ", shengyugoumailaing=" + shengyugoumailaing +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public UserQueryVo(long id, String uninId, String openId, String nickName, String imgUrl, double money, long userIfoId, String type, String givenName, String age, String sex, String introduce, double priece, double lastPriece, double shengyugoumailaing, String phoneNumber) {
        this.id = id;
        this.uninId = uninId;
        this.openId = openId;
        this.nickName = nickName;
        this.imgUrl = imgUrl;
        this.money = money;
        this.userIfoId = userIfoId;
        this.type = type;
        this.givenName = givenName;
        this.age = age;
        this.sex = sex;
        this.introduce = introduce;
        this.priece = priece;
        this.lastPriece = lastPriece;
        this.shengyugoumailaing = shengyugoumailaing;
        this.phoneNumber = phoneNumber;
    }

    public UserQueryVo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUninId() {
        return uninId;
    }

    public void setUninId(String uninId) {
        this.uninId = uninId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public long getUserIfoId() {
        return userIfoId;
    }

    public void setUserIfoId(long userIfoId) {
        this.userIfoId = userIfoId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public double getPriece() {
        return priece;
    }

    public void setPriece(double priece) {
        this.priece = priece;
    }

    public double getLastPriece() {
        return lastPriece;
    }

    public void setLastPriece(double lastPriece) {
        this.lastPriece = lastPriece;
    }

    public double getShengyugoumailaing() {
        return shengyugoumailaing;
    }

    public void setShengyugoumailaing(double shengyugoumailaing) {
        this.shengyugoumailaing = shengyugoumailaing;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
