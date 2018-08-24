package com.wx.platform.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 微信公众号账号配置
 */
@Entity
@Table(name = "wx_account_config")
public class WxAccountConfigModel implements Serializable {

    @Id
    @Column(name = "wx_id")
    private String wxId;

    /**
     * 公众号名称
     */
    @Column(name = "wx_name")
    private String wxName;

    /**
     * 公众号原始Id
     */
    @Column(name = "wx_source_id")
    private String wxSourceId;

    /**
     * 公众号账号
     */
    @Column(name = "wx_number")
    private String wxNumber;

    @Column(name = "wx_token")
    private String wxToken;

    @Column(name = "wx_app_id")
    private String wxAppId;

    @Column(name = "wx_app_secret")
    private String wxAppSecret;

    @Column(name = "wx_sort")
    private Integer wxSort;

    /**
     * 是否启用
     */
    @Column(name = "wx_is_valid")
    private Integer wxIsValid;

    /**
     * 公众号描述
     */
    @Column(name = "wx_description")
    private String wxDescription;

    public String getWxId() {
        return wxId;
    }

    public void setWxId(String wxId) {
        this.wxId = wxId;
    }

    public String getWxName() {
        return wxName;
    }

    public void setWxName(String wxName) {
        this.wxName = wxName;
    }

    public String getWxSourceId() {
        return wxSourceId;
    }

    public void setWxSourceId(String wxSourceId) {
        this.wxSourceId = wxSourceId;
    }

    public String getWxNumber() {
        return wxNumber;
    }

    public void setWxNumber(String wxNumber) {
        this.wxNumber = wxNumber;
    }

    public String getWxToken() {
        return wxToken;
    }

    public void setWxToken(String wxToken) {
        this.wxToken = wxToken;
    }

    public String getWxAppId() {
        return wxAppId;
    }

    public void setWxAppId(String wxAppId) {
        this.wxAppId = wxAppId;
    }

    public String getWxAppSecret() {
        return wxAppSecret;
    }

    public void setWxAppSecret(String wxAppSecret) {
        this.wxAppSecret = wxAppSecret;
    }

    public Integer getWxSort() {
        return wxSort;
    }

    public void setWxSort(Integer wxSort) {
        this.wxSort = wxSort;
    }

    public Integer getWxIsValid() {
        return wxIsValid;
    }

    public void setWxIsValid(Integer wxIsValid) {
        this.wxIsValid = wxIsValid;
    }

    public String getWxDescription() {
        return wxDescription;
    }

    public void setWxDescription(String wxDescription) {
        this.wxDescription = wxDescription;
    }

}
