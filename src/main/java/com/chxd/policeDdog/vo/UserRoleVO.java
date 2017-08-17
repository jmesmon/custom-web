package com.chxd.policeDdog.vo;

/**
 * 用户和角色关系表
 * Created by cheng on 2017/8/15.
 */
public class UserRoleVO extends BaseVO {
    private static final long serialVersionUID = 3907950831836557145L;

    private Integer  policeId;	//	日期
    private Integer  ruleId;	//	时间
    private String  ruleName;	//	角色名称

    public Integer getPoliceId() {
        return policeId;
    }

    public void setPoliceId(Integer policeId) {
        this.policeId = policeId;
    }

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }
}
