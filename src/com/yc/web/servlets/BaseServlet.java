package com.yc.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public abstract class BaseServlet extends HttpServlet {
	protected String op;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		op=req.getParameter("op");
		super.service(req, resp);
	}

	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException{
		doPost(req,resp);
	}
	
	protected void outJson(Object obj,HttpServletResponse resp) throws IOException{
		Gson gson=new Gson();
		String jsonstr=gson.toJson(obj);
		outJsonstr(jsonstr,resp);
	}
	
	protected void outJsonstr(String jsonstr,HttpServletResponse resp) throws IOException{
		resp.setContentType("application/json;charset=utf-8");
		PrintWriter out=resp.getWriter();
		out.println(jsonstr);
		out.flush();
		out.close();
	}
}

