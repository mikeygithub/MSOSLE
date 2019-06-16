package com.mikey.msosle.dao.dorm;

import com.mikey.msosle.common.PageBean;
import com.mikey.msosle.model.DormEntity;

/**
 * @Program: YoungVolunteer
 * @Author: 麦奇
 * @Email： 1625017540@qq.com
 * @Create: 2019-06-04 00:09
 * @Describe：
 **/
public interface DormDao {
    /**
     * 添加
     */
    public void save(DormEntity dormEntity);

    /**
     * 删除
     */
    public void delete(DormEntity dormEntity);

    /**
     * 修改
     */
    public void update(DormEntity dormEntity);

    /**
     * 查询
     *
     * @return
     */
    public DormEntity findById(DormEntity dormEntity);

    /**
     * 查询
     *
     * @param key
     * @param pageBean
     * @return
     */
    public PageBean findByPage(String key, PageBean<DormEntity> pageBean);

    /**
     * 批量删除
     *
     * @param Ids
     */
    public void deleteBatch(String[] Ids);
}
