package com.mikey.msosle.dao.student.impl;

import com.mikey.msosle.common.PageBean;
import com.mikey.msosle.dao.student.StudentDao;
import com.mikey.msosle.model.ClassesEntity;
import com.mikey.msosle.model.StudentEntity;
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
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void save(StudentEntity studentEntity) {
        sessionFactory.getCurrentSession().save(studentEntity);
    }

    @Override
    public void delete(StudentEntity studentEntity) {
        sessionFactory.getCurrentSession().delete(studentEntity);
    }

    @Override
    public void update(StudentEntity studentEntity) {
        sessionFactory.getCurrentSession().update(studentEntity);
    }

    @Override
    public StudentEntity findById(StudentEntity studentEntity) {
        Session session = sessionFactory.openSession();

        Criteria criteria = session.createCriteria(StudentEntity.class);

        List list = criteria.add(
                Restrictions.or(Restrictions.eq("studentId", studentEntity.getStudentId()
                )))
                .setFirstResult(0)
                .setMaxResults(1).list();

        session.close();

        return list!=null&&list.size()>0? (StudentEntity) list.get(0) :null;

    }

    @Override
    public PageBean findByPage(String key, PageBean<StudentEntity> pageBean) {
        Session session = sessionFactory.openSession();

        Criteria criteria = session.createCriteria(StudentEntity.class);

        if (key != null && !key.equals("")) {
            //搜索
            List list = criteria.add(
                    Restrictions.or(
                            Restrictions.or(Restrictions.like("studentId", key, MatchMode.ANYWHERE)),
                            Restrictions.or(Restrictions.like("studentNo", key, MatchMode.ANYWHERE))))
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
        List<StudentEntity> list = new ArrayList<>();

        for (String id : Ids) {

            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setStudentId(Integer.parseInt(id));
            list.add(studentEntity);

        }
        hibernateTemplate.deleteAll(list);
    }
}
