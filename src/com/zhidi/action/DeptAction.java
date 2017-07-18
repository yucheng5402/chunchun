package com.zhidi.action;

import com.zhidi.entity.Dept;
import com.zhidi.service.DeptService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import javax.annotation.Resource;
import java.util.List;

import static com.opensymphony.xwork2.Action.SUCCESS;

/**
 * Created by Administrator on 2017/7/17.
 */
@ParentPackage("json-default")
@Namespace("/dept")
public class DeptAction {
    @Resource
    private DeptService deptService;

    private List<Dept> list;
    @Action(value = "listAjax", results = {
            @Result(name = SUCCESS, type = "json", params = {
                    "root","list"
            })
    })
    public String listAjax() {
        list = deptService.getAll();
        return SUCCESS;
    }

    public List<Dept> getList() {
        return list;
    }

    public void setList(List<Dept> list) {
        this.list = list;
    }



}
