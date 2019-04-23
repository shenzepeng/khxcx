package com.example.khxcx.pojo;

public class MakeSurePayIdOk {
    private Long id;

    private String blankSpaceOne;

    private String blankSpaceThree;

    private String blankSpaceTwo;

    private String createTime;

    private String opendId;

    private String orderId;
    //1.未支付成功或待支付，0支付成功
    private Integer status;

    @Override
    public String toString() {
        return "MakeSurePayIdOk{" +
                "id=" + id +
                ", blankSpaceOne='" + blankSpaceOne + '\'' +
                ", blankSpaceThree='" + blankSpaceThree + '\'' +
                ", blankSpaceTwo='" + blankSpaceTwo + '\'' +
                ", createTime='" + createTime + '\'' +
                ", opendId='" + opendId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", status=" + status +
                '}';
    }

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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getOpendId() {
        return opendId;
    }

    public void setOpendId(String opendId) {
        this.opendId = opendId == null ? null : opendId.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}