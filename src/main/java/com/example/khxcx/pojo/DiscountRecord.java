package com.example.khxcx.pojo;

public class DiscountRecord {
    //主键
    private long id;

    private long userId;
    //微信id
    private String uninId;
    //微信openid
    private String openId;
    //提款金额
    private double money;
    //提款时间
    private String time;
    //冗余字段
    private String blankSpaceOne;
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

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getUninId() {
        return uninId;
    }

    public void setUninId(String uninId) {
        this.uninId = uninId == null ? null : uninId.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}