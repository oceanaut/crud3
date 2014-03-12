package com.tutorialspoint.test.service;

import java.io.Serializable;
import java.util.List;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation= Propagation.REQUIRED, readOnly=false)
public class HibernateDao<E, K extends Serializable> implements IGenericDao<E, K> {

	private SessionFactory sessionFactory;
    protected Class<? extends E> daoType;
    
    public HibernateDao() {
        daoType = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }
    
    
	@Override
	public void add(E entity) {
		// TODO Auto-generated method stub
		currentSession().save(entity);		
	}

	@Override
	public void update(E entity) {
		// TODO Auto-generated method stub
		currentSession().saveOrUpdate(entity);
	}

	@Override
	public void remove(E entity) {
		// TODO Auto-generated method stub
		currentSession().delete(entity);
	}

	@Override
	public E find(K key) {
		// TODO Auto-generated method stub
		return (E) currentSession().get(daoType, key);
	}

	@Override
	public List<E> list() {
		// TODO Auto-generated method stub
		return currentSession().createCriteria(daoType).list();
	}

}
