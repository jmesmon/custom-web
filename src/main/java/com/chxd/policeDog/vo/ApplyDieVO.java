package com.chxd.policeDog.vo;

import java.util.Date;

/**
 * Created by cheng on 2017/9/28.
 */
public class ApplyDieVO extends BaseVO {
    private String  applyUnit;	//
    private Integer dogId;
    private String  sickReason;	//
    private Date  applyDate;	//
    private String  applyDateStr;	//
    private Date  sickDate;	//
    private String  sickDateStr;	//
    private String  cureDetail;	//
    private Date  dieDate;	//
    private String  dieDateStr;	//
    private String  photos;	//
    private String  dieReason;	//
    private String  conclus;	//
    private Integer  applyState;	//1:等待分局审批，2：等待九支队审批，3: 审批完成，4：驳回
    private Integer  applyStateGr;
    private String  applyUser;	//
    private String  appluDate;	//
    private Date approveDate;	//
    private String  approveDateStr;	//
    private String  approveDetail;	//

    private String unitApproveDetail;
    private Date unitApproveDate;
    private String unitApproveDateStr;

    private String approver;
    private String unitApprover;

    private DogBaseInfoVO dogInfo;

    public Integer getApplyStateGr() {
        return applyStateGr;
    }

    public void setApplyStateGr(Integer applyStateGr) {
        this.applyStateGr = applyStateGr;
    }

    public String getUnitApproveDetail() {
        return unitApproveDetail;
    }

    public void setUnitApproveDetail(String unitApproveDetail) {
        this.unitApproveDetail = unitApproveDetail;
    }

    public Date getUnitApproveDate() {
        return unitApproveDate;
    }

    public void setUnitApproveDate(Date unitApproveDate) {
        this.unitApproveDate = unitApproveDate;
    }

    public String getUnitApproveDateStr() {
        return unitApproveDateStr;
    }

    public void setUnitApproveDateStr(String unitApproveDateStr) {
        this.unitApproveDateStr = unitApproveDateStr;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public String getUnitApprover() {
        return unitApprover;
    }

    public void setUnitApprover(String unitApprover) {
        this.unitApprover = unitApprover;
    }

    public DogBaseInfoVO getDogInfo() {
        return dogInfo;
    }

    public void setDogInfo(DogBaseInfoVO dogInfo) {
        this.dogInfo = dogInfo;
    }

    public Integer getDogId() {
        return dogId;
    }

    public void setDogId(Integer dogId) {
        this.dogId = dogId;
    }

    public String getApplyUnit() {
        return applyUnit;
    }

    public void setApplyUnit(String applyUnit) {
        this.applyUnit = applyUnit;
    }

    public String getSickReason() {
        return sickReason;
    }

    public void setSickReason(String sickReason) {
        this.sickReason = sickReason;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getApplyDateStr() {
        return applyDateStr;
    }

    public void setApplyDateStr(String applyDateStr) {
        this.applyDateStr = applyDateStr;
    }

    public Date getSickDate() {
        return sickDate;
    }

    public void setSickDate(Date sickDate) {
        this.sickDate = sickDate;
    }

    public String getSickDateStr() {
        return sickDateStr;
    }

    public void setSickDateStr(String sickDateStr) {
        this.sickDateStr = sickDateStr;
    }

    public String getCureDetail() {
        return cureDetail;
    }

    public void setCureDetail(String cureDetail) {
        this.cureDetail = cureDetail;
    }

    public Date getDieDate() {
        return dieDate;
    }

    public void setDieDate(Date dieDate) {
        this.dieDate = dieDate;
    }

    public String getDieDateStr() {
        return dieDateStr;
    }

    public void setDieDateStr(String dieDateStr) {
        this.dieDateStr = dieDateStr;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getDieReason() {
        return dieReason;
    }

    public void setDieReason(String dieReason) {
        this.dieReason = dieReason;
    }

    public String getConclus() {
        return conclus;
    }

    public void setConclus(String conclus) {
        this.conclus = conclus;
    }

    public Integer getApplyState() {
        return applyState;
    }

    public void setApplyState(Integer applyState) {
        this.applyState = applyState;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getAppluDate() {
        return appluDate;
    }

    public void setAppluDate(String appluDate) {
        this.appluDate = appluDate;
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

    public String getApproveDetail() {
        return approveDetail;
    }

    public void setApproveDetail(String approveDetail) {
        this.approveDetail = approveDetail;
    }
}
