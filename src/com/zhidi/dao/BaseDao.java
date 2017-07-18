package com.zhidi.dao;

import com.zhidi.util.Pager;
import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/7/14.
 */
public interface BaseDao<T,PK extends Serializable> {
    public T get(PK id);

    public List<T> getAll();

    public void delete(PK id);

    public void  save(T entity);

    public void  update(T entity);

    public Pager getListByPage(Pager pager, DetachedCriteria detachedCriteria);
}
