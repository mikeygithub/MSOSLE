package com.mikey.msosle.dao.houseparent;

import com.mikey.msosle.common.PageBean;
import com.mikey.msosle.model.HouseparentEntity;

/**
 * @Program: YoungVolunteer
 * @Author: 麦奇
 * @Email： 1625017540@qq.com
 * @Create: 2019-06-04 00:09
 * @Describe：
 **/
public interface HouseparentDao {
    /**
     * 添加
     */
    public void save(HouseparentEntity houseparentEntity);

    /**
     * 删除
     */
    public void delete(HouseparentEntity houseparentEntity);

    /**
     * 修改
     */
    public void update(HouseparentEntity houseparentEntity);

    /**
     * 查询
     *
     * @return
     */
    public HouseparentEntity findById(HouseparentEntity houseparentEntity);

    /**
     * 查询
     *
     * @param key
     * @param pageBean
     * @return
     */
    public PageBean findByPage(String key, PageBean<HouseparentEntity> pageBean);

    /**
     * 批量删除
     *
     * @param Ids
     */
    public void deleteBatch(String[] Ids);
}
