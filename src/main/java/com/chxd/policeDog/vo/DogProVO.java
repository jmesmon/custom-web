package com.chxd.policeDog.vo;

/**
 * 警犬与专业表
 * Created by cheng on 2017/8/15.
 */
public class DogProVO extends BaseVO {
    private static final long serialVersionUID = -8650063336869013762L;

    private Integer  dogId;	//警犬ID
    private Integer  profId;	//专业ID
    private String  profName;	//专业名称

    public Integer getDogId() {
        return dogId;
    }

    public void setDogId(Integer dogId) {
        this.dogId = dogId;
    }

    public Integer getProfId() {
        return profId;
    }

    public void setProfId(Integer profId) {
        this.profId = profId;
    }

    public String getProfName() {
        return profName;
    }

    public void setProfName(String profName) {
        this.profName = profName;
    }
}
