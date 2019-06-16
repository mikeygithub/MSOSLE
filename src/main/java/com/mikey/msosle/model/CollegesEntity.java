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
@Table(name = "colleges", schema = "msosle", catalog = "")
public class CollegesEntity {
    private int collegesId;
    private String collegesName;
    private Set<ClassesEntity> classes;

    @Id
    @Column(name = "colleges_id", nullable = false)
    public int getCollegesId() {
        return collegesId;
    }

    public void setCollegesId(int collegesId) {
        this.collegesId = collegesId;
    }

    @Basic
    @Column(name = "colleges_name", nullable = true, length = 255)
    public String getCollegesName() {
        return collegesName;
    }

    public void setCollegesName(String collegesName) {
        this.collegesName = collegesName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CollegesEntity that = (CollegesEntity) o;

        if (collegesId != that.collegesId) return false;
        if (collegesName != null ? !collegesName.equals(that.collegesName) : that.collegesName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = collegesId;
        result = 31 * result + (collegesName != null ? collegesName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "colleges")
    public Set<ClassesEntity> getClasses() {
        return classes;
    }

    public void setClasses(Set<ClassesEntity> classes) {
        this.classes = classes;
    }
}
