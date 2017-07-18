package com.yc.web.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class UploadSinglePicFileServlet extends HttpServlet {
	private String filepath;
	private String allowedFilesList="jpg,png,bmp,gif";
	private String deniedFileList="bat,sh,exe,class,html,js,css";
	private long maxFileSize=2000000;
	private long totalMaxFileSize=4*maxFileSize;

	
	@Override
	public void init(ServletConfig config) throws ServletException {
		if(config.getInitParameter("allowedFilesList")!=null){
			allowedFilesList=config.getInitParameter("allowedFilesList");
		}else if(config.getInitParameter("deniedFileList")!=null){
			deniedFileList=config.getInitParameter("deniedFileList");
		}else if(config.getInitParameter("maxFileSize")!=null){
			maxFileSize=Long.parseLong(config.getInitParameter("maxFileSize"));
		}else if(config.getInitParameter("totalMaxFileSize")!=null){
			totalMaxFileSize=Long.parseLong(config.getInitParameter("totalMaxFileSize"));
		}
		super.init(config);//调用父类方法读取配置
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//要回调客户端的javaScript配置
		String callback=req.getParameter("CKEditorFuncNum");
		SmartUpload su=new SmartUpload();
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=null;
		
		try {
			PageContext context=JspFactory.getDefaultFactory().getPageContext(this, req, resp, null, true, 8*1024, true);
			su.initialize(context);
			
			su.setCharset("utf-8");
			
			//定义上传文件类型
			su.setAllowedFilesList(allowedFilesList);
			//不允许上传文件类型
			su.setDeniedFilesList(deniedFileList);
			//单个文件最大限制
			su.setMaxFileSize(maxFileSize);
			//所有上传文件的总容量控制
			su.setTotalMaxFileSize(totalMaxFileSize);
			
			su.upload();
			//获取单个文件 java.io.File
			com.jspsmart.upload.File file=su.getFiles().getFile(0);
			//设置在服务器的保存位置
			String tomcatwebroot=this.getServletConfig().getServletContext().getRealPath("/");
			File newsroot=new File(tomcatwebroot);
			File tomcatRootFile=newsroot.getParentFile();
			filepath=tomcatRootFile+"/news_uploadpics/";
			String webUrl="../news_uploadpics/";
			DateFormat df=new SimpleDateFormat("yyyy/MM/");
			String timeDir=df.format(new Date());
			filepath+=timeDir;
			
			webUrl+=timeDir;
			//判断文件是否存在
			File f=new File(filepath);
			if(f.exists()==false){
				f.mkdirs();
			}
			//拼装要保存的文件新文件名
			String fileName=genFileName(file.getFileName());
			filepath+=fileName;
			webUrl+=fileName;
			//文件另存为
			file.saveAs(filepath,SmartUpload.SAVE_PHYSICAL);
			
			//文件保存位置传回客户端
			out=resp.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("window.parent.CKEDITOR.tools.callFunction("+callback+",'"+webUrl+"','上传文件成功');");
			out.println("</script>");
		} catch (Exception e) {
			e.printStackTrace();
			out=resp.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("window.parent.CKEDITOR.tools.callFunction("+callback+",'"+e.getMessage()+"','上传失败');");
			out.println("</script>");
		}
		out.flush();
		out.close();
	}

	private String genFileName(String fileName){
		String[] strs=fileName.split("\\.");
		DateFormat df=new SimpleDateFormat("yyyyMMddHHmmss");
		String prefix=df.format(new Date());
		return prefix+"."+strs[1];
		
	}
}
