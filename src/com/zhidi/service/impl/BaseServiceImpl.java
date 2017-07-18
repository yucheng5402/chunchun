package com.zhidi.service.impl;

import com.zhidi.dao.BaseDao;
import com.zhidi.service.BaseService;
import com.zhidi.util.Pager;
import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/7/14.
 */
public class BaseServiceImpl<T,PK extends Serializable> implements BaseService<T,PK>{

            private BaseDao baseDao;

            public void setBaseDao(BaseDao baseDao) {
                this.baseDao = baseDao;
            }

    @Override
    public T get(PK id) {
        return (T) baseDao.get(id);
    }

    @Override
    public List<T> getAll() {
        return baseDao.getAll();
    }

    @Override
    public void delete(PK id) {
            baseDao.delete(id);
    }

    @Override
    public void save(T entity) {
        baseDao.save(entity);
    }

    @Override
    public void update(T entity) {
        baseDao.update(entity);
    }

    @Override
    public Pager getListByPage(Pager pager, DetachedCriteria detachedCriteria) {
        return baseDao.getListByPage(pager,detachedCriteria);
    }
}
