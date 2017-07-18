package com.yc.biz.impl;

import java.util.ArrayList;
import java.util.List;

import com.yc.bean.Admin;
import com.yc.biz.AdminBiz;
import com.yc.dao.DbHelper;
import com.yc.utils.Encrypt;

public class AdminBizImpl implements AdminBiz {
	private DbHelper db=new DbHelper();
	@Override
	public Admin login(Admin admin) throws Exception {
		String sql="select * from admin where aname=? and pwd=?";
		List<Object> params=new ArrayList<Object>();
		params.add(admin.getAname());
		params.add(Encrypt.md5(admin.getPwd()));
		
		List<Admin> list=db.findObject(sql, params, Admin.class);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}
}
