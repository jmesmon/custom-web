package com.chxd.policeDog.vo;

/**
 * 用户和角色关系表
 * Created by cheng on 2017/8/15.
 */
public class UserRoleVO extends BaseVO {
    public static final String NORMAL_USER = "JingYuan";
    public static final String JZ_USER = "JuZhang";
    public static final String JZD_USER = "JiuZhiDui";
    public static final String GLY_USER = "GuanLiYuan";
    public static final String FZRY_USER = "FanZhiRenYuan";
    public static final String PXRY_USER = "PeiXunRenYuan";
    public static final String SUPER_USER = "SuperMan";
    public static final String APPROVER_USER = "Approvor";

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
