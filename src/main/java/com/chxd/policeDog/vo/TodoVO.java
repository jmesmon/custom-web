package com.chxd.policeDog.vo;

import java.util.Date;

/**
 * Created by cheng on 2017/9/25.
 */
public class TodoVO extends BaseVO {
    private String applyType;
    private String applyTitle;
    private Date applyState;
    private String applyStateStr;
    private String applyDate;
    private Integer applyId;
    private String policeId;

    public String getApplyType() {
        return applyType;
    }

    public void setApplyType(String applyType) {
        this.applyType = applyType;
    }

    public String getApplyTitle() {
        return applyTitle;
    }

    public void setApplyTitle(String applyTitle) {
        this.applyTitle = applyTitle;
    }

    public Date getApplyState() {
        return applyState;
    }

    public void setApplyState(Date applyState) {
        this.applyState = applyState;
    }

    public String getApplyStateStr() {
        return applyStateStr;
    }

    public void setApplyStateStr(String applyStateStr) {
        this.applyStateStr = applyStateStr;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public String getPoliceId() {
        return policeId;
    }

    public void setPoliceId(String policeId) {
        this.policeId = policeId;
    }
}
