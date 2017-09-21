<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="com.database.jdbc.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	int userid = Integer.valueOf((String)session.getAttribute("userid"));
	List<String> papers = new ArrayList();
	List<Integer> ids = new ArrayList();
	List<Integer> id2s = new ArrayList();
	Database DB = new Database();
	Connection conn = DB.getConn();
	String sql = "select PaperID,PaperName,CollectID from CollectPaper natural join paper where UserID="+userid;
	Statement stmt = DB.getStatement(conn);
	ResultSet rs = DB.getResultSetQ(stmt, sql);
	while(rs.next()){
		papers.add(rs.getString("PaperName"));
		ids.add(rs.getInt("PaperID"));
		id2s.add(rs.getInt("CollectID"));
		
	}
	rs.close();
	stmt.close();
	conn.close();

%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>我的收藏</title>
<link rel="stylesheet" href="./css/bootstrap.min.css"/>
<link rel="stylesheet" href="./css/main.css"/>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<a href="index.jsp">在线考试系统</a>
	</nav>

	<div class="container">
		<div class="row">
			<table class="table center-block">
				<tr>
					<td>编号</td>
					<td>试卷</td>
					<td>收藏</td>
				</tr>
				<%for(int i = 0;i<papers.size();i++) {%>
				<tr>
					<td><%=i+1 %></td>
					<td><%=papers.get(i) %></td>
					<td><a href="rcollectProc?collectID=<%=id2s.get(i) %>&from=1"><img src="already.JPG" border="0"/></a></td>
				</tr>
				<%} %>
			</table>
		</div>
	</div>
</body>
</html>