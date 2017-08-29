package com.chxd.policeDog.vo;

import java.util.Date;

/**
 * 警犬变动信息表
 * Created by cheng on 2017/8/15.
 */
public class DogChangeVO extends BaseVO {
    private static final long serialVersionUID = 1485967544371152794L;

    private Integer  dogId;	//	警犬id
    private Date changeDate;	//	变动日期
    private String  oldWorkPlace;	//	原工作单位
    private String  newWorkPlace;	//	变动后作单位
    private String  oldDogName;	//	原犬名
    private String  newDogName;	//	变动后犬名
    private Integer  oldPoliceId;	//	原带犬民警id
    private Integer  oldPoliceName;	//	原带犬民警姓名
    private Integer  newPoliceId;	//	变动后带犬民警id
    private String  newPoliceName;	//	变动后带犬民警姓名
    private String  oldDogType;	//	原类别
    private String  newDogType;	//	变动后类别
    private String  changeReason;	//	变动原因
    private Integer  applyId;	//	申报人id
    private String  applyName;	//	申报人姓名
    private Integer  approverId;	//	审批人id
    private String  approverName;	//	审批人姓名
    private Integer  leaderId;	//	主管领导
    private String  leaderName;	//	主管领导姓名
    private Integer  agentId;	//	经办人id
    private String  agentName;	//	经办人姓名
    private Integer  receiverId;	//	接收人id
    private String  reveiverName;	//	接收人姓名
    private String  otherInfo;	//	其他信息
    private Integer  changeState;	//	变动状态：0：完成，1：待申报人处理，2：待审批人处理，3：待主管领导处理，4：待经办人处理，5：待接收人处理
    private Integer  changeType;	//	变动类别：1：通过，2驳回
    private String  approveLogs;	//	审批明细

    public Integer getDogId() {
        return dogId;
    }

    public void setDogId(Integer dogId) {
        this.dogId = dogId;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    public String getOldWorkPlace() {
        return oldWorkPlace;
    }

    public void setOldWorkPlace(String oldWorkPlace) {
        this.oldWorkPlace = oldWorkPlace;
    }

    public String getNewWorkPlace() {
        return newWorkPlace;
    }

    public void setNewWorkPlace(String newWorkPlace) {
        this.newWorkPlace = newWorkPlace;
    }

    public String getOldDogName() {
        return oldDogName;
    }

    public void setOldDogName(String oldDogName) {
        this.oldDogName = oldDogName;
    }

    public String getNewDogName() {
        return newDogName;
    }

    public void setNewDogName(String newDogName) {
        this.newDogName = newDogName;
    }

    public Integer getOldPoliceId() {
        return oldPoliceId;
    }

    public void setOldPoliceId(Integer oldPoliceId) {
        this.oldPoliceId = oldPoliceId;
    }

    public Integer getOldPoliceName() {
        return oldPoliceName;
    }

    public void setOldPoliceName(Integer oldPoliceName) {
        this.oldPoliceName = oldPoliceName;
    }

    public Integer getNewPoliceId() {
        return newPoliceId;
    }

    public void setNewPoliceId(Integer newPoliceId) {
        this.newPoliceId = newPoliceId;
    }

    public String getNewPoliceName() {
        return newPoliceName;
    }

    public void setNewPoliceName(String newPoliceName) {
        this.newPoliceName = newPoliceName;
    }

    public String getOldDogType() {
        return oldDogType;
    }

    public void setOldDogType(String oldDogType) {
        this.oldDogType = oldDogType;
    }

    public String getNewDogType() {
        return newDogType;
    }

    public void setNewDogType(String newDogType) {
        this.newDogType = newDogType;
    }

    public String getChangeReason() {
        return changeReason;
    }

    public void setChangeReason(String changeReason) {
        this.changeReason = changeReason;
    }

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }

    public Integer getApproverId() {
        return approverId;
    }

    public void setApproverId(Integer approverId) {
        this.approverId = approverId;
    }

    public String getApproverName() {
        return approverName;
    }

    public void setApproverName(String approverName) {
        this.approverName = approverName;
    }

    public Integer getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Integer leaderId) {
        this.leaderId = leaderId;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public String getReveiverName() {
        return reveiverName;
    }

    public void setReveiverName(String reveiverName) {
        this.reveiverName = reveiverName;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    public Integer getChangeState() {
        return changeState;
    }

    public void setChangeState(Integer changeState) {
        this.changeState = changeState;
    }

    public Integer getChangeType() {
        return changeType;
    }

    public void setChangeType(Integer changeType) {
        this.changeType = changeType;
    }

    public String getApproveLogs() {
        return approveLogs;
    }

    public void setApproveLogs(String approveLogs) {
        this.approveLogs = approveLogs;
    }
}
