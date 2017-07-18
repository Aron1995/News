package com.yc.biz.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yc.bean.News;
import com.yc.bean.PageBean;
import com.yc.biz.NewsBiz;
import com.yc.dao.DbHelper;

public class NewsBizImpl implements NewsBiz {
	private DbHelper db=new DbHelper();
	
	@Override
	public List<News> findNews(News news) throws Exception {
		String sql="select nid,title,ndate,content,auth,pic,news.tid,views,weight from news inner join newstype on newstype.tid=news.tid where 1=1 ";
		List<Object> params=new ArrayList<Object>();
		if(news!=null){
			if(news.getNid()!=null&&news.getNid()>0){
				sql+=" and nid=?";
				params.add(news.getNid());
			}else if(news.getTname()!=null&&!"".equals(news.getTname())){
				sql+=" and tname=? ";
				params.add(news.getTname());
			}else if(news.getPic()!=null&&"".equals(news.getPic())){
				sql+=" and pic is not null ";
			}
			if(news.getPages()!=null&&news.getPagesize()!=null){
				int pages=news.getPages();
				int pagesize=news.getPagesize();
				int start=(pages-1)*pagesize;
				sql+=" order by weight desc,ndate desc limit ?,? ";
				params.add(start);
				params.add(pagesize);
			}
		}
		if(news.getSort()!=null){
			sql+=" order by "+news.getSort()+" "+news.getOrder()+" ";
		}
		if(news.getPage()!=null){
			int start=(news.getPage()-1)*news.getRows();
			sql+=" limit "+start+","+news.getRows();
		}
		List<News> list=db.findObject(sql, params, News.class);
		return list;
	}

	public Integer findNewsCount(News news) throws SQLException{
		String sql="select count(*) from news inner join newstype on newstype.tid=news.tid where 1=1 ";
		List<Object> params=new ArrayList<Object>();
		if(news!=null){
			if(news.getNid()!=null&&news.getNid()>0){
				sql+=" and nid=?";
				params.add(news.getNid());
			}else if(news.getTname()!=null&&!"".equals(news.getTname())){
				sql+=" and tname=? ";
				params.add(news.getTname());
			}else if(news.getPic()!=null&&"".equals(news.getPic())){
				sql+=" and pic is not null ";
			}
		}
		int count=(int)db.getCount(sql, params);
		return count;
	}

	//查找新闻 分类，包括分页
	@Override
	public PageBean<News> findNewsByPage(News news) throws Exception {
		int total=findNewsCount(news);
		List<News> allNewsList=findNews(news);
		PageBean<News> pageBean=new PageBean<News>();
		pageBean.setPages(news.getPages());
		pageBean.setPagesize(news.getPagesize());
		pageBean.setRows(allNewsList);
		pageBean.setTotal(total);
		return pageBean;
	}
	
	public void addNews(News news) throws SQLException{
		String sql="insert into news(title,ndate,content,auth,pic,tid,views,weight) values(?,sysdate(),?,?,?,?,0,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(news.getTitle());
		params.add(news.getContent());
		params.add(news.getAuth());
		params.add(news.getPic());
		params.add(news.getTid());
		params.add(news.getWeight());
		db.doSingleUpdate(sql, params);
	}
}
