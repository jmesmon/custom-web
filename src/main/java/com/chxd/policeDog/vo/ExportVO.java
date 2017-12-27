package com.chxd.policeDog.vo;

/**
 * Created by cheng on 2017/12/27.
 */
public class ExportVO extends BaseVO {
    private String startDate;
    private String endDate;
    private String workUnit;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }
}
