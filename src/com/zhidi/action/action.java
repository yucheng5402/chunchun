package com.zhidi.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zhidi.entity.Emp;
import com.zhidi.service.DeptService;
import com.zhidi.service.EmpService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/7/14.
 */
public class action extends ActionSupport{

    private String msg;
    @Resource
    private EmpService empService;
    @Resource
    private DeptService deptService;

    private List<Emp> list;
    @Override
    public String execute() throws Exception {
        List<Emp> list = empService.getAll();
        return SUCCESS;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
