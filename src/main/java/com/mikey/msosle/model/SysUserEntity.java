package com.mikey.msosle.model;

import javax.persistence.*;

/**
 * @Program: Ped_Moni_Gen
 * @Author: 麦奇
 * @Email： 1625017540@qq.com
 * @Create: 2019-06-16 09:00
 * @Describe：
 **/
@Entity
@Table(name = "sys_user", schema = "msosle", catalog = "")
public class SysUserEntity {
    private int userId;
    private String loginAccount;
    private String loginPassword;
    private String userName;
    private Integer roleType;
    private int userAvailable;
    private SysAdminEntity sys_admin;
    private InstructorEntity instructor;
    private HouseparentEntity houseparent;

    @Id
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "login_account", nullable = true, length = 255)
    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    @Basic
    @Column(name = "login_password", nullable = true, length = 255)
    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    @Basic
    @Column(name = "user_name", nullable = true, length = 255)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "role_type", nullable = true)
    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    @Basic
    @Column(name = "user_available", nullable = false)
    public int getUserAvailable() {
        return userAvailable;
    }

    public void setUserAvailable(int userAvailable) {
        this.userAvailable = userAvailable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysUserEntity that = (SysUserEntity) o;

        if (userId != that.userId) return false;
        if (userAvailable != that.userAvailable) return false;
        if (loginAccount != null ? !loginAccount.equals(that.loginAccount) : that.loginAccount != null) return false;
        if (loginPassword != null ? !loginPassword.equals(that.loginPassword) : that.loginPassword != null)
            return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (roleType != null ? !roleType.equals(that.roleType) : that.roleType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (loginAccount != null ? loginAccount.hashCode() : 0);
        result = 31 * result + (loginPassword != null ? loginPassword.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (roleType != null ? roleType.hashCode() : 0);
        result = 31 * result + userAvailable;
        return result;
    }

    @OneToOne
    public SysAdminEntity getSys_admin() {
        return sys_admin;
    }

    public void setSys_admin(SysAdminEntity sys_admin) {
        this.sys_admin = sys_admin;
    }

    @OneToOne
    public InstructorEntity getInstructor() {
        return instructor;
    }

    public void setInstructor(InstructorEntity instructor) {
        this.instructor = instructor;
    }

    @OneToOne
    public HouseparentEntity getHouseparent() {
        return houseparent;
    }

    public void setHouseparent(HouseparentEntity houseparent) {
        this.houseparent = houseparent;
    }

    @Override
    public String toString() {
        return "SysUserEntity{" +
                "userId=" + userId +
                ", loginAccount='" + loginAccount + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                ", userName='" + userName + '\'' +
                ", roleType=" + roleType +
                ", userAvailable=" + userAvailable +
                ", sys_admin=" + sys_admin +
                ", instructor=" + instructor +
                ", houseparent=" + houseparent +
                '}';
    }
}
