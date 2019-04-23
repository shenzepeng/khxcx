package com.example.khxcx.pojo.quvo;

/**
 * @Auther:沈泽鹏
 * @Date: 2019/3/18 19:58
 * @Description: 沈泽鹏写点注释吧
 */
public class MobileNumber {
    private String openId;
    private String phoneNumber;
    private String code;

    @Override
    public String toString() {
        return "MobileNumber{" +
                "openId='" + openId + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
