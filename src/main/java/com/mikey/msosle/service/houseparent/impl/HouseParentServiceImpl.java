package com.mikey.msosle.service.houseparent.impl;

import com.mikey.msosle.common.PageBean;
import com.mikey.msosle.dao.houseparent.HouseparentDao;
import com.mikey.msosle.model.HouseparentEntity;
import com.mikey.msosle.service.houseparent.HouseparentService;
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
public class HouseParentServiceImpl implements HouseparentService {

    @Autowired
    private HouseparentDao houseparentDao;

    @Override
    public void save(HouseparentEntity houseparentEntity) {
        houseparentDao.save(houseparentEntity);
    }

    @Override
    public void delete(HouseparentEntity houseparentEntity) {

        houseparentDao.delete(houseparentEntity);
    }

    @Override
    public void update(HouseparentEntity houseparentEntity) {

        houseparentDao.update(houseparentEntity);

    }

    @Override
    public HouseparentEntity findById(HouseparentEntity houseparentEntity) {


            return houseparentDao.findById(houseparentEntity);
    }

    @Override
    public PageBean findByPage(String key, PageBean<HouseparentEntity> pageBean) {

        return houseparentDao.findByPage(key,pageBean);
    }

    @Override
    public void deleteBatch(String[] Ids) {
        houseparentDao.deleteBatch(Ids);
    }
}
