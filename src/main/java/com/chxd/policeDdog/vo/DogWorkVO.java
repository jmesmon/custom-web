package com.chxd.policeDdog.vo;

import java.util.Date;

/**
 * 警犬使用信息表
 * Created by cheng on 2017/8/15.
 */
public class DogWorkVO extends BaseVO {
    private static final long serialVersionUID = -4631516929841802430L;

    private Date workStartDate;	//	日期
    private Date  workEndTime;	//	时间
    private String  workUnit;	//	用犬单位
    private String  attPerson;	//	出勤人员
    private Integer  dogId;	//	警犬id
    private String  dogName;	//	派出警犬
    private String  caseProperty;	//	案件性质
    private String  caseNo;	//	案件编号
    private String  caseLevel;	//	案件等级
    private String  maIntegerask;	//	主要任务
    private String  workResult;	//	使用结果

    public Date getWorkStartDate() {
        return workStartDate;
    }

    public void setWorkStartDate(Date workStartDate) {
        this.workStartDate = workStartDate;
    }

    public Date getWorkEndTime() {
        return workEndTime;
    }

    public void setWorkEndTime(Date workEndTime) {
        this.workEndTime = workEndTime;
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

    public Integer getDogId() {
        return dogId;
    }

    public void setDogId(Integer dogId) {
        this.dogId = dogId;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
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

    public String getCaseLevel() {
        return caseLevel;
    }

    public void setCaseLevel(String caseLevel) {
        this.caseLevel = caseLevel;
    }

    public String getMaIntegerask() {
        return maIntegerask;
    }

    public void setMaIntegerask(String maIntegerask) {
        this.maIntegerask = maIntegerask;
    }

    public String getWorkResult() {
        return workResult;
    }

    public void setWorkResult(String workResult) {
        this.workResult = workResult;
    }
}
