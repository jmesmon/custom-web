package com.chxd.policeDog.vo;

/**
 * Created by cheng on 2017/8/30.
 */
public class WormImmueCfgVO extends BaseVO {
    public static final int WORM_PERIOD = 1;
    public static final int IMMUE_PERIOD = 2;

    private static final long serialVersionUID = 1309087276791770826L;
    private Integer periodType;
    private Integer period;
    private String description;

    public static WormImmueCfgVO getInstance(){
        return new WormImmueCfgVO();
    }

    public Integer getPeriodType() {
        return periodType;
    }

    public WormImmueCfgVO setPeriodType(Integer periodType) {
        this.periodType = periodType;
        return this;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
