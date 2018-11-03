package com.chxd.policeDog.vo;

public class DogWorkSumVO extends BaseVO {
    private String workType;
    private String workUnit;
    private String dateStart;
    private String startTimeStr;
    private String endTimeStr;
    private String dateEnd;

    private Integer attQty; //出勤次数
    private Integer attPerQty; //出勤人数
    private Integer attDogQty; //出勤犬数
    private Integer wjpQty; //违禁品数量
    private Integer dpQty; //毒品克数

    private Integer checkArea; //安检面积
    private Integer checkCarQty; //安检车辆数

    private Integer workHours; //巡逻时长、备勤时长
    private Integer paQty; //破案数

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Integer getAttQty() {
        return attQty;
    }

    public void setAttQty(Integer attQty) {
        this.attQty = attQty;
    }

    public Integer getAttPerQty() {
        return attPerQty;
    }

    public void setAttPerQty(Integer attPerQty) {
        this.attPerQty = attPerQty;
    }

    public Integer getAttDogQty() {
        return attDogQty;
    }

    public void setAttDogQty(Integer attDogQty) {
        this.attDogQty = attDogQty;
    }

    public Integer getWjpQty() {
        return wjpQty;
    }

    public void setWjpQty(Integer wjpQty) {
        this.wjpQty = wjpQty;
    }

    public Integer getDpQty() {
        return dpQty;
    }

    public void setDpQty(Integer dpQty) {
        this.dpQty = dpQty;
    }

    public Integer getCheckArea() {
        return checkArea;
    }

    public void setCheckArea(Integer checkArea) {
        this.checkArea = checkArea;
    }

    public Integer getCheckCarQty() {
        return checkCarQty;
    }

    public void setCheckCarQty(Integer checkCarQty) {
        this.checkCarQty = checkCarQty;
    }

    public Integer getWorkHours() {
        return workHours;
    }

    public void setWorkHours(Integer workHours) {
        this.workHours = workHours;
    }

    public Integer getPaQty() {
        return paQty;
    }

    public void setPaQty(Integer paQty) {
        this.paQty = paQty;
    }

    public String getStartTimeStr() {
        return startTimeStr;
    }

    public void setStartTimeStr(String startTimeStr) {
        this.startTimeStr = startTimeStr;
    }

    public String getEndTimeStr() {
        return endTimeStr;
    }

    public void setEndTimeStr(String endTimeStr) {
        this.endTimeStr = endTimeStr;
    }
}
