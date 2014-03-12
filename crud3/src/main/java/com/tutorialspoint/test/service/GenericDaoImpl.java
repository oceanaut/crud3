package com.tutorialspoint.test.service;

import java.util.ArrayList;
import java.util.List;

public class GenericDaoImpl<E,K> implements IGenericDao<E, K> {

	private List<E> entities = new ArrayList<E>();
	
	@Override
	public void add(E entity) {
		// TODO Auto-generated method stub
		entities.add(entity);		
	}

	@Override
	public void update(E entity) {
		// TODO Auto-generated method stub
		 throw new UnsupportedOperationException("Not supported in dummy in-memory impl!");
	}

	@Override
	public void remove(E entity) {
		// TODO Auto-generated method stub
		entities.remove(entity);		
	}

	@Override
	public E find(K key) {
		// TODO Auto-generated method stub
		if (entities.isEmpty()) {
            return null;
        }
        // just return the first one since we are not using any keys ATM
        return entities.get(0);
	}

	@Override
	public List<E> list() {
		// TODO Auto-generated method stub
		return entities;
	}

}
