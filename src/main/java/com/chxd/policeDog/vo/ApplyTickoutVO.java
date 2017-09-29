package com.chxd.policeDog.vo;

import java.util.Date;

/**
 * Created by cheng on 2017/9/28.
 */
public class ApplyTickoutVO extends BaseVO {
    private String  applyUnit;	//申请单位
    private Integer  dogId;	//
    private String  applyUser;	//申请人员
    private Date tickoutDate;	//淘汰日期
    private String tickoutDateStr;	//淘汰日期
    private String  tickoutReason;	//淘汰原因
    private String  tickoutDesc;	//备注
    private Integer  applyState;	//1：待审批，2：通过，3：驳回
    private String  approveDetail;	//审批意见
    private Date  approveDate;	//
    private String  approveDateStr;	//
    private Date  applyDate;	//申请日期
    private String  applyDateStr;	//申请日期

    private String belongTo;

    private DogBaseInfoVO dogInfo;

    public String getBelongTo() {
        return belongTo;
    }

    public void setBelongTo(String belongTo) {
        this.belongTo = belongTo;
    }

    public DogBaseInfoVO getDogInfo() {
        return dogInfo;
    }

    public void setDogInfo(DogBaseInfoVO dogInfo) {
        this.dogInfo = dogInfo;
    }

    public String getApplyDateStr() {
        return applyDateStr;
    }

    public void setApplyDateStr(String applyDateStr) {
        this.applyDateStr = applyDateStr;
    }

    public String getApplyUnit() {
        return applyUnit;
    }

    public void setApplyUnit(String applyUnit) {
        this.applyUnit = applyUnit;
    }

    public Integer getDogId() {
        return dogId;
    }

    public void setDogId(Integer dogId) {
        this.dogId = dogId;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public Date getTickoutDate() {
        return tickoutDate;
    }

    public void setTickoutDate(Date tickoutDate) {
        this.tickoutDate = tickoutDate;
    }

    public String getTickoutDateStr() {
        return tickoutDateStr;
    }

    public void setTickoutDateStr(String tickoutDateStr) {
        this.tickoutDateStr = tickoutDateStr;
    }

    public String getTickoutReason() {
        return tickoutReason;
    }

    public void setTickoutReason(String tickoutReason) {
        this.tickoutReason = tickoutReason;
    }

    public String getTickoutDesc() {
        return tickoutDesc;
    }

    public void setTickoutDesc(String tickoutDesc) {
        this.tickoutDesc = tickoutDesc;
    }

    public Integer getApplyState() {
        return applyState;
    }

    public void setApplyState(Integer applyState) {
        this.applyState = applyState;
    }

    public String getApproveDetail() {
        return approveDetail;
    }

    public void setApproveDetail(String approveDetail) {
        this.approveDetail = approveDetail;
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    public String getApproveDateStr() {
        return approveDateStr;
    }

    public void setApproveDateStr(String approveDateStr) {
        this.approveDateStr = approveDateStr;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }
}
