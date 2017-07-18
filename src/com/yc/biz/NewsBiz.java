package com.yc.biz;

import java.sql.SQLException;
import java.util.List;

import com.yc.bean.News;
import com.yc.bean.PageBean;

public interface NewsBiz{
	//根据条件查询新闻
	public List<News> findNews(News news) throws Exception;
	
	//查询新闻数目
	public Integer findNewsCount(News news) throws SQLException;
	
	//查找分页数据，以上的整合
	public PageBean<News> findNewsByPage(News news) throws Exception;
	
	public void addNews(News news) throws SQLException;
}
