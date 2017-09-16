package com.chxd.policeDog.vo;

import java.util.Date;

/**
 * 警犬使用信息表
 * Created by cheng on 2017/8/15.
 */
public class DogWorkVO extends BaseVO {
    private static final long serialVersionUID = -4631516929841802430L;
    private String workType;
    private Date startTime;	//	日期
    private String startTimeStr;	//	日期
    private Date  endTime;	//	时间
    private String  endTimeStr;	//	时间
    private String  workUnit;	//	用犬单位
    private String  attPerson;	//	出勤人员
    private String  dogChipNo;	//	警犬芯片号
    private String  caseProperty;	//	案件性质
    private Integer  securityCheckArea;	//	安检面积
    private String  caseNo;	//	案件编号
    private String  isWork;	//	是否起作用
    private String  workResult;	//	使用结果
    private String  workPic;	//	工作图片

    private DogBaseInfoVO dogInfo;

    public DogBaseInfoVO getDogInfo() {
        return dogInfo;
    }

    public void setDogInfo(DogBaseInfoVO dogInfo) {
        this.dogInfo = dogInfo;
    }

    public Integer getSecurityCheckArea() {
        return securityCheckArea;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public void setSecurityCheckArea(Integer securityCheckArea) {
        this.securityCheckArea = securityCheckArea;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getStartTimeStr() {
        return startTimeStr;
    }

    public void setStartTimeStr(String startTimeStr) {
        this.startTimeStr = startTimeStr;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getEndTimeStr() {
        return endTimeStr;
    }

    public void setEndTimeStr(String endTimeStr) {
        this.endTimeStr = endTimeStr;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getAttPerson() {
        return attPerson;
    }

    public void setAttPerson(String attPerson) {
        this.attPerson = attPerson;
    }

    public String getDogChipNo() {
        return dogChipNo;
    }

    public void setDogChipNo(String dogChipNo) {
        this.dogChipNo = dogChipNo;
    }

    public String getCaseProperty() {
        return caseProperty;
    }

    public void setCaseProperty(String caseProperty) {
        this.caseProperty = caseProperty;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public String getIsWork() {
        return isWork;
    }

    public void setIsWork(String isWork) {
        this.isWork = isWork;
    }

    public String getWorkResult() {
        return workResult;
    }

    public void setWorkResult(String workResult) {
        this.workResult = workResult;
    }

    public String getWorkPic() {
        return workPic;
    }

    public void setWorkPic(String workPic) {
        this.workPic = workPic;
    }
}
