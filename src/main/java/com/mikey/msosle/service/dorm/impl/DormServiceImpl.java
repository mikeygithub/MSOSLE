package com.mikey.msosle.service.dorm.impl;

import com.mikey.msosle.common.PageBean;
import com.mikey.msosle.dao.dorm.DormDao;
import com.mikey.msosle.dao.dormitory.DormitoryDao;
import com.mikey.msosle.model.DormEntity;
import com.mikey.msosle.service.dorm.DormService;
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
public class DormServiceImpl implements DormService {

    @Autowired
    private DormDao dormDao;

    @Override
    public void save(DormEntity dormEntity) {

        dormDao.save(dormEntity);

    }

    @Override
    public void delete(DormEntity dormEntity) {

        dormDao.delete(dormEntity);

    }

    @Override
    public void update(DormEntity dormEntity) {

        dormDao.update(dormEntity);

    }

    @Override
    public DormEntity findById(DormEntity dormEntity) {

       return dormDao.findById(dormEntity);

    }

    @Override
    public PageBean findByPage(String key, PageBean<DormEntity> pageBean) {

        return dormDao.findByPage(key,pageBean);

    }

    @Override
    public void deleteBatch(String[] Ids) {
        dormDao.deleteBatch(Ids);
    }
}
