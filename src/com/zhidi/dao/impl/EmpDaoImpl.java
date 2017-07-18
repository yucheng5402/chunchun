package com.zhidi.dao.impl;

import com.zhidi.dao.EmpDao;
import com.zhidi.entity.Emp;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/7/14.
 */
@Repository
public class EmpDaoImpl extends BaseDaoImpl<Emp,Integer> implements EmpDao {
    @Override
    public Emp getByName(String name) {
        return null;
    }
}
