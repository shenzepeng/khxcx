package com.example.khxcx.pojo;

public class ShenQingTiXian {
    private Long id;

    private String blankSpaceOne;

    private String blankSpaceThree;

    private String blankSpaceTwo;

    private Double money;

    private String openId;

    private String phoneNumber;

    private String status;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    @Override
    public String toString() {
        return "ShenQingTiXian{" +
                "id=" + id +
                ", blankSpaceOne='" + blankSpaceOne + '\'' +
                ", blankSpaceThree='" + blankSpaceThree + '\'' +
                ", blankSpaceTwo='" + blankSpaceTwo + '\'' +
                ", money=" + money +
                ", openId='" + openId + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}