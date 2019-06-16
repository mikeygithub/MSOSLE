package com.mikey.msosle.service.classes.impl;

import com.mikey.msosle.common.PageBean;
import com.mikey.msosle.dao.classes.ClassesDao;
import com.mikey.msosle.model.ClassesEntity;
import com.mikey.msosle.service.classes.ClassesService;
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
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    private ClassesDao classesDao;

    @Override
    public void save(ClassesEntity classesEntity) {
        classesDao.save(classesEntity);
    }

    @Override
    public void delete(ClassesEntity classesEntity) {
        classesDao.delete(classesEntity);
    }

    @Override
    public void update(ClassesEntity classesEntity) {
        classesDao.update(classesEntity);
    }

    @Override
    public ClassesEntity findById(ClassesEntity classesEntity) {
       return classesDao.findById(classesEntity);
    }

    @Override
    public PageBean findByPage(String key, PageBean<ClassesEntity> pageBean) {

        return classesDao.findByPage(key,pageBean);
    }

    @Override
    public void deleteBatch(String[] Ids) {
      classesDao.deleteBatch(Ids);
    }
}
