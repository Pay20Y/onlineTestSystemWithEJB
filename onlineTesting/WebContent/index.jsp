<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%@page import="java.util.*"%>
<%@page import="javax.naming.*"%> 
<%@page import="com.ejb.stateless.*"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
boolean admin = false;
boolean teacher = false;
if(session.getAttribute("userid") != null){
int userid = Integer.valueOf((String)session.getAttribute("userid"));
}

String username= (String)session.getAttribute("username");
if(username != null){
	if(username.equals("admin")){
		admin = true;
	}
}
String role = (String)session.getAttribute("role");
if(role != null){
	if(role.equals("teacher")){
		teacher = true;
	}
}
System.out.println("managedbean----session:"+username);
session.setAttribute("action",null);//clear cookie
session.setAttribute("answer",null);
session.setAttribute("security",null);
session.setAttribute("password",null);
//session.setAttribute("username",null);

Hashtable<String, String> jndiProperties = new Hashtable<String,String>();
jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
String title = null;
	Context context=new InitialContext(jndiProperties);
	final String appName="";
	final String moduleName="InfoSessionEJB";
	final String distinctName="";
	Object object=context.lookup("ejb:"+appName+"/"+moduleName+"/"+distinctName+"/getInfo!com.ejb.stateless.getInfoRemote");
	getInfoRemote searchAllRemote=(getInfoRemote)object;
	List<String> titles = searchAllRemote.searchTitle();
	List<Date> dates = searchAllRemote.searchDate();
	List<Integer> Ids = searchAllRemote.searchId();
	//String list = searchAllRemote.search();
	//title = list;
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>欢迎来到在线考试系统</title>
<link rel="stylesheet" href="./css/bootstrap.min.css"/>
<link rel="stylesheet" href="./css/main.css"/>
</head>
<body>

<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
		<div class="navbar-bar"><a href="index.jsp">在线考试系统</a></div>
			<%if(username == null){ %>
			<ul class="nav nav-pills nav-right">
				<li role="presentation"><a class="btn btn-success" href="Signup.xhtml">注册</a></li>
				<li role="presentation"><a class="btn btn-success" href="Login.xhtml">登录</a></li>
			</ul>
		<%}else if(!admin && !teacher){ %>
			<span>欢迎你,<%=username %></span>
			<ul class="nav nav-pills center-block">
				<li role="presentation"><a class="btn btn-success" href="init.jsp">退出登录</a></li>
				<li role="presentation"><a class="btn btn-success" href="myZone.jsp">我的考试</a></li>
				<li role="presentation"><a class="btn btn-success" href="myCollect.jsp">我的收藏</a></li>
				<li role="presentation"><a class="btn btn-success" href="updateUser.xhtml">修改信息</a></li>
			</ul>
			<%}else if(admin){ %>
			<span>管理员模式</span>
			<ul class="nav nav-pills center-block">
			<li role="presentation"><a class="btn btn-success" href="init.jsp">退出登录</a></li>
			</ul>
			<%}else if(teacher){ %>
			<span>欢迎您,<%=username %>老师  <a class="btn btn-success" href="init.jsp">退出登录</a> <a class="btn btn-success" href="unJudged.jsp">待批阅</a></span>
			<%} %>

		</div>
	</div>
</nav>

<div class="container">
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8">
			<table class="table">
				<tr>
					<td>
						最新资讯
					</td>
					<td>
						发布时间
					</td>
				</tr>
				<%for(int i=0;i<titles.size();i++){ %>
				<tr>
					<td>
						<a href="InfoDetail.jsp?id=<%=Ids.get(i) %>"><%=titles.get(i) %></a>
					</td>
					<td>
						<%=dates.get(i) %>
					</td>
					<% if(admin){%>
					<td><a href="deleteInfo?id=<%=Ids.get(i)%>">删除</a></td>
					<%} %>
				</tr>
				<%} %>
			</table>
		</div>
		<div class="col-md-2"></div>
	</div>
	<div class="row">
		<%if(admin){ %>
		<!--  	<a href="postInfo.xhtml">发布新消息</a>  -->
		<input type="button" class="btn btn-success center-block" onclick="window.location.href('postInfo.xhtml')" value='+'>
		<%} %>
	</div>
	<div class="row">
		<%if(teacher) {%>
		<a role="button" class="btn btn-success center-block" href="showQuestionLib.jsp">查看题库</a>  <a role="button" class="btn btn-success center-block" href="showPaper.jsp">查看试卷</a> <a role="button" href="unJudged.jsp">查看未批阅</a>
		<%} %>
		<%if((username != null)&& !admin && !teacher) {%>	
		<a role="button" class="btn btn-success center-block" href="ApplyTest.jsp">考试报名</a>
		<%} %>
		<%if(teacher){ %>
		<a role="button" href="addQuestion.xhtml">添加题目</a>
		<%} %>
	</div>
</div>



</body>
</html>