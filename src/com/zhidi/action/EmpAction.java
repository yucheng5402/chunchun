package com.zhidi.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zhidi.entity.Emp;
import com.zhidi.service.EmpService;
import com.zhidi.util.AjaxResult;
import com.zhidi.util.Pager;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/7/15.
 */
@ParentPackage("json-default")
@Namespace("/emp")
public class EmpAction extends ActionSupport {
    @Resource
    private EmpService empService;

    private List<Emp> list;

    private Integer empno;

    private Emp emp;

    private Pager pager;

    private String ename;

    private Date startTime;

    private Date endTime;

    private AjaxResult ajaxResult;

    //修改
    @Action(value = "edit",results = {
            @Result(name = "success",location = "edit.jsp")
    })
    public String edit() {
            emp = empService.get(empno);
            list = empService.getAll();
            return  SUCCESS;
    }

//修改之后的保存操作
    @Action(value = "update",results = {
           @Result(name = "success",type = "redirectAction",location = "list")

    })
    public String update(){
        empService.update(emp);
        return SUCCESS;
    }
//删除
   @Action(value = "del",results = {
            @Result(name = "success",type = "json",params = {
                    "root","ajaxResult"
            })
    })
    public String delete() {
        empService.delete(empno);
        ajaxResult.setFlag(true);
        ajaxResult.setMsg("删除成功");
        return SUCCESS;
    }

 //新增
    @Action(value = "add",results = {
            @Result(name = "success",location = "edit.jsp")
    })
    public String add() {
      list = empService.getAll();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("flag",true);
      return SUCCESS;
    }

    @Action(value = "save",results = {
            @Result(name = "success",type = "redirectAction",location = "list")
    })
    public String save() {
        empService.save(emp);
        return  SUCCESS;
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }

//联合查询
    @Action(value = "list",results = {
            @Result(name = "success",location = "list.jsp")
    })
    public String allList() {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Emp.class);
        if(StringUtils.isNotEmpty(ename)){
            detachedCriteria.add(Restrictions.like("ename","%"+ename+"%"));
        }
        if (startTime!=null){
            detachedCriteria.add(Restrictions.ge("hiredate",startTime));
        }
        if(endTime!= null) {
            detachedCriteria.add(Restrictions.ge("hiredate",endTime));
        }
         pager = empService.getListByPage(pager,detachedCriteria);
        return SUCCESS;
    }

    public List<Emp> getList() {
        return list;
    }

    public void setList(List<Emp> list) {
        this.list = list;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public AjaxResult getAjaxResult() {
        return ajaxResult;
    }

    public void setAjaxResult(AjaxResult ajaxResult) {
        this.ajaxResult = ajaxResult;
    }
}
