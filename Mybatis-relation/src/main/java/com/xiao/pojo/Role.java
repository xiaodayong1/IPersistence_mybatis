package com.xiao.pojo;

/**
 * @ClassName : Role  //类名
 * @Description : 角色表  //描述
 * @Author : Xiaodayong  //作者
 * @Date: 2020-11-01 13:17  //时间
 */
public class Role {

    private Integer id;
    private String roleName;
    private String roleDesc;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}
