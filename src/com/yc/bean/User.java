package com.yc.bean;

import java.io.Serializable;

public class User implements Serializable{
	private int usid;
	private String uname;
	private String pwd;
	private String email;
	private int status;
	
	private String pwdagain;
	private String zcode;
	
	//easyui的datagrid传过来的值
	private Integer page;//当前第几页
	private Integer rows;//每页多少条
	private String sort;//排序字段
	private String order;//desc/asc
	
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
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
	public String getZcode() {
		return zcode;
	}
	public void setZcode(String zcode) {
		this.zcode = zcode;
	}
	public String getPwdagain() {
		return pwdagain;
	}
	public void setPwdagain(String pwdagain) {
		this.pwdagain = pwdagain;
	}
	public int getUsid() {
		return usid;
	}
	public void setUsid(int usid) {
		this.usid = usid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "User [usid=" + usid + ", uname=" + uname + ", pwd=" + pwd + ", email=" + email + ", status=" + status + "]";
	}
}
