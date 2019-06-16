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
@Table(name = "classes", schema = "msosle", catalog = "")
public class ClassesEntity {
    private int classesId;
    private String classesCode;
    private String classesName;
    private CollegesEntity colleges;
    private Set<ClassesEntity> students;
    private ClassesEntity classes;

    @Id
    @Column(name = "classes_id", nullable = false)
    public int getClassesId() {
        return classesId;
    }

    public void setClassesId(int classesId) {
        this.classesId = classesId;
    }
    @Basic
    @Column(name = "classes_code", nullable = true, length = 255)
    public String getClassesCode() {
        return classesCode;
    }

    public void setClassesCode(String classesCode) {
        this.classesCode = classesCode;
    }
    @Basic
    @Column(name = "classes_name", nullable = true, length = 255)
    public String getClassesName() {
        return classesName;
    }

    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassesEntity that = (ClassesEntity) o;

        if (classesId != that.classesId) return false;
        if (classesName != null ? !classesName.equals(that.classesName) : that.classesName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = classesId;
        result = 31 * result + (classesName != null ? classesName.hashCode() : 0);
        return result;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public CollegesEntity getColleges() {
        return colleges;
    }

    public void setColleges(CollegesEntity colleges) {
        this.colleges = colleges;
    }

    @OneToMany(mappedBy = "classes",fetch = FetchType.EAGER)
    public Set<ClassesEntity> getStudents() {
        return students;
    }

    public void setStudents(Set<ClassesEntity> students) {
        this.students = students;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public ClassesEntity getClasses() {
        return classes;
    }

    public void setClasses(ClassesEntity classes) {
        this.classes = classes;
    }
}
