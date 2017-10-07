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
    private String orgPic;

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
}
