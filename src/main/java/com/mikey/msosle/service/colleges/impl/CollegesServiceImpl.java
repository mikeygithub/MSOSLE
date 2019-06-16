package com.mikey.msosle.service.colleges.impl;

import com.mikey.msosle.common.PageBean;
import com.mikey.msosle.dao.colleges.CollegesDao;
import com.mikey.msosle.model.CollegesEntity;
import com.mikey.msosle.service.colleges.CollegesService;
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
public class CollegesServiceImpl implements CollegesService {

    @Autowired
    private CollegesDao collegesDao;

    @Override
    public void save(CollegesEntity collegesEntity) {

        collegesDao.save(collegesEntity);

    }

    @Override
    public void delete(CollegesEntity collegesEntity) {

        collegesDao.delete(collegesEntity);

    }

    @Override
    public void update(CollegesEntity collegesEntity) {

        collegesDao.update(collegesEntity);

    }

    @Override
    public CollegesEntity findById(CollegesEntity collegesEntity) {
       return collegesDao.findById(collegesEntity);
    }

    @Override
    public PageBean findByPage(String key, PageBean<CollegesEntity> pageBean) {
        return collegesDao.findByPage(key,pageBean);
    }

    @Override
    public void deleteBatch(String[] Ids) {
       collegesDao.deleteBatch(Ids);
    }
}
