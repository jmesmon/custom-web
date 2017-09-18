package com.chxd.policeDog.vo;

import java.util.Date;

/**
 * Created by cheng on 2017/9/3.
 */
public class DogTrainVO extends  BaseVO {
    private static final long serialVersionUID = 1810185433272364844L;

    private Integer growStage;
    private Integer dogId;
    private Integer trainId;
    private String trainName;
    private Date trainStartDate;
    private String trainStartDateStr;
    private Date trainEndDate;
    private String trainEndDateStr;
    private String trainClassName;
    private Integer trainLevel;
    private Integer trainStage;
    private String trainUnit;
    private String trainAddr;
    private String trainUser;
    private String scoreDetail;
    private Integer totalScore;
    private Date nextTrainDate;
    private String nextTrainDateStr;
    private Integer policeId;
    private String policeName;
    private String mainTrainUser;
    private String trainResult;
    private DogBaseInfoVO dogInfo;

    public String getTrainResult() {
        return trainResult;
    }

    public void setTrainResult(String trainResult) {
        this.trainResult = trainResult;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getTrainStartDateStr() {
        return trainStartDateStr;
    }

    public void setTrainStartDateStr(String trainStartDateStr) {
        this.trainStartDateStr = trainStartDateStr;
    }

    public Date getTrainStartDate() {
        return trainStartDate;
    }

    public void setTrainStartDate(Date trainStartDate) {
        this.trainStartDate = trainStartDate;
    }

    public Date getTrainEndDate() {
        return trainEndDate;
    }

    public void setTrainEndDate(Date trainEndDate) {
        this.trainEndDate = trainEndDate;
    }

    public String getTrainEndDateStr() {
        return trainEndDateStr;
    }

    public void setTrainEndDateStr(String trainEndDateStr) {
        this.trainEndDateStr = trainEndDateStr;
    }

    public Integer getTrainId() {
        return trainId;
    }

    public void setTrainId(Integer trainId) {
        this.trainId = trainId;
    }

    public String getNextTrainDateStr() {
        return nextTrainDateStr;
    }

    public void setNextTrainDateStr(String nextTrainDateStr) {
        this.nextTrainDateStr = nextTrainDateStr;
    }

    public String getTrainAddr() {
        return trainAddr;
    }

    public void setTrainAddr(String trainAddr) {
        this.trainAddr = trainAddr;
    }

    public DogBaseInfoVO getDogInfo() {
        return dogInfo;
    }

    public void setDogInfo(DogBaseInfoVO dogInfo) {
        this.dogInfo = dogInfo;
    }

    public String getPoliceName() {
        return policeName;
    }

    public void setPoliceName(String policeName) {
        this.policeName = policeName;
    }

    public Integer getGrowStage() {
        return growStage;
    }

    public void setGrowStage(Integer growStage) {
        this.growStage = growStage;
    }

    public Integer getDogId() {
        return dogId;
    }

    public void setDogId(Integer dogId) {
        this.dogId = dogId;
    }

    public String getTrainClassName() {
        return trainClassName;
    }

    public void setTrainClassName(String trainClassName) {
        this.trainClassName = trainClassName;
    }

    public Integer getTrainLevel() {
        return trainLevel;
    }

    public void setTrainLevel(Integer trainLevel) {
        this.trainLevel = trainLevel;
    }

    public Integer getTrainStage() {
        return trainStage;
    }

    public void setTrainStage(Integer trainStage) {
        this.trainStage = trainStage;
    }

    public String getTrainUnit() {
        return trainUnit;
    }

    public void setTrainUnit(String trainUnit) {
        this.trainUnit = trainUnit;
    }

    public String getTrainUser() {
        return trainUser;
    }

    public void setTrainUser(String trainUser) {
        this.trainUser = trainUser;
    }

    public String getScoreDetail() {
        return scoreDetail;
    }

    public void setScoreDetail(String scoreDetail) {
        this.scoreDetail = scoreDetail;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Date getNextTrainDate() {
        return nextTrainDate;
    }

    public void setNextTrainDate(Date nextTrainDate) {
        this.nextTrainDate = nextTrainDate;
    }

    public Integer getPoliceId() {
        return policeId;
    }

    public void setPoliceId(Integer policeId) {
        this.policeId = policeId;
    }

    public String getMainTrainUser() {
        return mainTrainUser;
    }

    public void setMainTrainUser(String mainTrainUser) {
        this.mainTrainUser = mainTrainUser;
    }
}
