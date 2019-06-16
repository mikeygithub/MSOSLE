package com.mikey.msosle.dao.dormitory;

import com.mikey.msosle.common.PageBean;
import com.mikey.msosle.model.DormitoryEntity;

/**
 * @Program: YoungVolunteer
 * @Author: 麦奇
 * @Email： 1625017540@qq.com
 * @Create: 2019-06-04 00:09
 * @Describe：
 **/
public interface DormitoryDao {
    /**
     * 添加
     */
    public void save(DormitoryEntity dormitoryEntity);

    /**
     * 删除
     */
    public void delete(DormitoryEntity dormitoryEntity);

    /**
     * 修改
     */
    public void update(DormitoryEntity dormitoryEntity);

    /**
     * 查询
     *
     * @return
     */
    public DormitoryEntity findById(DormitoryEntity dormitoryEntity);

    /**
     * 查询
     *
     * @param key
     * @param pageBean
     * @return
     */
    public PageBean findByPage(String key, PageBean<DormitoryEntity> pageBean);

    /**
     * 批量删除
     *
     * @param Ids
     */
    public void deleteBatch(String[] Ids);
}
