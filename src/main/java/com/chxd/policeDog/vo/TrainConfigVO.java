package com.chxd.policeDog.vo;

import java.util.Date;

/**
 * Created by cheng on 2017/9/3.
 */
public class TrainConfigVO extends BaseVO {
    private static final long serialVersionUID = 5789110522218868041L;
    private String trainName;
    private String trainDesc;
    private String trainUnit;
    private String trainAddr;
    private Date startDate;
    private String startDateStr;
    private Date endDate;
    private String endDateStr;
    private Integer total;

    public String getStartDateStr() {
        return startDateStr;
    }

    public void setStartDateStr(String startDateStr) {
        this.startDateStr = startDateStr;
    }

    public String getEndDateStr() {
        return endDateStr;
    }

    public void setEndDateStr(String endDateStr) {
        this.endDateStr = endDateStr;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getTrainDesc() {
        return trainDesc;
    }

    public void setTrainDesc(String trainDesc) {
        this.trainDesc = trainDesc;
    }

    public String getTrainUnit() {
        return trainUnit;
    }

    public void setTrainUnit(String trainUnit) {
        this.trainUnit = trainUnit;
    }

    public String getTrainAddr() {
        return trainAddr;
    }

    public void setTrainAddr(String trainAddr) {
        this.trainAddr = trainAddr;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
