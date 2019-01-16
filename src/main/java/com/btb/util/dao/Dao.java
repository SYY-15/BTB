package com.btb.util.dao;

import java.util.List;

public interface Dao<T> {
	/**
	 * 查询所有
	 * @return 结果列表
	 */
    public List<T> findList(); 
    
    /**
     * 保存
     * @param t 需要保存的对象
     * @return 受影响行数
     */
    public int save(T t);
    
    /**
     * 删除
     * @param t 要删除的对象
     * @return 受影响行数
     */
    public int delete(T t);
}
