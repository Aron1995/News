package com.yc.web.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.bean.News;
import com.yc.bean.NewsType;
import com.yc.biz.NewsBiz;
import com.yc.biz.NewsTypeBiz;
import com.yc.biz.impl.NewsBizImpl;
import com.yc.biz.impl.NewsTypeBizImpl;
import com.yc.utils.RequestUtil;

public class NewsTypeServlet extends BaseServlet {

	private static final long serialVersionUID = 2250949650692821375L;
	
	private NewsTypeBiz newsTypeBiz=new NewsTypeBizImpl();
	private NewsBiz newsBiz=new NewsBizImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
			if("findAll".equals(op)){
				findAll(req,resp);
			}else if("findAllNews".equals(op)){
				findAllNews(req,resp);
			}
		} catch(Exception e){
			e.printStackTrace();
			super.outJson(e.getMessage(), resp);
		}
		
	}

	private void findAllNews(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		News news=RequestUtil.getParameter(req, News.class);
		List<News> list=newsBiz.findNews(news);
		int count=newsBiz.findNewsCount(news);
		//easyui要求的格式
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("total", count);
		map.put("rows", list);
		super.outJson(map, resp);
		
	}

	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//page=1&rows=50&sort=tid&order=desc
		NewsType newsType=RequestUtil.getParameter(req, NewsType.class);
		List<NewsType> list=newsTypeBiz.findNewsType(newsType);
		int count=newsTypeBiz.findNewsCount(newsType);
		//easyui要求的格式
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("total", count);
		map.put("rows", list);
		super.outJson(map, resp);
	}
}
