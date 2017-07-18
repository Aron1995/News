<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../head.jsp"%>
<script type="text/javascript">
	$(function(){
		$('#manNewsTable').edatagrid({
			url:'back/newsType.action?op=findAllNews',
			pagination:true,//显示分页
			pageSize:50,//默认分页数
			pageList:[5,10,15,20,30,50,100,200],
			fitColumns:true,//自适应列
			fit:true,//自动补全
			title:"新闻管理",
			idFiled:"tid",//标识，会记录每一行选中的主要数据
			rownumbers:"true",//显示行号
			nowrap:"true",//不换行显示
			sortName:"tid",//排序的列
			sortOrder:"desc",//排序方式
			singleSelect:true,
			
			//返回的onError
			onError:function(a,b){
				$.messager.alert("错误","操作失败");
			},
			columns:[[{
				field:'nid',
				title:'新闻编号',
				width:10,
				align:'center',
				hidden:'true'
			},{
				field:'title',
				title:'新闻内容',
				width:60,
				align:'center'
			},{
				field:'ndate',
				title:'发布时间',
				width:20,
				align:'center'
			},{
				field:'content',
				title:'详细',
				width:60,
				align:'center'
			},{
				field:'auth',
				title:'作者',
				width:20,
				align:'center'
			},{
				field:'pic',
				title:'图片',
				width:20,
				align:'center'
			},{
				field:'views',
				title:'浏览次数',
				width:20,
				align:'center'
			}]]
		});
	});
	
</script>
<title>新闻管理</title>
</head>
<body>
	<table id="manNewsTable">
	
	</table>
</body>
</html>