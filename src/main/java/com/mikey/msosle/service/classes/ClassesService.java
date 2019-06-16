package com.mikey.msosle.service.classes;

import com.mikey.msosle.common.PageBean;
import com.mikey.msosle.model.ClassesEntity;

/**
 * @Program: YoungVolunteer
 * @Author: 麦奇
 * @Email： 1625017540@qq.com
 * @Create: 2019-06-04 00:09
 * @Describe：
 **/
public interface ClassesService {
    /**
     * 添加
     */
    public void save(ClassesEntity classesEntity);

    /**
     * 删除
     */
    public void delete(ClassesEntity classesEntity);

    /**
     * 修改
     */
    public void update(ClassesEntity classesEntity);

    /**
     * 查询
     *
     * @return
     */
    public ClassesEntity findById(ClassesEntity classesEntity);

    /**
     * 查询
     *
     * @param key
     * @param pageBean
     * @return
     */
    public PageBean findByPage(String key, PageBean<ClassesEntity> pageBean);

    /**
     * 批量删除
     *
     * @param Ids
     */
    public void deleteBatch(String[] Ids);
}
