package com.yc.web.servlets;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yc.bean.News;
import com.yc.bean.NewsType;
import com.yc.bean.PageBean;
import com.yc.biz.NewsBiz;
import com.yc.biz.NewsTypeBiz;
import com.yc.biz.impl.NewsBizImpl;
import com.yc.biz.impl.NewsTypeBizImpl;
import com.yc.utils.RequestUtil;

public class NewsServlet extends BaseServlet{
	private static final long serialVersionUID = -5446435166013567324L;
	private NewsBiz newsBiz=new NewsBizImpl();
	private NewsTypeBiz newsTypeBiz=new NewsTypeBizImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			if("findNews".equals(op)){
				findNews(req,resp);
			}else if("showDetail".equals(op)){
				showDetail(req,resp);
			}
		}catch (Exception e) {
			e.printStackTrace();
			super.outJsonstr(e.getMessage(), resp);
		}
	}

	private void showDetail(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		News news=RequestUtil.getParameter(req, News.class);
		List<News> list=newsBiz.findNews(news);
		if(list!=null&&list.size()>0){
			News n=list.get(0);
			HttpSession session=req.getSession();
			session.setAttribute("news", n);
		}
		req.getRequestDispatcher("/WEB-INF/jsp/detail.jsp").forward(req, resp);
	}

	private void findNews(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		News news=RequestUtil.getParameter(req, News.class);
		PageBean<News> pageBean=newsBiz.findNewsByPage(news);
		//gson 不能直接解析泛型  typetoken转换
		Gson gson=new Gson();
		Type jsonType=new TypeToken<PageBean<News>>(){}.getType();
		String jsonStr=gson.toJson(pageBean,jsonType);
		super.outJsonstr(jsonStr, resp);
	}
}
