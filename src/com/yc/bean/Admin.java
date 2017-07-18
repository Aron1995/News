package com.yc.bean;

import java.io.Serializable;

public class Admin implements Serializable {

	private static final long serialVersionUID = 371525309521087732L;
	private Integer aid;
	private String aname;
	private String pwd;
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
