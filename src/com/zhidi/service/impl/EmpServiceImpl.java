package com.zhidi.service.impl;

import com.zhidi.dao.EmpDao;
import com.zhidi.entity.Emp;
import com.zhidi.service.EmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/7/14.
 */
@Service
public class EmpServiceImpl extends BaseServiceImpl<Emp,Integer> implements EmpService{
    @Resource
    //由于没有EmpDao类，ioc容器会去找相同类型（即实现类）
    private EmpDao empDao;

    //通过set方法注入父类（即BaseDao）
    @Resource
    private void setEmpDao(EmpDao empDao) {
        //由于empDao是继承了BaseDao，相当于通过子类初始化父类
        super.setBaseDao(empDao);
    }

}
