package com.yc.biz.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yc.bean.NewsType;
import com.yc.biz.NewsTypeBiz;
import com.yc.dao.DbHelper;

public class NewsTypeBizImpl implements NewsTypeBiz{
	private DbHelper db=new DbHelper();
	
	public List<NewsType> findNewsType(NewsType newsType) throws Exception{
		String sql="select * from newstype where 1=1";
		List<Object> params=new ArrayList<Object>();
		if(newsType!=null){
			if(newsType.getTid()!=null){
				sql+=" and tid=? ";
				params.add(newsType.getTid());
			}else if(newsType.getTname()!=null){
				sql+=" and tname like ? ";
				params.add("%"+newsType.getTname()+"%");
			}else if(newsType.getStatus()!=null){
				sql+=" and status=? ";
				params.add(newsType.getStatus());
			}
		}
		if(newsType.getSort()!=null){
			sql+=" order by "+newsType.getSort()+" "+newsType.getOrder()+" ";
		}
		if(newsType.getPage()!=null){
			int start=(newsType.getPage()-1)*newsType.getRows();
			sql+=" limit "+start+","+newsType.getRows();
		}
		List<NewsType> list=db.findObject(sql, params, NewsType.class);
		return list;
	}

	@Override
	public Integer findNewsCount(NewsType newsType) throws SQLException {
		String sql="select count(*) from newstype where 1=1 ";
		List<Object> params=new ArrayList<Object>();
		if(newsType!=null){
			if(newsType.getTid()!=null){
				sql+=" and tid=? ";
				params.add(newsType.getTid());
			}else if(newsType.getTname()!=null){
				sql+=" and tname like ? ";
				params.add("%"+newsType.getTname()+"%");
			}else if(newsType.getStatus()!=null){
				sql+=" and status=? ";
				params.add(newsType.getStatus());
			}
		}
		int count=(int)db.getCount(sql, params);
		return count;
	}
}
