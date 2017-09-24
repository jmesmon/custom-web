package com.chxd.policeDog.vo;

/**
 * Created by cheng on 2017/9/24.
 */
public class ApplyDogVO extends BaseVO {
    private static final long serialVersionUID = 362004250683598739L;
    private String  workUnit;	//
    private Integer  applyAmount;	//
    private Integer  dogId;	//
    private String  policeMan;	//
    private String  policeId;	//
    private Integer  applyState;	//1：带审批，2：审批通过，带配发，3：申请驳回，4：配发完成
    private String  applyDesc;	//
    private String  approveDetail;	//

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public Integer getApplyAmount() {
        return applyAmount;
    }

    public void setApplyAmount(Integer applyAmount) {
        this.applyAmount = applyAmount;
    }

    public Integer getDogId() {
        return dogId;
    }

    public void setDogId(Integer dogId) {
        this.dogId = dogId;
    }

    public String getPoliceMan() {
        return policeMan;
    }

    public void setPoliceMan(String policeMan) {
        this.policeMan = policeMan;
    }

    public String getPoliceId() {
        return policeId;
    }

    public void setPoliceId(String policeId) {
        this.policeId = policeId;
    }

    public Integer getApplyState() {
        return applyState;
    }

    public void setApplyState(Integer applyState) {
        this.applyState = applyState;
    }

    public String getApplyDesc() {
        return applyDesc;
    }

    public void setApplyDesc(String applyDesc) {
        this.applyDesc = applyDesc;
    }

    public String getApproveDetail() {
        return approveDetail;
    }

    public void setApproveDetail(String approveDetail) {
        this.approveDetail = approveDetail;
    }
}
