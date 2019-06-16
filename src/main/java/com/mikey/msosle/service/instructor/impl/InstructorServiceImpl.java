package com.mikey.msosle.service.instructor.impl;

import com.mikey.msosle.common.PageBean;
import com.mikey.msosle.dao.instructor.InstructorDao;
import com.mikey.msosle.model.InstructorEntity;
import com.mikey.msosle.service.instructor.InstructorService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Program: YoungVolunteer
 * @Author: 麦奇
 * @Email： 1625017540@qq.com
 * @Create: 2019-06-04 00:32
 * @Describe：
 **/
@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    private InstructorDao instructorDao;

    @Override
    public void save(InstructorEntity instructorEntity) {

        instructorDao.save(instructorEntity);
    }

    @Override
    public void delete(InstructorEntity instructorEntity ) {

        instructorDao.delete(instructorEntity);

    }

    @Override
    public void update(InstructorEntity instructorEntity) {

        instructorDao.update(instructorEntity);

    }

    @Override
    public InstructorEntity findById(InstructorEntity instructorEntity) {
       return instructorDao.findById(instructorEntity);
    }

    @Override
    public PageBean findByPage(String key, PageBean<InstructorEntity> pageBean) {
       return instructorDao.findByPage(key,pageBean);
    }

    @Override
    public void deleteBatch(String[] Ids) {
       instructorDao.deleteBatch(Ids);
    }
}
