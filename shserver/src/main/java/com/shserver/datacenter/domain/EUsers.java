package com.shserver.datacenter.domain;

import java.util.Date;
/**
 * 用户类
 * @author labiStronger
 *
 */
public class EUsers {
	
    private Integer id;

    private String eUserName;

    private String ePassword;

    private String eNikeName;

    private String eDesc;

    private Integer eStatus;

    private Integer eRoleId;

    private Date eCreateDate;

    private Date eUpdateDate;

    private Integer eCreateUserId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String geteUserName() {
        return eUserName;
    }

    public void seteUserName(String eUserName) {
        this.eUserName = eUserName;
    }

    public String getePassword() {
        return ePassword;
    }

    public void setePassword(String ePassword) {
        this.ePassword = ePassword;
    }

    public String geteNikeName() {
        return eNikeName;
    }

    public void seteNikeName(String eNikeName) {
        this.eNikeName = eNikeName;
    }

    public String geteDesc() {
        return eDesc;
    }

    public void seteDesc(String eDesc) {
        this.eDesc = eDesc;
    }

    public Integer geteStatus() {
        return eStatus;
    }

    public void seteStatus(Integer eStatus) {
        this.eStatus = eStatus;
    }

    public Integer geteRoleId() {
        return eRoleId;
    }

    public void seteRoleId(Integer eRoleId) {
        this.eRoleId = eRoleId;
    }

    public Date geteCreateDate() {
        return eCreateDate;
    }

    public void seteCreateDate(Date eCreateDate) {
        this.eCreateDate = eCreateDate;
    }

    public Date geteUpdateDate() {
        return eUpdateDate;
    }

    public void seteUpdateDate(Date eUpdateDate) {
        this.eUpdateDate = eUpdateDate;
    }

    public Integer geteCreateUserId() {
        return eCreateUserId;
    }

    public void seteCreateUserId(Integer eCreateUserId) {
        this.eCreateUserId = eCreateUserId;
    }
}