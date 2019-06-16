package com.mikey.msosle.dao.dorm.impl;

import com.mikey.msosle.common.PageBean;
import com.mikey.msosle.dao.dorm.DormDao;
import com.mikey.msosle.model.DormEntity;
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
public class DormDaoImpl implements DormDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void save(DormEntity dormEntity) {
        sessionFactory.getCurrentSession().save(dormEntity);
    }

    @Override
    public void delete(DormEntity dormEntity) {
        sessionFactory.getCurrentSession().delete(dormEntity);
    }

    @Override
    public void update(DormEntity dormEntity) {
        sessionFactory.getCurrentSession().update(dormEntity);
    }

    @Override
    public DormEntity findById(DormEntity dormEntity) {
        Session session = sessionFactory.openSession();

        Criteria criteria = session.createCriteria(DormEntity.class);

        List list = criteria.add(
                Restrictions.or(Restrictions.eq("dormId", dormEntity.getDormId())))
                .setFirstResult(0)
                .setMaxResults(1).list();

        session.close();

        return list!=null&&list.size()>0? (DormEntity) list.get(0) :null;

    }

    @Override
    public PageBean findByPage(String key, PageBean<DormEntity> pageBean) {
        Session session = sessionFactory.openSession();

        Criteria criteria = session.createCriteria(DormEntity.class);

        if (key != null && !key.equals("")) {
            //搜索
            List list = criteria.add(
                    Restrictions.or(
                            Restrictions.or(Restrictions.like("DormName", key, MatchMode.ANYWHERE))))
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
        List<DormEntity> list = new ArrayList<>();

        for (String id : Ids) {
            DormEntity dormEntity = new DormEntity();

            dormEntity.setDormId(Integer.parseInt(id));

            list.add(dormEntity);
        }
        hibernateTemplate.deleteAll(list);
    }
}
