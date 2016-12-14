package com.shserver.datacenter.domain;

import java.util.Date;

public class ESection {
    private Integer id;

    private String seName;

    private Integer seStatus;

    private Integer seType;

    private String seDesc;

    private Date seCreateDate;

    private Integer seCreateUserId;

    private Date seUpdateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSeName() {
        return seName;
    }

    public void setSeName(String seName) {
        this.seName = seName;
    }

    public Integer getSeStatus() {
        return seStatus;
    }

    public void setSeStatus(Integer seStatus) {
        this.seStatus = seStatus;
    }

    public Integer getSeType() {
        return seType;
    }

    public void setSeType(Integer seType) {
        this.seType = seType;
    }

    public String getSeDesc() {
        return seDesc;
    }

    public void setSeDesc(String seDesc) {
        this.seDesc = seDesc;
    }

    public Date getSeCreateDate() {
        return seCreateDate;
    }

    public void setSeCreateDate(Date seCreateDate) {
        this.seCreateDate = seCreateDate;
    }

    public Integer getSeCreateUserId() {
        return seCreateUserId;
    }

    public void setSeCreateUserId(Integer seCreateUserId) {
        this.seCreateUserId = seCreateUserId;
    }

    public Date getSeUpdateDate() {
        return seUpdateDate;
    }

    public void setSeUpdateDate(Date seUpdateDate) {
        this.seUpdateDate = seUpdateDate;
    }
}