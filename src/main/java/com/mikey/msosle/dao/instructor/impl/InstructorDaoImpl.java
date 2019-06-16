package com.mikey.msosle.dao.instructor.impl;

import com.mikey.msosle.common.PageBean;
import com.mikey.msosle.dao.instructor.InstructorDao;
import com.mikey.msosle.model.InstructorEntity;
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
public class InstructorDaoImpl implements InstructorDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void save(InstructorEntity instructorEntity) {
        sessionFactory.getCurrentSession().save(instructorEntity);
    }

    @Override
    public void delete(InstructorEntity instructorEntity ) {
        sessionFactory.getCurrentSession().delete(instructorEntity);
    }

    @Override
    public void update(InstructorEntity instructorEntity) {
        sessionFactory.getCurrentSession().update(instructorEntity);
    }

    @Override
    public InstructorEntity findById(InstructorEntity instructorEntity) {
        Session session = sessionFactory.openSession();

        Criteria criteria = session.createCriteria(InstructorEntity.class);

        List list = criteria.add(
                Restrictions.or(Restrictions.eq("instructorId", instructorEntity.getInstructorId())))
                .setFirstResult(0)
                .setMaxResults(1).list();

        session.close();

        return list!=null&&list.size()>0? (InstructorEntity) list.get(0) :null;

    }

    @Override
    public PageBean findByPage(String key, PageBean<InstructorEntity> pageBean) {
        Session session = sessionFactory.openSession();

        Criteria criteria = session.createCriteria(InstructorEntity.class);

        if (key != null && !key.equals("")) {
            //搜索
            List list = criteria.add(
                    Restrictions.or(
                            Restrictions.or(Restrictions.like("instructorName", key, MatchMode.ANYWHERE))))
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
        List<InstructorEntity> list = new ArrayList<>();

        for (String id : Ids) {

            InstructorEntity instructorEntity = new InstructorEntity();
            instructorEntity.setInstructorId(Integer.parseInt(id));
            list.add(instructorEntity);
        }
        hibernateTemplate.deleteAll(list);
    }
}
