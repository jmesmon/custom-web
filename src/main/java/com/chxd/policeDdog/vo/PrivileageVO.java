package com.chxd.policeDdog.vo;

/**
 * 权限点表
 * Created by cheng on 2017/8/15.
 */
public class PrivileageVO extends BaseVO {
    private static final long serialVersionUID = -5396794808835011558L;

    private String  privName;	//	权限点名称
    private String  privCode;	//	权限点编码

    public String getPrivName() {
        return privName;
    }

    public void setPrivName(String privName) {
        this.privName = privName;
    }

    public String getPrivCode() {
        return privCode;
    }

    public void setPrivCode(String privCode) {
        this.privCode = privCode;
    }
}
