package com.wx.platform.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 微信公众号菜单配置
 */
@Entity
@Table(name = "wx_account_menu_config")
public class WxAccountMenuConfigModel implements Serializable {

    @Id
    @Column(name = "wx_menu_id")
    private String wxMenuId;

    /**
     * 微信公众号Id
     */
    @Column(name = "wx_id")
    private String wxId;

    /**
     * 菜单名称
     */
    @Column(name = "wx_menu_name")
    private String wxMenuName;

    /**
     * 菜单的Key值
     */
    @Column(name = "wx_menu_key")
    private String wxMenuKey;

    /**
     * 菜单配置地址
     */
    @Column(name = "wx_menu_url")
    private String wxMenuUrl;

    /**
     * 是否有效
     */
    @Column(name = "wx_is_valid")
    private Integer wxIsValid;

    /**
     * 菜单描述
     */
    @Column(name = "wx_menu_description")
    private String wxMenuDescription;

    public String getWxMenuId() {
        return wxMenuId;
    }

    public void setWxMenuId(String wxMenuId) {
        this.wxMenuId = wxMenuId;
    }

    public String getWxId() {
        return wxId;
    }

    public void setWxId(String wxId) {
        this.wxId = wxId;
    }

    public String getWxMenuName() {
        return wxMenuName;
    }

    public void setWxMenuName(String wxMenuName) {
        this.wxMenuName = wxMenuName;
    }

    public String getWxMenuKey() {
        return wxMenuKey;
    }

    public void setWxMenuKey(String wxMenuKey) {
        this.wxMenuKey = wxMenuKey;
    }

    public String getWxMenuUrl() {
        return wxMenuUrl;
    }

    public void setWxMenuUrl(String wxMenuUrl) {
        this.wxMenuUrl = wxMenuUrl;
    }

    public Integer getWxIsValid() {
        return wxIsValid;
    }

    public void setWxIsValid(Integer wxIsValid) {
        this.wxIsValid = wxIsValid;
    }

    public String getWxMenuDescription() {
        return wxMenuDescription;
    }

    public void setWxMenuDescription(String wxMenuDescription) {
        this.wxMenuDescription = wxMenuDescription;
    }

}
