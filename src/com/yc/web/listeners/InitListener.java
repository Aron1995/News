package com.yc.web.listeners;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.yc.bean.NewsType;
import com.yc.biz.NewsTypeBiz;
import com.yc.biz.impl.NewsTypeBizImpl;
import com.yc.utils.LogUtil;

public class InitListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		NewsTypeBiz ntb=new NewsTypeBizImpl();
		NewsType newsType=new NewsType();
		newsType.setStatus(1);
		try {
			List<NewsType> list=ntb.findNewsType(newsType);
			ServletContext application=event.getServletContext();
			application.setAttribute("newsTypeList", list);
		} catch (Exception e) {
			e.getMessage();
			LogUtil.logger.error(e.getMessage());
		}
	}

}