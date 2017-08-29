package com.chxd.policeDog.vo;

import java.util.Date;

/**
 * 警犬立功信息表
 * Created by cheng on 2017/8/15.
 */
public class DogHonorVO extends BaseVO {
    private static final long serialVersionUID = 6497521368369036232L;

    private String  honorNo;	//	证件编号
    private String  honorName;	//	奖励名称
    private String  rewardUnit;	//	颁奖单位
    private String  rewardDetail;	//	奖励原因
    private Date rewardDate;	//	奖励日期

    public String getHonorNo() {
        return honorNo;
    }

    public void setHonorNo(String honorNo) {
        this.honorNo = honorNo;
    }

    public String getHonorName() {
        return honorName;
    }

    public void setHonorName(String honorName) {
        this.honorName = honorName;
    }

    public String getRewardUnit() {
        return rewardUnit;
    }

    public void setRewardUnit(String rewardUnit) {
        this.rewardUnit = rewardUnit;
    }

    public String getRewardDetail() {
        return rewardDetail;
    }

    public void setRewardDetail(String rewardDetail) {
        this.rewardDetail = rewardDetail;
    }

    public Date getRewardDate() {
        return rewardDate;
    }

    public void setRewardDate(Date rewardDate) {
        this.rewardDate = rewardDate;
    }
}
