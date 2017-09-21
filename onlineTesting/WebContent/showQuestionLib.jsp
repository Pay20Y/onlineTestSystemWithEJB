<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%@page import="java.util.*"%>
<%@page import="javax.naming.*"%> 
<%@page import="com.ejb.stateless.*"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	boolean admin = false;
	String username= (String)session.getAttribute("username");
	if(username != null){
		if(username.equals("admin")){
			admin = true;
		}
	}
	Hashtable<String, String> jndiProperties = new Hashtable<String,String>();
	jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
	String title = null;
	Context context=new InitialContext(jndiProperties);
	final String appName="";
	final String moduleName="QuesSessionEJB";
	final String distinctName="";
	Object object1=context.lookup("ejb:"+appName+"/"+moduleName+"/"+distinctName+"/getQuestion1!com.ejb.stateless.getQuestion1Remote");
	getQuestion1Remote searchAllRemote1=(getQuestion1Remote)object1;
	Object object2=context.lookup("ejb:"+appName+"/"+moduleName+"/"+distinctName+"/getQuestion2!com.ejb.stateless.getQuestion2Remote");
	getQuestion2Remote searchAllRemote2=(getQuestion2Remote)object2;
	
	
	List<Integer> id1 = searchAllRemote1.searchID();
	List<Integer> id2 = searchAllRemote2.searchID();
	List<String> question1 = searchAllRemote1.searchTitle();
	List<String> question2 = searchAllRemote2.searchTitle();
	List<String> answer1 = searchAllRemote1.searchAnswer();
	List<String> answer2 = searchAllRemote2.searchAnswer();
	List<Integer> Score1 = searchAllRemote1.searchScore();
	List<Integer> Score2 = searchAllRemote2.searchScore();
	List<String> item1 = searchAllRemote2.searchItem1();
	List<String> item2 = searchAllRemote2.searchItem2();
	List<String> item3 = searchAllRemote2.searchItem3();
	List<String> item4 = searchAllRemote2.searchItem4();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>现存题库</title>
	<link rel="stylesheet" href="./css/bootstrap.min.css"/>
	<link rel="stylesheet" href="./css/main.css"/>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<a href="index.jsp">在线考试系统</a>
	</nav>
	<div class="container">
		<div class="row">
			<h3>选择题：</h3>
			<%for(int i=0;i<question2.size();i++){%>
			<div class="row">
				<div class="panel panel-default">
					<!-- Default panel contents -->
					<div class="panel-heading"><%=i+1 %>、<%=question2.get(i) %></div>

					<!-- List group -->
					<ul class="list-group">
						<%if(admin) {%>
						<li class="list-group-item"><a href="deleteQuestion?opt=<%=id2.get(i)%>&option=2">删除</a></li>
						<%}%>

						<li class="list-group-item">A.<%=item1.get(i) %></li>
						<li class="list-group-item">B.<%=item2.get(i) %></li>
						<li class="list-group-item">C.<%=item3.get(i) %></li>
						<li class="list-group-item">D.<%=item4.get(i) %></li>
						<li class="list-group-item">正确答案: <%=answer2.get(i) %></li>
						<li class="list-group-item">分值: <%=Score2.get(i) %></li>
					</ul>
				</div>
			</div>
			<%} %>
			<a role="button" class="btn btn-success" href="addQuestion_other.xhtml">添加新题目</a>
		</div>

		<div class="row">
			<h3>简答题：</h3>
			<%for(int j=0;j<question1.size();j++){%>
			<div class="row">
				<div class="panel panel-default">
					<!-- Default panel contents -->
					<div class="panel-heading"><%=j+1 %>、<%=question1.get(j) %></div>
					<div class="panel-body">
						<p>正确答案:<%=answer1.get(j) %></p>
					</div>
					<!-- List group -->
					<ul class="list-group">
						<li class="list-group-item">分值:<%=Score1.get(j) %></li>
						<%if(admin) {%>
						<li class="list-group-item"><a href="deleteQuestion?opt=<%=id1.get(j)%>&option=1">删除</a></li>
						<%}%>
					</ul>
				</div>
			</div>
			<%} %>
			<a role="button" class="btn btn-success" href="addQuestion.xhtml">添加新题目</a>
		</div>

	</div>
</body>
</html>