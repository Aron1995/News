package com.yc.web.servlets;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yc.bean.Admin;
import com.yc.bean.JsonBean;
import com.yc.bean.News;
import com.yc.bean.User;
import com.yc.biz.AdminBiz;
import com.yc.biz.UserBiz;
import com.yc.biz.impl.AdminBizImpl;
import com.yc.biz.impl.UserBizImpl;
import com.yc.utils.RequestUtil;

public class UsersServlet extends BaseServlet {
	private UserBiz userBiz=new UserBizImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if("reg".equals(op)){
			reg(req,resp);
		}else if("login".equals(op)){
			login(req,resp);
		}else if("findUser".equals(op)){
			try {
				findUser(req,resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	private void findUser(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		User user=RequestUtil.getParameter(req, User.class);
		List<User> list=userBiz.findUser(user);
		int count=userBiz.findUserCount(user);
		//easyui要求的格式
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("total", count);
		map.put("rows", list);
		super.outJson(map, resp);
	}

	//登录
	private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		JsonBean jsonBean=new JsonBean();
		try {
			User user=RequestUtil.getParameter(req, User.class);
			user=userBiz.login(user);
			jsonBean.setCode(1);
			jsonBean.setObj(user);
			HttpSession session=req.getSession();
			session.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
			jsonBean.setCode(0);
			jsonBean.setErrorMsg(e.getMessage());
		}
		super.outJson(jsonBean, resp);
	}

	//注册
	private void reg(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		JsonBean jsonBean=new JsonBean();
		try {
			User user=RequestUtil.getParameter(req, User.class);
			//判断验证码
			//从session取出标准验证码
			HttpSession session=req.getSession();
			String rand=(String) session.getAttribute("rand");
			if(user.getZcode()!=null&&rand.equals(user.getZcode())){
				userBiz.reg(user);
				jsonBean.setCode(1);
				jsonBean.setObj("注册成功");
				super.outJsonstr("注册成功", resp);
			}else{
				jsonBean.setCode(0);
				jsonBean.setObj("验证码不正确");
			}
		} catch (Exception e) {
			e.printStackTrace();
			jsonBean.setCode(0);
			jsonBean.setErrorMsg("服务器错误："+e.getMessage());
		}
		super.outJson(jsonBean, resp);
	}
	
}
