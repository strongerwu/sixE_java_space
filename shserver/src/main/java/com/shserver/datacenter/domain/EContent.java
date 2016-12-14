package com.shserver.datacenter.domain;

import java.util.Date;

import com.shserver.base.utils.Tools;
/**
 * 内容类
 * @author labiStronger
 *
 */
public class EContent {
	
    private Integer id;

    private String coTitle;

    private String coUrl;

    private String coDesc;

    private String coImgUrl;

    private Integer coSeType;

    private Integer coStatus;

    private Integer coType;

    private Date coCreateDate;

    private Integer coCreateUserId;

    private Date coUpdateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoTitle() {
        return coTitle;
    }

    public void setCoTitle(String coTitle) {
        this.coTitle = coTitle;
    }

    public String getCoUrl() {
        return coUrl;
    }

    public void setCoUrl(String coUrl) {
        this.coUrl = coUrl;
    }

    public String getCoDesc() {
        return coDesc;
    }

    public void setCoDesc(String coDesc) {
        this.coDesc = coDesc;
    }

    public String getCoImgUrl() {
        return coImgUrl;
    }

    public void setCoImgUrl(String coImgUrl) {
        this.coImgUrl = coImgUrl;
    }

    public Integer getCoSeType() {
        return coSeType;
    }

    public void setCoSeType(Integer coSeType) {
        this.coSeType = coSeType;
    }

    public Integer getCoStatus() {
        return coStatus;
    }

    public void setCoStatus(Integer coStatus) {
        this.coStatus = coStatus;
    }

    public Integer getCoType() {
        return coType;
    }

    public void setCoType(Integer coType) {
        this.coType = coType;
    }

    public Date getCoCreateDate() {
        return coCreateDate;
    }

    public void setCoCreateDate(Date coCreateDate) {
        this.coCreateDate = coCreateDate;
    }

    public Integer getCoCreateUserId() {
        return coCreateUserId;
    }

    public void setCoCreateUserId(Integer coCreateUserId) {
        this.coCreateUserId = coCreateUserId;
    }

    public Date getCoUpdateDate() {
        return coUpdateDate;
    }

    public void setCoUpdateDate(Date coUpdateDate) {
        this.coUpdateDate = coUpdateDate;
    }
    
    @Override
	public String toString() {
		return "EContent [id=" + id + ", coTitle=" + coTitle + ", coUrl="
				+ coUrl + ", coDesc=" + coDesc + ", coImgUrl=" + coImgUrl
				+ ", coSeType=" + coSeType + ", coStatus=" + coStatus
				+ ", coType=" + coType + ", coCreateDate=" + Tools.formatyyyyMMdd(coCreateDate)
				+ ", coCreateUserId=" + coCreateUserId + ", coUpdateDate="
				+ Tools.formatyyyyMMdd(coUpdateDate) + "]";
	}
}