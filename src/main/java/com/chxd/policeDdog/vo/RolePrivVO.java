package com.chxd.policeDdog.vo;

/**
 * 角色与权限表
 * Created by cheng on 2017/8/15.
 */
public class RolePrivVO extends BaseVO {
    private static final long serialVersionUID = -2516129625705051769L;

    private Integer  roleId;	//	角色id
    private String  roleName;	//	角色名称
    private Integer  privId;	//	权限id

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getPrivId() {
        return privId;
    }

    public void setPrivId(Integer privId) {
        this.privId = privId;
    }
}
