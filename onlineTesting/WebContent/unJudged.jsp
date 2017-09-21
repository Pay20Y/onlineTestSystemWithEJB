<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%@page import="java.util.*"%>
<%@page import="javax.naming.*"%> 
<%@page import="com.ejb.stateless.*"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	Hashtable<String, String> jndiProperties = new Hashtable<String,String>();
	jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
	Context context=new InitialContext(jndiProperties);
	final String appName="";
	final String moduleName="JudgedSessionEJB";
	final String distinctName="";
	Object object=context.lookup("ejb:"+appName+"/"+moduleName+"/"+distinctName+"/getJudged!com.ejb.stateless.getJudgedRemote");
	getJudgedRemote searchAllRemote=(getJudgedRemote)object;
	
	List<Integer> jids = searchAllRemote.getJudgedID();
	List<Integer> ids = searchAllRemote.getTestID();
	List<String> titles = searchAllRemote.getTitle();
	List<String> answer = searchAllRemote.getAnswer();
	List<Integer> score = searchAllRemote.getScore();
	int num = 0;
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>待批阅</title>
</head>
<body>
	<form name="form1" action="./getJudged" method="post">
	<table border='1'>
		<tr>
			<td>题目</td>
			<td>答案</td>
			<td>分值</td>
			<td>判分</td>
		</tr>
		<%for(int i = 0;i<ids.size();i++){ 
				num++;%>
			<tr>
				<td><%=titles.get(i) %></td>			
				<td><%=answer.get(i) %></td>
				<td><%=score.get(i) %></td>
				<td><input type="text" name="judge<%=i%>"></td>
			</tr>
			<input type="hidden" name="jid<%=i %>" value="<%=jids.get(i) %>"/>
			<input type="hidden" name="tid<%=i %>" value="<%=ids.get(i) %>"/>
		<%} %>
	</table>
	<input type="hidden" name="num" value="<%=num%>"/>
	<input type="submit" value="提交">
	</form>
</body>
</html>