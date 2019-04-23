package com.example.khxcx.pojo;

public class User {
    //主键
    private long id;
    //微信id
    private String uninId;
    //微信openid
    private String openId;

    private String nickName;

    private String imgUrl;

    private double money;
    //冗余字段
    //标记是否为水军
    private String blankSpaceOne;
    //创建时间
    private String blankSpaceTwo;
    private String blankSpaceThree;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBlankSpaceOne() {
        return blankSpaceOne;
    }

    public void setBlankSpaceOne(String blankSpaceOne) {
        this.blankSpaceOne = blankSpaceOne == null ? null : blankSpaceOne.trim();
    }

    public String getBlankSpaceThree() {
        return blankSpaceThree;
    }

    public void setBlankSpaceThree(String blankSpaceThree) {
        this.blankSpaceThree = blankSpaceThree == null ? null : blankSpaceThree.trim();
    }

    public String getBlankSpaceTwo() {
        return blankSpaceTwo;
    }

    public void setBlankSpaceTwo(String blankSpaceTwo) {
        this.blankSpaceTwo = blankSpaceTwo == null ? null : blankSpaceTwo.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getUninId() {
        return uninId;
    }

    public void setUninId(String uninId) {
        this.uninId = uninId == null ? null : uninId.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uninId='" + uninId + '\'' +
                ", openId='" + openId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", money=" + money +
                ", blankSpaceOne='" + blankSpaceOne + '\'' +
                ", blankSpaceTwo='" + blankSpaceTwo + '\'' +
                ", blankSpaceThree='" + blankSpaceThree + '\'' +
                '}';
    }
}