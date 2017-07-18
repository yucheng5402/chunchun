package com.zhidi.service.impl;

import com.zhidi.dao.DeptDao;
import com.zhidi.entity.Dept;
import com.zhidi.service.DeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/7/14.
 */
@Service
public class DeptServiceImpl extends BaseServiceImpl<Dept,Integer> implements DeptService {
    @Resource
    private DeptDao deptDao;

    @Resource
    private void setDeptDao(DeptDao deptDao){
        super.setBaseDao(deptDao);
    }
}
