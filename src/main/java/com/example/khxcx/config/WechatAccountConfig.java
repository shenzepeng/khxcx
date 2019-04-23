package com.example.khxcx.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Map;



@Component
@PropertySource(value="classpath:application.properties")
public class WechatAccountConfig {
    /**
     * 公众平台id
     */
    @Value("${wechat.mpAppId}")
    private String mpAppId;

    /**
     * 公众平台密钥
     */
    @Value("${wechat.mpAppSecret}")
    private String mpAppSecret;

    /**
     * 开放平台id
     */
    @Value("${wechat.mpAppId}")
    private String openAppId;

    /**
     * 开放平台密钥
     */
    @Value("${wechat.mpAppSecret}")
    private String openAppSecret;

    /**
     * 商户号
     */
    @Value("${wechat.mchId}")
    private String mchId;

    /**
     * 商户密钥
     */
    @Value("${wechat.mchKey}")
    private String mchKey;

    /**
     * 商户证书路径
     */
   // @Value("${wechat.keyPath}")
    private String keyPath;

    /**
     * 微信支付异步通知地址
     */
    @Value("${wechat.notifyUrl}")
    private String notifyUrl;

    /**
     * 微信模版id
     */
    private Map<String, String> templateId;

    public String getMpAppId() {
        return mpAppId;
    }

    public void setMpAppId(String mpAppId) {
        this.mpAppId = mpAppId;
    }

    public String getMpAppSecret() {
        return mpAppSecret;
    }

    public void setMpAppSecret(String mpAppSecret) {
        this.mpAppSecret = mpAppSecret;
    }

    public String getOpenAppId() {
        return openAppId;
    }

    public void setOpenAppId(String openAppId) {
        this.openAppId = openAppId;
    }

    public String getOpenAppSecret() {
        return openAppSecret;
    }

    public void setOpenAppSecret(String openAppSecret) {
        this.openAppSecret = openAppSecret;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getMchKey() {
        return mchKey;
    }

    public void setMchKey(String mchKey) {
        this.mchKey = mchKey;
    }

    public String getKeyPath() {
        return keyPath;
    }

    public void setKeyPath(String keyPath) {
        this.keyPath = keyPath;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public Map<String, String> getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Map<String, String> templateId) {
        this.templateId = templateId;
    }

    @Override
    public String toString() {
        return "WechatAccountConfig{" +
                "mpAppId='" + mpAppId + '\'' +
                ", mpAppSecret='" + mpAppSecret + '\'' +
                ", openAppId='" + openAppId + '\'' +
                ", openAppSecret='" + openAppSecret + '\'' +
                ", mchId='" + mchId + '\'' +
                ", mchKey='" + mchKey + '\'' +
                ", keyPath='" + keyPath + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                ", templateId=" + templateId +
                '}';
    }
}
