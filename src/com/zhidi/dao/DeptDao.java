package com.zhidi.dao;

import com.zhidi.entity.Dept;

/**
 * Created by Administrator on 2017/7/14.
 */
public interface DeptDao extends BaseDao<Dept,Integer>{
    public Dept getByName(String name);
}