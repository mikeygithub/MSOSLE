package com.mikey.msosle.model;

import javax.persistence.*;
import java.util.Set;

/**
 * @Program: Ped_Moni_Gen
 * @Author: 麦奇
 * @Email： 1625017540@qq.com
 * @Create: 2019-06-16 09:00
 * @Describe：
 **/
@Entity
@Table(name = "dormitory", schema = "msosle", catalog = "")
public class DormitoryEntity {
    private int dormitoryId;
    private String dormitoryName;
    private Set<HouseparentEntity> houseparent;
    private Set<DormEntity> dorms;

    @Id
    @Column(name = "dormitory_id", nullable = false)
    public int getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(int dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    @Basic
    @Column(name = "dormitory_name", nullable = true, length = 255)
    public String getDormitoryName() {
        return dormitoryName;
    }

    public void setDormitoryName(String dormitoryName) {
        this.dormitoryName = dormitoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DormitoryEntity that = (DormitoryEntity) o;

        if (dormitoryId != that.dormitoryId) return false;
        if (dormitoryName != null ? !dormitoryName.equals(that.dormitoryName) : that.dormitoryName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dormitoryId;
        result = 31 * result + (dormitoryName != null ? dormitoryName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "dormitory")
    public Set<HouseparentEntity> getHouseparent() {
        return houseparent;
    }

    public void setHouseparent(Set<HouseparentEntity> houseparent) {
        this.houseparent = houseparent;
    }

    @OneToMany(mappedBy = "dormitory")
    public Set<DormEntity> getDorms() {
        return dorms;
    }

    public void setDorms(Set<DormEntity> dorms) {
        this.dorms = dorms;
    }
}
