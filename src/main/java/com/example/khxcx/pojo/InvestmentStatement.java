package com.example.khxcx.pojo;

public class InvestmentStatement {

    private long id;

    private long buyerId;

    private long sellerId;

    private double purchaseVolume;

    private double purchasePrice;
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

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Double getPurchaseVolume() {
        return purchaseVolume;
    }

    public void setPurchaseVolume(Double purchaseVolume) {
        this.purchaseVolume = purchaseVolume;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    @Override
    public String toString() {
        return "InvestmentStatement{" +
                "id=" + id +
                ", buyerId=" + buyerId +
                ", sellerId=" + sellerId +
                ", purchaseVolume=" + purchaseVolume +
                ", purchasePrice=" + purchasePrice +
                ", blankSpaceOne='" + blankSpaceOne + '\'' +
                ", blankSpaceTwo='" + blankSpaceTwo + '\'' +
                ", blankSpaceThree='" + blankSpaceThree + '\'' +
                '}';
    }
}