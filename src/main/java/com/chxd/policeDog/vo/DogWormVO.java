package com.chxd.policeDog.vo;

import java.util.Date;

/**
 * Created by cheng on 2017/8/30.
 */
public class DogWormVO extends BaseVO {
    private static final long serialVersionUID = -2736738083441059870L;
    private String dogChipNo;
    private String nestNo;
    private Date wormDate;
    private String wormDateStr;
    private String wormDateStart;
    private String wormDateEnd;
    private Integer wormState;
    private Integer policeId;
    private String wormDesc;
    private String policeName;

    private DogBaseInfoVO dogInfo;

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

    public String getWormDesc() {
        return wormDesc;
    }

    public void setWormDesc(String wormDesc) {
        this.wormDesc = wormDesc;
    }

    public String getDogChipNo() {
        return dogChipNo;
    }

    public void setDogChipNo(String dogChipNo) {
        this.dogChipNo = dogChipNo;
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

    public String getWormDateStart() {
        return wormDateStart;
    }

    public void setWormDateStart(String wormDateStart) {
        this.wormDateStart = wormDateStart;
    }

    public String getWormDateEnd() {
        return wormDateEnd;
    }

    public void setWormDateEnd(String wormDateEnd) {
        this.wormDateEnd = wormDateEnd;
    }
}
