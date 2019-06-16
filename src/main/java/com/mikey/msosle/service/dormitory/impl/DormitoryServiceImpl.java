package com.mikey.msosle.service.dormitory.impl;

import com.mikey.msosle.common.PageBean;
import com.mikey.msosle.dao.dormitory.DormitoryDao;
import com.mikey.msosle.model.DormitoryEntity;
import com.mikey.msosle.service.dormitory.DormitoryService;
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
public class DormitoryServiceImpl implements DormitoryService {

    @Autowired
    private DormitoryDao dormitoryDao;

    @Override
    public void save(DormitoryEntity dormitoryEntity) {

        dormitoryDao.save(dormitoryEntity);
    }

    @Override
    public void delete(DormitoryEntity dormitoryEntity) {

        dormitoryDao.delete(dormitoryEntity);
    }

    @Override
    public void update(DormitoryEntity dormitoryEntity) {

        dormitoryDao.update(dormitoryEntity);
    }

    @Override
    public DormitoryEntity findById(DormitoryEntity dormitoryEntity) {
       return dormitoryDao.findById(dormitoryEntity);
    }

    @Override
    public PageBean findByPage(String key, PageBean<DormitoryEntity> pageBean) {

        return dormitoryDao.findByPage(key,pageBean);
    }

    @Override
    public void deleteBatch(String[] Ids) {
        dormitoryDao.deleteBatch(Ids);
    }
}
