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
@Table(name = "instructor", schema = "msosle", catalog = "")
public class InstructorEntity {
    private int instructorId;
    private String instructorName;
    private SysUserEntity user;

    @Id
    @Column(name = "instructor_id", nullable = false)
    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    @Basic
    @Column(name = "instructor_name", nullable = true, length = 255)
    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InstructorEntity that = (InstructorEntity) o;

        if (instructorId != that.instructorId) return false;
        if (instructorName != null ? !instructorName.equals(that.instructorName) : that.instructorName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = instructorId;
        result = 31 * result + (instructorName != null ? instructorName.hashCode() : 0);
        return result;
    }

    @OneToOne(mappedBy = "instructor")
    public SysUserEntity getUser() {
        return user;
    }

    public void setUser(SysUserEntity user) {
        this.user = user;
    }
}
