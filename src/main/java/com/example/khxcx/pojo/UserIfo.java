package com.example.khxcx.pojo;

//userifo
public class UserIfo {

    private long id;

    private long userId;

    private String type;

    private String givenName;

    private String age;

    private String sex;

    private String introduce;

    private double priece;

    private double lastPriece;

    private double shengyugoumailaing;

    private String phoneNumber;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
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

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName == null ? null : givenName.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public Double getLastPriece() {
        return lastPriece;
    }

    public void setLastPriece(Double lastPriece) {
        this.lastPriece = lastPriece;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public Double getPriece() {
        return priece;
    }

    public void setPriece(Double priece) {
        this.priece = priece;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Double getShengyugoumailaing() {
        return shengyugoumailaing;
    }

    public void setShengyugoumailaing(Double shengyugoumailaing) {
        this.shengyugoumailaing = shengyugoumailaing;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserIfo{" +
                "id=" + id +
                ", userId=" + userId +
                ", type='" + type + '\'' +
                ", givenName='" + givenName + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", introduce='" + introduce + '\'' +
                ", priece=" + priece +
                ", lastPriece=" + lastPriece +
                ", shengyugoumailaing=" + shengyugoumailaing +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", blankSpaceOne='" + blankSpaceOne + '\'' +
                ", blankSpaceTwo='" + blankSpaceTwo + '\'' +
                ", blankSpaceThree='" + blankSpaceThree + '\'' +
                '}';
    }
}