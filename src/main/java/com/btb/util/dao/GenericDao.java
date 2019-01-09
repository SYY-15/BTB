package com.btb.util.dao;

import java.util.List;

public abstract class GenericDao<T> extends BaseDao implements Dao<T> {

	@Override
	public List<T> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(T t) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(T t) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(T t) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
