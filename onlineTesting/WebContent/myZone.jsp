<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%@page import="java.util.*"%>
<%@page import="javax.naming.*"%> 
<%@page import="java.sql.*"%> 
<%@page import="com.ejb.stateless.*"%> 
<%@page import="com.database.jdbc.*"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	int userid = -1;
	String userid_temp = (String)session.getAttribute("userid");
	String username= (String)session.getAttribute("username");
	if(userid_temp != null){
		userid = Integer.valueOf(userid_temp);
	}
	List<Integer> paperIDs = new ArrayList();
	List<Integer> scores = new ArrayList();
	List<String> papers = new ArrayList();
	List<Integer> tests = new ArrayList();
	Database DB = new Database();
	Connection conn = DB.getConn();
	
	Hashtable<String, String> jndiProperties = new Hashtable<String,String>();
	jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
	String title = null;
		Context context;
		context = new InitialContext(jndiProperties);
		final String appName="";
		final String moduleName="TestSessionEJB";
		final String distinctName="";
		Object object=context.lookup("ejb:"+appName+"/"+moduleName+"/"+distinctName+"/getTest!com.ejb.stateless.getTestRemote");
		getTestRemote gettestRemote=(getTestRemote)object;
		
		if(userid!=-1){
		paperIDs = gettestRemote.searchPaperID(userid);
		scores = gettestRemote.searchScore(userid);
		for(int i=0;i<paperIDs.size();i++){
			String sql = "select PaperName from paper where PaperID="+paperIDs.get(i);
			String sql1 = "select TestID from test where UserID="+userid+" and PaperID="+paperIDs.get(i);
			Statement stmt = DB.getStatement(conn);
			Statement stmt1 = DB.getStatement(conn);
			ResultSet rs = DB.getResultSetQ(stmt, sql);
			ResultSet rs1 = DB.getResultSetQ(stmt1, sql1);
			if(rs.next()){
				papers.add(rs.getString("PaperName"));
			}
			if(rs1.next()){
				tests.add(rs1.getInt("TestID"));
			}
			rs.close();
			rs1.close();
			stmt.close();
			stmt1.close();
		}
		}
	conn.close();
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>我的考试</title>
<link rel="stylesheet" href="./css/bootstrap.min.css"/>
<link rel="stylesheet" href="./css/main.css"/>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<a href="index.jsp">在线考试系统</a>
		<span class="navbar-text navbar-right"><%=username %>,你好!</span>
	</nav>
	<div class="container">
		<div class="row">
			<table class="table center-block">
				<tr>
					<td>编号</td>
					<td>考试</td>
					<td>是否完成考试</td>
					<td>分数</td>
				</tr>
				<tr>
					<%for(int i = 0;i<papers.size();i++){ %>
					<td><%=i+1 %></td>
					<td><%=papers.get(i) %></td>
					<%if(scores.get(i)==-1){ %>
					<td>否</td>
					<td><a href="doTest.jsp?testID=<%=tests.get(i)%>&paperID=<%=paperIDs.get(i)%>">前往考试</a></td>
					<%} else{%>
					<td>是</td>
					<td><%=scores.get(i) %></td>
					<%} %>
					<%} %>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>