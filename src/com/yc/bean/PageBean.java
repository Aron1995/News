package com.yc.bean;

import java.io.Serializable;
import java.util.List;

public class PageBean<T> implements Serializable {
	/**
	 * 分页的bean
	 */
	private static final long serialVersionUID = 7313229623726375795L;
	
	private Integer total;//总记录数
	private Integer pages;//当前第几页
	private Integer pagesize;//每页xx条
	private List<T> rows;//记录集合
	public Integer getTotal() {
		return total;
	}
	//记录总记录数 要先调用 setPageSize(),setPages()
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	public Integer getPagesize() {
		return pagesize;
	}
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public PageBean(Integer total, Integer pages, Integer pagesize, List<T> rows) {
		super();
		this.total = total;
		this.pages = pages;
		this.pagesize = pagesize;
		this.rows = rows;
	}
	public PageBean() {
		super();
	}
	@Override
	public String toString() {
		return "PageBean [total=" + total + ", pages=" + pages + ", pagesize=" + pagesize + ", rows=" + rows + "]";
	}
}
