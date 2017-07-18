<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>

<title>新闻管理后台欢迎您</title>

<script type="text/javascript">
//相当于 $(document).ready(function(){});
	$(function(){
		var newsTypeTree=[{
			"text":"类别管理",
			"state":"closed",
			"children":[{
				"text":"新增类别",
				"attributes":{
					//"url":"back/manager/newsType/addType.jsp"
					"url":"<iframe width='100%' height='100%' src='back/manager/newsType/addType.jsp'/>"
				}
			},{
				"text":"类别维护",
				"attributes":{
					//"url":"back/manager/newsType/manType.jsp"
					"url":"<iframe width='100%' height='100%' src='back/manager/newsType/manType.jsp'/>"
				}
			}]
		}];
		
		var newsTree=[{
			"text":"新闻管理",
			"state":"closed",
			"children":[{
				"text":"新闻维护",
				"attributes":{
					//"url":"back/manager/newsType/addType.jsp"
					"url":"<iframe width='100%' height='100%' src='back/manager/news/manNews.jsp'/>"
				}
			},{
				"text":"添加新闻",
				"attributes":{
					//"url":"back/manager/newsType/manType.jsp"
					"url":"<iframe width='100%' height='100%' src='back/manager/news/addNews.jsp'/>"
				}
			}]
		}];
		var userTree=[{
			"text":"用户管理",
			"state":"closed",
			"children":[{
				"text":"查询用户",
				"attributes":{
					//"url":"back/manager/newsType/addType.jsp"
					"url":"<iframe width='100%' height='100%' src='back/manager/users/manUser.jsp'/>"
				}
			}]
		}];
		showTree("newsTypeTree",newsTypeTree);
		showTree("newsTree",newsTree);
		showTree("userTree",userTree);
	});
	
	function showTree(treeId,data){
		$("#"+treeId).tree({
			data:data, //将这里改成url:"right.action" 这个地址会得到一个上面的treeData字符串
			onClick:function(node){
				if(node.attributes){
					openTab(node);
				}
			}
		});
	}
	
	function openTab(node){
		if($("#mainTt").tabs("exists",node.text)){
			$("#mainTt").tabs("select",node.text);
		}else{
			$("#mainTt").tabs("add",{
				title:node.text,
				selected:true,
				closed:true,
				tools:[{
					iconCls:'icon-cancel',
					handler:function(){alert('save')}
				}],
				//href:node.attributes.url
				content:node.attributes.url
			})
		}
	}
</script>

</head>
<body class="easyui-layout layout panel-noscoll">
		<div data-options="region:'north'" style="height:50px;text-align:center">新闻管理后台</div>
		<div data-options="region:'south',split:true" style="height:50px;"></div>
		<div data-options="region:'east',split:true" title="工具窗口" style="width:150px;"></div>
		
		<div data-options="region:'west',split:true" title="管理窗口" style="width:150px;">
			<div class="easyui-accordion" style="width:500px;height:300px;">
				<div title="新闻类别管理" style="overflow:auto;padding:10px">
					<div class="easyui-panel" style="padding:5px">
						<ul id="newsTypeTree" class="easyui-tree" data-options="animate:true,state:closed,fit:true">
							
						</ul>
					</div>
				</div>
				<div title="新闻内容管理" style="overflow:auto;padding:10px">
					<div class="easyui-panel" style="padding:5px">
						<ul id="newsTree" class="easyui-tree" data-options="animate:true,state:closed,fit:true">
							
						</ul>
					</div>
				</div>
				<div title="用户信息管理" style="overflow:auto;padding:10px">
					<div class="easyui-panel" style="padding:5px">
						<ul id="userTree" class="easyui-tree" data-options="animate:true,state:closed,fit:true">
							
						</ul>
					</div>
				</div>
				<div title="权限管理" style="overflow:auto;padding:10px">
					权限管理
				</div>
			</div>
		</div>
		
		<div data-options="region:'center',title:'操作窗口',iconCls:'icon-ok'">
			<!-- tabs区 -->
			<div id="mainTt" class="easyui-tabs" data-options="fit:true,border:false" >
				<div title="待处理业务区" >欢迎您！</div>
			</div>
		</div>
</body>
</html>