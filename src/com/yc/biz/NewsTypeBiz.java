package com.yc.biz;

import java.sql.SQLException;
import java.util.List;

import com.yc.bean.NewsType;

public interface NewsTypeBiz {
	/**
	 * 按照条件查询所有的有效新闻
	 * id;类别;状态
	 * @throws Exception 
	 */
	public List<NewsType> findNewsType(NewsType newsType) throws Exception;

	public Integer findNewsCount(NewsType newsType) throws SQLException;
	
}
