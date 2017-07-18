<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../head.jsp"%>
<script type="text/javascript">
	$(function(){
		$('#manUserTable').edatagrid({
			url:'back/users.action?op=findUser',
			pagination:true,//显示分页
			pageSize:50,//默认分页数
			pageList:[5,10,15,20,30,50,100,200],
			fitColumns:true,//自适应列
			fit:true,//自动补全
			title:"查询用户",
			idFiled:"usid",//标识，会记录每一行选中的主要数据
			rownumbers:"true",//显示行号
			nowrap:"true",//不换行显示
			sortName:"usid",//排序的列
			sortOrder:"desc",//排序方式
			singleSelect:true,
			
			//返回的onError
			onError:function(a,b){
				$.messager.alert("错误","操作失败");
			},
			columns:[[{
				field:'usid',
				title:'用户编号',
				width:10,
				align:'center',
				hidden:'true'
			},{
				field:'uname',
				title:'用户名',
				width:20,
				align:'center'
			},{
				field:'pwd',
				title:'密码',
				width:40,
				align:'center'
			},{
				field:'email',
				title:'邮箱',
				width:60,
				align:'center'
			},{
				field:'status',
				title:'状态',
				width:20,
				align:'center'
			}]]
		});
	});
	
</script>
<title>查询用户</title>
</head>
<body>
	<table id="manUserTable">
	
	</table>
</body>
</html>