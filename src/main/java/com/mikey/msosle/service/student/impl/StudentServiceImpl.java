package com.mikey.msosle.service.student.impl;

import com.mikey.msosle.common.PageBean;
import com.mikey.msosle.dao.student.StudentDao;
import com.mikey.msosle.model.StudentEntity;
import com.mikey.msosle.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Program: YoungVolunteer
 * @Author: 麦奇
 * @Email： 1625017540@qq.com
 * @Create: 2019-06-04 00:32
 * @Describe：
 **/
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public void save(StudentEntity studentEntity) {
        studentDao.save(studentEntity);
    }

    @Override
    public void delete(StudentEntity studentEntity) {
        studentDao.delete(studentEntity);
    }

    @Override
    public void update(StudentEntity studentEntity) {
        studentDao.update(studentEntity);
    }

    @Override
    public StudentEntity findById(StudentEntity studentEntity) {
       return studentDao.findById(studentEntity);
    }

    @Override
    public PageBean findByPage(String key, PageBean<StudentEntity> pageBean) {

        return studentDao.findByPage(key,pageBean);
    }

    @Override
    public void deleteBatch(String[] Ids) {
        studentDao.deleteBatch(Ids);
    }
}
