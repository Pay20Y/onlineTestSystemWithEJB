<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%@page import="com.database.jdbc.*"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
String ID = request.getParameter("id");
String title = "ÐÅÏ¢²»´æÔÚ";
String cont = "ÐÅÏ¢²»´æÔÚ";
String date = "ÐÅÏ¢²»´æÔÚ";
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
	<a href="index.jsp">Ê×Ò³</a>
	<h2 align="center">¹ØÓÚ <%=title %> µÄÍ¨Öª</h2>
	<h4 align="center">·¢²¼Ê±¼ä:<%=date %></h4>
	<h5 align="center" ><%=cont %></h5>
	<h6 align="center">»¶Ó­´ó¼Ò±¨Ãû</h6>
</body>
</html>