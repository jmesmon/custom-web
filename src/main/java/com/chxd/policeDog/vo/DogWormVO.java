package com.chxd.policeDog.vo;

import java.util.Date;

/**
 * Created by cheng on 2017/8/30.
 */
public class DogWormVO extends BaseVO {
    private static final long serialVersionUID = -2736738083441059870L;
    private Integer dogId;
    private String nestNo;
    private Date wormDate;
    private String wormDateStr;
    private Integer wormState;
    private Integer policeId;

    public Integer getDogId() {
        return dogId;
    }

    public void setDogId(Integer dogId) {
        this.dogId = dogId;
    }

    public String getNestNo() {
        return nestNo;
    }

    public void setNestNo(String nestNo) {
        this.nestNo = nestNo;
    }

    public Date getWormDate() {
        return wormDate;
    }

    public void setWormDate(Date wormDate) {
        this.wormDate = wormDate;
    }

    public String getWormDateStr() {
        return wormDateStr;
    }

    public void setWormDateStr(String wormDateStr) {
        this.wormDateStr = wormDateStr;
    }

    public Integer getWormState() {
        return wormState;
    }

    public void setWormState(Integer wormState) {
        this.wormState = wormState;
    }

    public Integer getPoliceId() {
        return policeId;
    }

    public void setPoliceId(Integer policeId) {
        this.policeId = policeId;
    }
}
