package com.mikey.msosle.dao.houseparent.impl;

import com.mikey.msosle.common.PageBean;
import com.mikey.msosle.dao.houseparent.HouseparentDao;
import com.mikey.msosle.model.HouseparentEntity;
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
public class HouseParentDaoImpl implements HouseparentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void save(HouseparentEntity houseparentEntity) {
        sessionFactory.getCurrentSession().save(houseparentEntity);
    }

    @Override
    public void delete(HouseparentEntity houseparentEntity) {
        sessionFactory.getCurrentSession().delete(houseparentEntity);
    }

    @Override
    public void update(HouseparentEntity houseparentEntity) {
        sessionFactory.getCurrentSession().update(houseparentEntity);
    }

    @Override
    public HouseparentEntity findById(HouseparentEntity houseparentEntity) {
        Session session = sessionFactory.openSession();

        Criteria criteria = session.createCriteria(HouseparentEntity.class);

        List list = criteria.add(
                Restrictions.or(Restrictions.eq("houseParentId", houseparentEntity.getHouseparentId())))
                .setFirstResult(0)
                .setMaxResults(1).list();

        session.close();

        return list!=null&&list.size()>0? (HouseparentEntity) list.get(0) :null;

    }

    @Override
    public PageBean findByPage(String key, PageBean<HouseparentEntity> pageBean) {
        Session session = sessionFactory.openSession();

        Criteria criteria = session.createCriteria(HouseparentEntity.class);

        if (key != null && !key.equals("")) {
            //搜索
            List list = criteria.add(
                    Restrictions.or(
                            Restrictions.or(Restrictions.like("houseparentName", key, MatchMode.ANYWHERE))))
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
        List<HouseparentEntity> list = new ArrayList<>();

        for (String id : Ids) {
            HouseparentEntity houseparentEntity = new HouseparentEntity();
            houseparentEntity.setHouseparentId(Integer.parseInt(id));
            list.add(houseparentEntity);
        }
        hibernateTemplate.deleteAll(list);
    }
}
