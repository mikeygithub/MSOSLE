package com.mikey.msosle.action.houseparent;

import com.mikey.msosle.common.PageBean;
import com.mikey.msosle.model.HouseparentEntity;
import com.mikey.msosle.model.SysUserEntity;
import com.mikey.msosle.service.houseparent.HouseparentService;
import com.mikey.msosle.service.sysuser.SysUserService;
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
public class HouseParentAction extends ActionSupport implements ModelDriven<HouseparentEntity> {

    @Autowired
    private HouseparentService houseparentService;
    @Autowired
    private SysUserService sysUserService;
    //日志
    private static Logger logger = Logger.getLogger(HouseparentEntity.class);
    //模型驱动
    private HouseparentEntity houseparentEntity = new HouseparentEntity();
    //
    private PageBean<HouseparentEntity> pageBean = new PageBean<>();
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

        houseparentService.save(houseparentEntity);

        SysUserEntity sysUserEntity = new SysUserEntity();

        sysUserEntity.setLoginAccount(houseparentEntity.getHouseparentCode());
        //1:系统管理员,2:辅导员,3:宿管员
        sysUserEntity.setRoleType(3);
        sysUserEntity.setLoginPassword("123456");
        sysUserEntity.setUserName(houseparentEntity.getHouseparentName());
        sysUserService.saveUser(sysUserEntity);

        r = R.ok();

        return SUCCESS;
    }

    /**
     * 删除
     */
    public String delete() {

        houseparentService.delete(houseparentEntity);

        r = R.ok();

        return SUCCESS;
    }

    /**
     * 修改
     */
    public String update() {

        houseparentService.update(houseparentEntity);

        r = R.ok();

        return SUCCESS;
    }

    /**
     * 查询
     *
     * @return
     */
    public String findById() {

        HouseparentEntity byId = houseparentService.findById(houseparentEntity);

        r = R.ok().put("data", byId);

        return SUCCESS;
    }

    /**
     * 查询
     */
    public String findByPage() {

        PageBean byPage = houseparentService.findByPage(key, new PageBean<HouseparentEntity>().setCurrPage(page).setPageSize(limit));

        r = R.ok().put("data", byPage.getRows()).put("count", byPage.getTotal());

        logger.info("查询列表：" + r);

        return SUCCESS;
    }

    /**
     * 批量删除
     */
    public String deleteBatch() {


        String[] id = ids.split(",");

        houseparentService.deleteBatch(id);

        r = R.ok();

        return SUCCESS;
    }

    @Override
    public HouseparentEntity getModel() {
        return houseparentEntity;
    }


    /////////////////////////////////////////

    public HouseparentEntity getHouseparentEntity() {
        return houseparentEntity;
    }

    public void setHouseparentEntity(HouseparentEntity houseparentEntity) {
        this.houseparentEntity = houseparentEntity;
    }

    public PageBean<HouseparentEntity> getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean<HouseparentEntity> pageBean) {
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
