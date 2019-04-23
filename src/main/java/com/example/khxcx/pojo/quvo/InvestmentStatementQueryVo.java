package com.example.khxcx.pojo.quvo;

/**
 * @Auther:沈泽鹏
 * @Date: 2019/3/20 00:00
 * @Description: 沈泽鹏写点注释吧
 */
public class InvestmentStatementQueryVo {
    //主键id
    private long id;
    //userID
    private long userId;
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
    //主键id
    private long investmentStatementId;
    //买方id;
    private long buyerId;
    //被买放id;
    private long sellerId;
    //购入量
    private double purchaseVolume;
    //购入价格
    private double purchasePrice;
    private String imgUrl;
    private String yimaichu;

    public String getYimaichu() {
        return yimaichu;
    }

    public void setYimaichu(String yimaichu) {
        this.yimaichu = yimaichu;
    }

    @Override
    public String toString() {
        return "InvestmentStatementQueryVo{" +
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
                ", investmentStatementId=" + investmentStatementId +
                ", buyerId=" + buyerId +
                ", sellerId=" + sellerId +
                ", purchaseVolume=" + purchaseVolume +
                ", purchasePrice=" + purchasePrice +
                ", imgUrl='" + imgUrl + '\'' +
                ", yimaichu='" + yimaichu + '\'' +
                '}';
    }

    public InvestmentStatementQueryVo(long id, long userId, String type, String givenName, String age, String sex, String introduce, double priece, double lastPriece, double shengyugoumailaing, String phoneNumber, long investmentStatementId, long buyerId, long sellerId, double purchaseVolume, double purchasePrice, String imgUrl, String yimaichu) {
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.givenName = givenName;
        this.age = age;
        this.sex = sex;
        this.introduce = introduce;
        this.priece = priece;
        this.lastPriece = lastPriece;
        this.shengyugoumailaing = shengyugoumailaing;
        this.phoneNumber = phoneNumber;
        this.investmentStatementId = investmentStatementId;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.purchaseVolume = purchaseVolume;
        this.purchasePrice = purchasePrice;
        this.imgUrl = imgUrl;
        this.yimaichu = yimaichu;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public InvestmentStatementQueryVo(long id, long userId, String type, String givenName, String age, String sex, String introduce, double priece, double lastPriece, double shengyugoumailaing, String phoneNumber, long investmentStatementId, long buyerId, long sellerId, double purchaseVolume, double purchasePrice, String imgUrl) {
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.givenName = givenName;
        this.age = age;
        this.sex = sex;
        this.introduce = introduce;
        this.priece = priece;
        this.lastPriece = lastPriece;
        this.shengyugoumailaing = shengyugoumailaing;
        this.phoneNumber = phoneNumber;
        this.investmentStatementId = investmentStatementId;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.purchaseVolume = purchaseVolume;
        this.purchasePrice = purchasePrice;
        this.imgUrl = imgUrl;
    }

    public InvestmentStatementQueryVo() {
    }

    public InvestmentStatementQueryVo(long id, long userId, String type, String givenName, String age, String sex, String introduce, double priece, double lastPriece, double shengyugoumailaing, String phoneNumber, long investmentStatementId, long buyerId, long sellerId, double purchaseVolume, double purchasePrice) {
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.givenName = givenName;
        this.age = age;
        this.sex = sex;
        this.introduce = introduce;
        this.priece = priece;
        this.lastPriece = lastPriece;
        this.shengyugoumailaing = shengyugoumailaing;
        this.phoneNumber = phoneNumber;
        this.investmentStatementId = investmentStatementId;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.purchaseVolume = purchaseVolume;
        this.purchasePrice = purchasePrice;
    }

    public long getInvestmentStatementId() {
        return investmentStatementId;
    }

    public void setInvestmentStatementId(long investmentStatementId) {
        this.investmentStatementId = investmentStatementId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    public long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(long buyerId) {
        this.buyerId = buyerId;
    }

    public long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
    }

    public double getPurchaseVolume() {
        return purchaseVolume;
    }

    public void setPurchaseVolume(double purchaseVolume) {
        this.purchaseVolume = purchaseVolume;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

}
