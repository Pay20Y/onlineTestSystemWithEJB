<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%@page import="java.util.*"%>
<%@page import="javax.naming.*"%> 
<%@page import="com.ejb.stateless.*"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
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
	
	/*
	List<String> answer1 = searchAllRemote1.searchAnswer();
	List<String> answer2 = searchAllRemote2.searchAnswer();
	List<Integer> Score1 = searchAllRemote1.searchScore();
	List<Integer> Score2 = searchAllRemote2.searchScore();
	List<String> item1 = searchAllRemote2.searchItem1();
	List<String> item2 = searchAllRemote2.searchItem2();
	List<String> item3 = searchAllRemote2.searchItem3();
	List<String> item4 = searchAllRemote2.searchItem4();
	*/
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>添加试卷</title>
</head>
<body>
<a href="index.jsp">首页</a>
	<form name="forml" method="post" action="./addPaper">
		<table>
			<tr>
			<td>试卷名</td>
			<td><input type="text" name="paperName"></td>
			</tr>
		</table>
	<h3>选择题</h3><br/>
	<%for(int i = 0;i<question2.size();i++){ %>
		<input type="checkbox" name="opt" value="<%=id2.get(i)%>"><%=question2.get(i) %><br/>
	<%} %>
	<h3>问答题</h3><br/>
	<%for(int i = 0;i<question1.size();i++){ %>
		<input type="checkbox" name="nonopt" value="<%=id1.get(i)%>"><%=question1.get(i) %><br/>
	<%} %>
		<input type="hidden" name="nonoptnum" value="<%=id1.size() %>">
		<input type="hidden" name="optnum" value="<%=id2.size() %>">
		<input type="submit" value="添加">
	</form>
</body>
</html>