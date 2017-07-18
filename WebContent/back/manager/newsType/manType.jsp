<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../head.jsp"%>
<script type="text/javascript">
	$(function(){
		$('#manTypeTable').edatagrid({
			url:'back/newsType.action?op=findAll',
			pagination:true,//显示分页
			pageSize:50,//默认分页数
			pageList:[5,10,15,20,30,50,100,200],
			fitColumns:true,//自适应列
			fit:true,//自动补全
			title:"新闻类别管理",
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
				field:'tid',
				title:'新闻编号',
				width:100,
				align:'center',
				hidden:'true'
			},{
				field:'tname',
				title:'新闻类别',
				width:100,
				align:'center'
			},{
				field:'status',
				title:'状态',
				width:100,
				align:'center'
			}]]
		});
	});
	
</script>

<title>添加新闻类别</title>
</head>
<body>
	<table id="manTypeTable">
	
	</table>
</body>
</html>