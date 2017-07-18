package com.yc.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.bean.News;
import com.yc.biz.NewsBiz;
import com.yc.biz.impl.NewsBizImpl;
import com.yc.utils.LogUtil;

public class InitServlet extends BaseServlet {
	private NewsBiz newsBiz=new NewsBizImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//查出所有新闻
			News n1=new News("国内",1,11);
			List<News> nativeNewsList=newsBiz.findNews(n1);
			req.setAttribute("nativeNewsList", nativeNewsList);
			
			News n2=new News("国际",1,11);
			List<News> nationalNewsList=newsBiz.findNews(n2);
			req.setAttribute("nationalNewsList", nationalNewsList);
			
			News n3=new News("娱乐",1,11);
			List<News> amuseNewsList=newsBiz.findNews(n3);
			req.setAttribute("amuseNewsList", amuseNewsList);
			
			News n4=new News();
			n4.setPic("");
			n4.setPages(1);
			n4.setPagesize(4);
			List<News> picNewsList=newsBiz.findNews(n4);
			req.setAttribute("picNewsList", picNewsList);
			
//			News n5=new News();
//			n5.setPages(1);
//			n5.setPagesize(30);
//			List<News> allNewsList=newsBiz.findNews(n5);
//			req.setAttribute("allNewsList", allNewsList);
		} catch (Exception e) {
			e.getMessage();
			LogUtil.logger.error(e.getMessage());
		}
		
		req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
	}
}
