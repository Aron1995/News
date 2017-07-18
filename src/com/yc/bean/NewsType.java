package com.yc.bean;

import java.io.Serializable;

public class NewsType implements Serializable{
	private static final long serialVersionUID = -7384976614552516204L;
	private Integer tid;
	private String tname;
	private Integer status;
	//page=1&rows=50&sort=tid&order=desc
	private Integer page;
	private Integer rows;
	private String sort;
	private String order;
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public NewsType() {
		super();
	}
	public NewsType(Integer tid, String tname, Integer status) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.status = status;
	}
	@Override
	public String toString() {
		return "NewsType [tid=" + tid + ", tname=" + tname + ", status=" + status + "]";
	}
}
