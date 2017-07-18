package com.zhidi.dao.impl;

import com.zhidi.dao.BaseDao;
import com.zhidi.util.Pager;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 2017/7/14.
 */
public class BaseDaoImpl<T,PK extends Serializable> implements BaseDao<T,PK>{

    @Resource
    private SessionFactory sessionFactory;

    //实际类型的Class对象
    private  Class<T> entityClass;

    public BaseDaoImpl() {
        Class clz = getClass();
        Type type = clz.getGenericSuperclass();
        if(type instanceof ParameterizedType) {
             Type[] types = ((ParameterizedType) type).getActualTypeArguments();
             entityClass = (Class<T>) types[0];
        }


    }
    //获取session的方法
    public Session getSession() {
        return  sessionFactory.getCurrentSession();
    }

    @Override
    public T get(PK id) {
        return (T) getSession().get(entityClass,id);
    }

    @Override
    public List<T> getAll() {
        return (List<T>) getSession().createQuery("from "+entityClass.getName()).list();
    }

    @Override
    public void delete(PK id) {
        T entity = get(id);
         getSession().delete(entity);
    }

    @Override
    public void save(T entity) {
        getSession().save(entity);
    }

    @Override
    public void update(T entity) {
        getSession().update(entity);
    }

    @Override
    public Pager getListByPage(Pager pager, DetachedCriteria detachedCriteria) {
        if (pager==null) {
            pager = new Pager();
        }
        /*Integer totalRows = getAll().size();
        pager.setTotalRows(totalRows);
        pager.setTotalPage(pager.getTotalPage());
        Query query = getSession().createQuery("from "+entityClass.getName());
        //设置从哪里开始查询
        query.setFirstResult((pager.getPageNumber()-1)*pager.getPageSize());
        //设置每页最大查询数量
        query.setMaxResults(pager.getPageSize());
        List list = query.list();
        pager.setList(list);*/
       /* Criteria criteria = getSession().createCriteria(entityClass);
        criteria.setProjection(Projections.rowCount());*/

       //通过Criteria写分页条件查询
        Criteria criteria = detachedCriteria.getExecutableCriteria(getSession());
        Integer totalRows = Integer.parseInt(criteria.setProjection(Projections.rowCount()).uniqueResult().toString());
        pager.setTotalRows(totalRows);
        pager.setTotalPage(pager.getTotalPage());
        criteria.setProjection((Projection) null);
        criteria.setFirstResult((pager.getPageNumber()-1)*pager.getPageSize());
        criteria.setMaxResults(pager.getPageSize());
        List list = criteria.list();
        pager.setList(list);
        return pager;
    }
}
