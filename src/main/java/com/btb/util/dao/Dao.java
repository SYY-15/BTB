package com.btb.util.dao;

import java.util.List;

public interface Dao<T> {
	/**
	 * 查询所有
	 * @return 查询列表
	 * @throws Exception
	 */
    public List<T> findAll() throws Exception; 
    
    /**
     * 插入对象
     * @param t 新插入的对象
     * @return 受影响行数
     * @throws Exception
     */
    public int insert(T t) throws Exception;
    /**
     * 更新对象
     * @param t 要更新的对象
     * @return 受影响行数
     * @throws Exception
     */
    public int update(T t) throws Exception;
    
    /**
     * 删除对象
     * @param t 要删除的对象
     * @return 受影响行数
     * @throws Exception
     */
    public int delete(T t) throws Exception;
}
