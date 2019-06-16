package com.mikey.msosle.service.student;

import com.mikey.msosle.common.PageBean;
import com.mikey.msosle.model.ClassesEntity;
import com.mikey.msosle.model.StudentEntity;

/**
 * @Program: YoungVolunteer
 * @Author: 麦奇
 * @Email： 1625017540@qq.com
 * @Create: 2019-06-04 00:09
 * @Describe：
 **/
public interface StudentService {
    /**
     * 添加
     */
    public void save(StudentEntity studentEntity);

    /**
     * 删除
     */
    public void delete(StudentEntity studentEntity);

    /**
     * 修改
     */
    public void update(StudentEntity studentEntity);

    /**
     * 查询
     *
     * @return
     */
    public StudentEntity findById(StudentEntity studentEntity);

    /**
     * 查询
     *
     * @param key
     * @param pageBean
     * @return
     */
    public PageBean findByPage(String key, PageBean<StudentEntity> pageBean);

    /**
     * 批量删除
     *
     * @param Ids
     */
    public void deleteBatch(String[] Ids);
}
