package com.btb.util.dao;

import java.util.List;

import com.btb.util.page.PageList;

public interface Dao<T> {
	/**
	 * 查询所有
	 * @return 结果列表
	 */
    public List<T> findList(); 
    /**
     * 分页查询
     * @param page 查询页码
     * @return 分页结果
     */
    public PageList<T> pageList(int currentPage);
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
