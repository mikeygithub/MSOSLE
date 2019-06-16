package com.mikey.msosle.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @Program: Ped_Moni_Gen
 * @Author: 麦奇
 * @Email： 1625017540@qq.com
 * @Create: 2019-06-16 09:00
 * @Describe：
 **/
@Entity
@Table(name = "late_return", schema = "msosle", catalog = "")
public class LateReturnEntity {
    private int lateReturnId;
    private String dormName;
    private String studentName;
    private String lateReturnCase;
    private Timestamp lateReturnTime;

    @Id
    @Column(name = "late_return_id", nullable = false)
    public int getLateReturnId() {
        return lateReturnId;
    }

    public void setLateReturnId(int lateReturnId) {
        this.lateReturnId = lateReturnId;
    }

    @Basic
    @Column(name = "dorm_name", nullable = true, length = 255)
    public String getDormName() {
        return dormName;
    }

    public void setDormName(String dormName) {
        this.dormName = dormName;
    }

    @Basic
    @Column(name = "student_name", nullable = true, length = 255)
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Basic
    @Column(name = "late_return_case", nullable = true, length = 255)
    public String getLateReturnCase() {
        return lateReturnCase;
    }

    public void setLateReturnCase(String lateReturnCase) {
        this.lateReturnCase = lateReturnCase;
    }

    @Basic
    @Column(name = "late_return_time", nullable = true)
    public Timestamp getLateReturnTime() {
        return lateReturnTime;
    }

    public void setLateReturnTime(Timestamp lateReturnTime) {
        this.lateReturnTime = lateReturnTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LateReturnEntity that = (LateReturnEntity) o;

        if (lateReturnId != that.lateReturnId) return false;
        if (dormName != null ? !dormName.equals(that.dormName) : that.dormName != null) return false;
        if (studentName != null ? !studentName.equals(that.studentName) : that.studentName != null) return false;
        if (lateReturnCase != null ? !lateReturnCase.equals(that.lateReturnCase) : that.lateReturnCase != null)
            return false;
        if (lateReturnTime != null ? !lateReturnTime.equals(that.lateReturnTime) : that.lateReturnTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lateReturnId;
        result = 31 * result + (dormName != null ? dormName.hashCode() : 0);
        result = 31 * result + (studentName != null ? studentName.hashCode() : 0);
        result = 31 * result + (lateReturnCase != null ? lateReturnCase.hashCode() : 0);
        result = 31 * result + (lateReturnTime != null ? lateReturnTime.hashCode() : 0);
        return result;
    }
}
