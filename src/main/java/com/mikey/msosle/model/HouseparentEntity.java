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
@Table(name = "houseparent", schema = "msosle", catalog = "")
public class HouseparentEntity {
    private int houseparentId;
    private String houseparentCode;
    private String houseparentName;
    private SysUserEntity user;
    private DormitoryEntity dormitory;

    @Id
    @Column(name = "houseparent_id", nullable = false)
    public int getHouseparentId() {
        return houseparentId;
    }

    public void setHouseparentId(int houseparentId) {
        this.houseparentId = houseparentId;
    }
    @Basic
    @Column(name = "houseparent_code", nullable = true, length = 255)
    public String getHouseparentCode() {
        return houseparentCode;
    }

    public void setHouseparentCode(String houseparentCode) {
        this.houseparentCode = houseparentCode;
    }

    @Basic
    @Column(name = "houseparent_name", nullable = true, length = 255)
    public String getHouseparentName() {
        return houseparentName;
    }

    public void setHouseparentName(String houseparentName) {
        this.houseparentName = houseparentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HouseparentEntity that = (HouseparentEntity) o;

        if (houseparentId != that.houseparentId) return false;
        if (houseparentName != null ? !houseparentName.equals(that.houseparentName) : that.houseparentName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = houseparentId;
        result = 31 * result + (houseparentName != null ? houseparentName.hashCode() : 0);
        return result;
    }

    @OneToOne(mappedBy = "houseparent")
    public SysUserEntity getUser() {
        return user;
    }

    public void setUser(SysUserEntity user) {
        this.user = user;
    }

    @ManyToOne
    public DormitoryEntity getDormitory() {
        return dormitory;
    }

    public void setDormitory(DormitoryEntity dormitory) {
        this.dormitory = dormitory;
    }
}
