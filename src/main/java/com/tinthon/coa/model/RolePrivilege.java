package com.tinthon.coa.model;

public class RolePrivilege {
    private Integer id;

    private Integer roleId;

    private Integer privilegeId;

    public RolePrivilege(Integer id, Integer roleId, Integer privilegeId) {
        this.id = id;
        this.roleId = roleId;
        this.privilegeId = privilegeId;
    }

    public RolePrivilege() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(Integer privilegeId) {
        this.privilegeId = privilegeId;
    }
}