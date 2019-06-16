package com.mikey.msosle.dao.dormitory.impl;

import com.mikey.msosle.common.PageBean;
import com.mikey.msosle.dao.dormitory.DormitoryDao;
import com.mikey.msosle.model.DormitoryEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Program: YoungVolunteer
 * @Author: 麦奇
 * @Email： 1625017540@qq.com
 * @Create: 2019-06-04 00:32
 * @Describe：
 **/
@Component
public class DormitoryDaoImpl implements DormitoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void save(DormitoryEntity dormitoryEntity) {
        sessionFactory.getCurrentSession().save(dormitoryEntity);
    }

    @Override
    public void delete(DormitoryEntity dormitoryEntity) {
        sessionFactory.getCurrentSession().delete(dormitoryEntity);
    }

    @Override
    public void update(DormitoryEntity dormitoryEntity) {
        sessionFactory.getCurrentSession().update(dormitoryEntity);
    }

    @Override
    public DormitoryEntity findById(DormitoryEntity dormitoryEntity) {
        Session session = sessionFactory.openSession();

        Criteria criteria = session.createCriteria(DormitoryEntity.class);

        List list = criteria.add(
                Restrictions.or(Restrictions.eq("dormitoryId", dormitoryEntity.getDormitoryId())))
                .setFirstResult(0)
                .setMaxResults(1).list();

        session.close();

        return list!=null&&list.size()>0? (DormitoryEntity) list.get(0) :null;

    }

    @Override
    public PageBean findByPage(String key, PageBean<DormitoryEntity> pageBean) {
        Session session = sessionFactory.openSession();

        Criteria criteria = session.createCriteria(DormitoryEntity.class);

        if (key != null && !key.equals("")) {
            //搜索
            List list = criteria.add(
                    Restrictions.or(
                            Restrictions.or(Restrictions.like("dormitoryName", key, MatchMode.ANYWHERE))))
                    .setFirstResult((pageBean.getCurrPage() - 1) * pageBean.getPageSize() )
                    .setMaxResults((pageBean.getCurrPage() - 1) * pageBean.getPageSize() + pageBean.getPageSize()).list();
            pageBean.setRows(list);
        } else {
            pageBean.setRows(
                    criteria.setFirstResult((pageBean.getCurrPage() - 1) * pageBean.getPageSize())
                            .setMaxResults((pageBean.getCurrPage() - 1) * pageBean.getPageSize() + pageBean.getPageSize()).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list());
        }

        pageBean.setTotal(Math.toIntExact((Long) criteria.setProjection(Projections.rowCount()).uniqueResult()));
        session.close();

        return pageBean;
    }

    @Override
    public void deleteBatch(String[] Ids) {
        List<DormitoryEntity> list = new ArrayList<>();

        for (String id : Ids) {

            DormitoryEntity dormitoryEntity =  new DormitoryEntity();
            dormitoryEntity.setDormitoryId(Integer.parseInt(id));
            list.add(dormitoryEntity);
        }
        hibernateTemplate.deleteAll(list);
    }
}
