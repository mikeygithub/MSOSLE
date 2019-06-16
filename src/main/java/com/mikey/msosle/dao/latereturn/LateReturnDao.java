package com.mikey.msosle.dao.latereturn;

import com.mikey.msosle.common.PageBean;
import com.mikey.msosle.model.ClassesEntity;
import com.mikey.msosle.model.LateReturnEntity;

/**
 * @Program: YoungVolunteer
 * @Author: 麦奇
 * @Email： 1625017540@qq.com
 * @Create: 2019-06-04 00:09
 * @Describe：
 **/
public interface LateReturnDao {
    /**
     * 添加
     */
    public void save(LateReturnEntity lateReturnEntity);

    /**
     * 删除
     */
    public void delete(LateReturnEntity lateReturnEntity);

    /**
     * 修改
     */
    public void update(LateReturnEntity lateReturnEntity);

    /**
     * 查询
     *
     * @return
     */
    public LateReturnEntity findById(LateReturnEntity lateReturnEntity);

    /**
     * 查询
     *
     * @param key
     * @param pageBean
     * @return
     */
    public PageBean findByPage(String key, PageBean<LateReturnEntity> pageBean);

    /**
     * 批量删除
     *
     * @param Ids
     */
    public void deleteBatch(String[] Ids);
}
