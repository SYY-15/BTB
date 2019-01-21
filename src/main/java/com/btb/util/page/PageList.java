package com.btb.util.page;

import java.util.List;

import org.json.JSONObject;

/**
 * 分页查询
 * @author 18381
 *
 * @param <T>
 */
public class PageList<T> {
	private JSONObject jsonObject;
	
	public PageList() {
		jsonObject = new JSONObject();
	}
	public void setList(List<T> list) {
		jsonObject.put("list", list);
	}
	public void setTotalPage(int totalPage) {
		jsonObject.put("totalPage", totalPage);
	}
	public void setCurrentPage(int currentPage) {
		jsonObject.put("currentPage", currentPage);
	}
	@Override
	public String toString() {
		return jsonObject.toString();
	}
	
}
