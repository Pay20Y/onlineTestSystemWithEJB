<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%@page import="com.database.jdbc.*"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
String ID = request.getParameter("id");
String title = "信息不存在";
String cont = "信息不存在";
String date = "信息不存在";
Database DB = new Database();
Connection conn = DB.getConn();
String sql = "select InfoTitle,InfoCont,InfoDate from testinfo where InfoID ="+ID;
Statement stmt = conn.createStatement();
ResultSet rs = DB.getResultSetQ(stmt, sql);
if(rs.next()){
	title = rs.getString("InfoTitle");
	cont = rs.getString("InfoCont");
	date = rs.getString("InfoDate");
}
rs.close();
conn.close();

%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%=title %></title>
</head>
<body>
	<a href="index.jsp">首页</a>
	<h2 align="center">关于 <%=title %> 的通知</h2>
	<h4 align="center">发布时间:<%=date %></h4>
	<h5 align="center" ><%=cont %></h5>
	<h6 align="center">欢迎大家报名</h6>
</body>
</html>