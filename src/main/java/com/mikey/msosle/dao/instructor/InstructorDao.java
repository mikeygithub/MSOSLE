package com.mikey.msosle.dao.instructor;

import com.mikey.msosle.common.PageBean;
import com.mikey.msosle.model.InstructorEntity;

/**
 * @Program: YoungVolunteer
 * @Author: 麦奇
 * @Email： 1625017540@qq.com
 * @Create: 2019-06-04 00:09
 * @Describe：
 **/
public interface InstructorDao {
    /**
     * 添加
     */
    public void save(InstructorEntity instructorEntity);

    /**
     * 删除
     */
    public void delete(InstructorEntity instructorEntity);

    /**
     * 修改
     */
    public void update(InstructorEntity instructorEntity);

    /**
     * 查询
     *
     * @return
     */
    public InstructorEntity findById(InstructorEntity instructorEntity);

    /**
     * 查询
     *
     * @param key
     * @param pageBean
     * @return
     */
    public PageBean findByPage(String key, PageBean<InstructorEntity> pageBean);

    /**
     * 批量删除
     *
     * @param Ids
     */
    public void deleteBatch(String[] Ids);
}
