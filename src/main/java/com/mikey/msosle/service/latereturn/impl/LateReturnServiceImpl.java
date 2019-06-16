package com.mikey.msosle.service.latereturn.impl;

import com.mikey.msosle.common.PageBean;
import com.mikey.msosle.dao.latereturn.LateReturnDao;
import com.mikey.msosle.model.LateReturnEntity;
import com.mikey.msosle.service.latereturn.LateReturnService;
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
public class LateReturnServiceImpl implements LateReturnService {

    @Autowired
    private LateReturnDao lateReturnDao;
    @Override
    public void save(LateReturnEntity lateReturnEntity) {

        lateReturnDao.save(lateReturnEntity);
    }

    @Override
    public void delete(LateReturnEntity lateReturnEntity) {

        lateReturnDao.delete(lateReturnEntity);
    }

    @Override
    public void update(LateReturnEntity lateReturnEntity) {
        lateReturnDao.update(lateReturnEntity);
    }

    @Override
    public LateReturnEntity findById(LateReturnEntity lateReturnEntity) {
       return lateReturnDao.findById(lateReturnEntity);
    }

    @Override
    public PageBean findByPage(String key, PageBean<LateReturnEntity> pageBean) {

        return lateReturnDao.findByPage(key,pageBean);
    }

    @Override
    public void deleteBatch(String[] Ids) {
       lateReturnDao.deleteBatch(Ids);
    }
}
