package com.mikey.msosle.dao.latereturn.impl;

import com.mikey.msosle.common.PageBean;
import com.mikey.msosle.dao.latereturn.LateReturnDao;
import com.mikey.msosle.model.LateReturnEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
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
public class LateReturnDaoImpl implements LateReturnDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void save(LateReturnEntity lateReturnEntity) {
        sessionFactory.getCurrentSession().save(lateReturnEntity);
    }

    @Override
    public void delete(LateReturnEntity lateReturnEntity) {
        sessionFactory.getCurrentSession().delete(lateReturnEntity);
    }

    @Override
    public void update(LateReturnEntity lateReturnEntity) {
        sessionFactory.getCurrentSession().update(lateReturnEntity);
    }

    @Override
    public LateReturnEntity findById(LateReturnEntity lateReturnEntity) {
        Session session = sessionFactory.openSession();

        Criteria criteria = session.createCriteria(LateReturnEntity.class);

        List list = criteria.add(
                Restrictions.or(Restrictions.eq("lateReturnId", lateReturnEntity.getLateReturnId())))
                .setFirstResult(0)
                .setMaxResults(1).list();

        session.close();

        return list!=null&&list.size()>0? (LateReturnEntity) list.get(0) :null;

    }

    @Override
    public PageBean findByPage(String key, PageBean<LateReturnEntity> pageBean) {
        Session session = sessionFactory.openSession();

        Criteria criteria = session.createCriteria(LateReturnEntity.class);

        if (key != null && !key.equals("")) {
            //搜索
            List list = criteria.add(
                    Restrictions.or(
                            Restrictions.or(Restrictions.like("studentNo", key, MatchMode.ANYWHERE)),
                            Restrictions.or(Restrictions.like("studentName", key, MatchMode.ANYWHERE)),
                            Restrictions.or(Restrictions.like("studentSex", key, MatchMode.ANYWHERE))))
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
        List<LateReturnEntity> list = new ArrayList<>();

        for (String id : Ids) {

            LateReturnEntity lateReturnEntity = new LateReturnEntity();
            lateReturnEntity.setLateReturnId(Integer.parseInt(id));
            list.add(lateReturnEntity);
        }
        hibernateTemplate.deleteAll(list);
    }
}
