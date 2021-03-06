package com.mikey.msosle.action.latereturn;

import com.mikey.msosle.common.PageBean;
import com.mikey.msosle.model.LateReturnEntity;
import com.mikey.msosle.service.latereturn.LateReturnService;
import com.mikey.msosle.util.DateUtil;
import com.mikey.msosle.vo.R;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;


/**
 * @Program: YoungVolunteer
 * @Author: 麦奇
 * @Email： 1625017540@qq.com
 * @Create: 2019-06-05 09:24
 * @Describe：
 **/
public class LateReturnAction extends ActionSupport implements ModelDriven<LateReturnEntity> {

    @Autowired
    private LateReturnService lateReturnService;
    //日志
    private static Logger logger = Logger.getLogger(LateReturnEntity.class);
    //模型驱动
    private LateReturnEntity lateReturnEntity = new LateReturnEntity();
    //
    private PageBean<LateReturnEntity> pageBean = new PageBean<>();
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

    private String lateReturnTimes;

    /////////////////////////////////////////

    /**
     * 添加
     */
    public String save() {

        Date date = DateUtil.string2Date(lateReturnTimes, "yyyy-MM-dd hh:mm:ss");

        lateReturnEntity.setLateReturnTime(new java.sql.Timestamp(date.getTime()));

        logger.info("保存晚归信息："+lateReturnEntity);

        lateReturnService.save(lateReturnEntity);

        r = R.ok();

        return SUCCESS;
    }

    /**
     * 删除
     */
    public String delete() {

        lateReturnService.delete(lateReturnEntity);

        r = R.ok();

        return SUCCESS;
    }

    /**
     * 修改
     */
    public String update() {
        Date date = DateUtil.string2Date(lateReturnTimes, "yyyy-MM-dd hh:mm:ss");

        lateReturnEntity.setLateReturnTime(new java.sql.Timestamp(date.getTime()));

        lateReturnService.update(lateReturnEntity);

        r = R.ok();

        return SUCCESS;
    }

    /**
     * 查询
     *
     * @return
     */
    public String findById() {

        LateReturnEntity byId = lateReturnService.findById(lateReturnEntity);

        r = R.ok().put("data", byId);

        return SUCCESS;
    }

    /**
     * 查询
     */
    public String findByPage() {

        PageBean byPage = lateReturnService.findByPage(key, new PageBean<LateReturnEntity>().setCurrPage(page).setPageSize(limit));

        r = R.ok().put("data", byPage.getRows()).put("count", byPage.getTotal());

        logger.info("查询列表：" + r);

        return SUCCESS;
    }

    /**
     * 批量删除
     */
    public String deleteBatch() {


        String[] id = ids.split(",");


        lateReturnService.deleteBatch(id);

        r = R.ok();

        return SUCCESS;
    }

    @Override
    public LateReturnEntity getModel() {
        return lateReturnEntity;
    }


    /////////////////////////////////////////

    public LateReturnEntity getLateReturnEntity() {
        return lateReturnEntity;
    }

    public void setLateReturnEntity(LateReturnEntity lateReturnEntity) {
        this.lateReturnEntity = lateReturnEntity;
    }

    public PageBean<LateReturnEntity> getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean<LateReturnEntity> pageBean) {
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

    public String getLateReturnTimes() {
        return lateReturnTimes;
    }

    public void setLateReturnTimes(String lateReturnTimes) {
        this.lateReturnTimes = lateReturnTimes;
    }
}
