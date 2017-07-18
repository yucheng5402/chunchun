package com.zhidi.dao;

import com.zhidi.entity.Emp;

/**
 * Created by Administrator on 2017/7/14.
 */
public interface EmpDao extends BaseDao<Emp,Integer> {
    public Emp getByName(String name);
}
