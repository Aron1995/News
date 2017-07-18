package com.yc.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yc.bean.Admin;
import com.yc.biz.AdminBiz;
import com.yc.biz.impl.AdminBizImpl;
import com.yc.utils.RequestUtil;

public class AdminServlet extends BaseServlet {
	private AdminBiz adminBiz=new AdminBizImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			if("login".equals(op)){
				login(req,resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//登录
	private void login(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session=req.getSession();
		String rand=(String)session.getAttribute("rand");
		String vcode=req.getParameter("vcode");
		if(rand.equals(vcode)){
			Admin admin=RequestUtil.getParameter(req, Admin.class);
			admin=adminBiz.login(admin);
			if(admin!=null){
				session.setAttribute("admin", admin);
				resp.sendRedirect("manager/main.jsp");
			}else{
				resp.sendRedirect("/back/login.html");
			}
		}else{
			resp.sendRedirect("/back/login.html");
		}
	}
}
