package com.chxd.policeDog.vo;

/**
 * Created by cheng on 2017/10/3.
 */
public class OrgConfigVO extends BaseVO {
    private String  orgName;	//单位名称
    private String  orgLeader;	//主要负责人
    private String  orgAddr;	//单位地址
    private String  orgConcat;	//联系方式
    private Integer  empQty;	//员工数量
    private String  orgArea;	//单位所在区
    private Integer  dogHouseQty;	//犬舍
    private Integer  unitArea;	//单位面积
    private Integer  trainedQty;	//培训数量
    private Integer  untrainQty;	//未培训数量

    private String orgPic;
    private String orgDesc;
    private Integer dogQty;
    private Integer newQty;
    private Object workHours;
    private Integer policeCount;

    public Integer getNewQty() {
        return newQty;
    }

    public void setNewQty(Integer newQty) {
        this.newQty = newQty;
    }

    public Object getWorkHours() {
        return workHours;
    }

    public void setWorkHours(Object workHours) {
        this.workHours = workHours;
    }

    public Integer getDogQty() {
        return dogQty;
    }

    public void setDogQty(Integer dogQty) {
        this.dogQty = dogQty;
    }

    public String getOrgDesc() {
        return orgDesc;
    }

    public void setOrgDesc(String orgDesc) {
        this.orgDesc = orgDesc;
    }

    public String getOrgPic() {
        return orgPic;
    }

    public void setOrgPic(String orgPic) {
        this.orgPic = orgPic;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgLeader() {
        return orgLeader;
    }

    public void setOrgLeader(String orgLeader) {
        this.orgLeader = orgLeader;
    }

    public String getOrgAddr() {
        return orgAddr;
    }

    public void setOrgAddr(String orgAddr) {
        this.orgAddr = orgAddr;
    }

    public String getOrgConcat() {
        return orgConcat;
    }

    public void setOrgConcat(String orgConcat) {
        this.orgConcat = orgConcat;
    }

    public Integer getEmpQty() {
        return empQty;
    }

    public void setEmpQty(Integer empQty) {
        this.empQty = empQty;
    }

    public String getOrgArea() {
        return orgArea;
    }

    public void setOrgArea(String orgArea) {
        this.orgArea = orgArea;
    }

    public Integer getPoliceCount() {
        return policeCount;
    }

    public void setPoliceCount(Integer policeCount) {
        this.policeCount = policeCount;
    }

    public Integer getDogHouseQty() {
        return dogHouseQty;
    }

    public void setDogHouseQty(Integer dogHouseQty) {
        this.dogHouseQty = dogHouseQty;
    }

    public Integer getUnitArea() {
        return unitArea;
    }

    public void setUnitArea(Integer unitArea) {
        this.unitArea = unitArea;
    }

    public Integer getTrainedQty() {
        return trainedQty;
    }

    public void setTrainedQty(Integer trainedQty) {
        this.trainedQty = trainedQty;
    }

    public Integer getUntrainQty() {
        return untrainQty;
    }

    public void setUntrainQty(Integer untrainQty) {
        this.untrainQty = untrainQty;
    }
}
