package com.mikey.msosle.action.dormitory;

import com.mikey.msosle.common.PageBean;
import com.mikey.msosle.model.DormitoryEntity;
import com.mikey.msosle.service.dormitory.DormitoryService;
import com.mikey.msosle.vo.R;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @Program: YoungVolunteer
 * @Author: 麦奇
 * @Email： 1625017540@qq.com
 * @Create: 2019-06-05 09:24
 * @Describe：
 **/
public class DormitoryAction extends ActionSupport implements ModelDriven<DormitoryEntity> {

    @Autowired
    private DormitoryService dormitoryService;
    //日志
    private static Logger logger = Logger.getLogger(DormitoryEntity.class);
    //模型驱动
    private  DormitoryEntity dormitoryEntity = new DormitoryEntity();
    //
    private PageBean<DormitoryEntity> pageBean = new PageBean<>();
    //返回集
    private R r = new R();
    //搜索值
    private String key;
    //当前页
    private Integer page;
    //大小
    private Integer limit;
    //批量删除id
    private String ids;

    /////////////////////////////////////////

    /**
     * 添加
     */
    public String save() {

        dormitoryService.save(dormitoryEntity);

        r = R.ok();

        return SUCCESS;
    }

    /**
     * 删除
     */
    public String delete() {

        dormitoryService.delete(dormitoryEntity);

        r = R.ok();

        return SUCCESS;
    }

    /**
     * 修改
     */
    public String update() {

        dormitoryService.update(dormitoryEntity);

        r = R.ok();

        return SUCCESS;
    }

    /**
     * 查询
     *
     * @return
     */
    public String findById() {

        DormitoryEntity byId = dormitoryService.findById(dormitoryEntity);

        r = R.ok().put("data", byId);

        return SUCCESS;
    }

    /**
     * 查询
     */
    public String findByPage() {

        PageBean byPage = dormitoryService.findByPage(key, new PageBean<DormitoryEntity>().setCurrPage(page).setPageSize(limit));

        r = R.ok().put("data", byPage.getRows()).put("count", byPage.getTotal());

        logger.info("查询列表：" + r);

        return SUCCESS;
    }

    /**
     * 批量删除
     */
    public String deleteBatch() {


        String[] id = ids.split(",");


        dormitoryService.deleteBatch(id);

        r = R.ok();

        return SUCCESS;
    }

    @Override
    public DormitoryEntity getModel() {
        return dormitoryEntity;
    }


    /////////////////////////////////////////

    public DormitoryEntity getDormitoryEntity() {
        return dormitoryEntity;
    }

    public void setDormitoryEntity(DormitoryEntity dormitoryEntity) {
        this.dormitoryEntity = dormitoryEntity;
    }

    public PageBean<DormitoryEntity> getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean<DormitoryEntity> pageBean) {
        this.pageBean = pageBean;
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {
        this.r = r;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}
