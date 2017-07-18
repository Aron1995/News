package com.yc.biz;

import java.sql.SQLException;
import java.util.List;

import com.yc.bean.User;

public interface UserBiz {
	/**
	 * 将user对象存到数据库，成功，返回true, 失败，返回false
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	public boolean reg(User user) throws Exception;
	
	public User login(User user) throws Exception;
	
	public List<User> findUser(User user) throws Exception;
	
	public Integer findUserCount(User user) throws SQLException;
}