package com.zhidi.dao.impl;

import com.zhidi.dao.DeptDao;
import com.zhidi.entity.Dept;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/7/14.
 */
@Repository
public class DeptDaoImpl extends BaseDaoImpl<Dept,Integer> implements DeptDao {
    @Override
    public Dept getByName(String name) {
        return null;
    }
}
