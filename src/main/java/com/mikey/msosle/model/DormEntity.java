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
@Table(name = "dorm", schema = "msosle", catalog = "")
public class DormEntity {
    private int dormId;
    private String dormCode;
    private String dormName;
    private DormitoryEntity dormitory;

    @Id
    @Column(name = "dorm_id", nullable = false)
    public int getDormId() {
        return dormId;
    }

    public void setDormId(int dormId) {
        this.dormId = dormId;
    }

    @Basic
    @Column(name = "dorm_code", nullable = true, length = 255)
    public String getDormCode() {
        return dormCode;
    }

    public void setDormCode(String dormCode) {
        this.dormCode = dormCode;
    }

    @Basic
    @Column(name = "dorm_name", nullable = true, length = 255)
    public String getDormName() {
        return dormName;
    }

    public void setDormName(String dormName) {
        this.dormName = dormName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DormEntity that = (DormEntity) o;

        if (dormId != that.dormId) return false;
        if (dormName != null ? !dormName.equals(that.dormName) : that.dormName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dormId;
        result = 31 * result + (dormName != null ? dormName.hashCode() : 0);
        return result;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public DormitoryEntity getDormitory() {
        return dormitory;
    }

    public void setDormitory(DormitoryEntity dormitory) {
        this.dormitory = dormitory;
    }
}
