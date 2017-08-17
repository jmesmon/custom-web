package com.chxd.policeDdog.vo;

/**
 * 警犬专业信息表
 * Created by cheng on 2017/8/15.
 */
public class DogProInfoVO extends BaseVO {
    private static final long serialVersionUID = -8612600291504634051L;

    private String  profName;	//	专业名称

    public String getProfName() {
        return profName;
    }

    public void setProfName(String profName) {
        this.profName = profName;
    }
}
