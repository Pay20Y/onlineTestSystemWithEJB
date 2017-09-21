<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%@page import="com.xml.dom4j.*" %>
<%@page import="com.database.jdbc.*" %>
<%@page import="com.bean.*" %>
<%@page import="java.io.*" %>
<%@page import="java.util.*" %>
<%@page import="java.sql.*" %>

<%
	int paperid = Integer.valueOf((String)request.getParameter("id"));
	String papername = "noData";
	String paperpath = "noData";
	Database DB = new Database();
	Connection conn = DB.getConn();
	String sql = "select PaperName,PaperPath from paper where PaperID="+paperid; 
	Statement stmt = DB.getStatement(conn);
	ResultSet rs = DB.getResultSetQ(stmt, sql);
	if(rs.next()){
		papername = rs.getString("PaperName");
		paperpath = rs.getString("PaperPath");
	}
	
	String path = "F:\\javaeeData\\";
	File file = new File(path+paperpath);
	Paper paper = new Paper();
	parseXML px = new parseXML();
	
	paper = px.parse(file);
	
	List<Question1> list1 = paper.getQuestion1s();
	List<Question2> list2 = paper.getQuestion2s();
	
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title><%=papername%></title>
	<link rel="stylesheet" href="./css/bootstrap.min.css"/>
	<link rel="stylesheet" href="./css/main.css"/>
</head>
<body>	
	<a href="showPaper.jsp">返回iu</a>
	<h2 align="center"><%=papername %></h3>
	<h4>一、选择题</h4>
	<%for(int i=0;i<list2.size();i++){%>
		<h4><%=i+1%>.<%=list2.get(i).getQuestion() %></h4>
		<h5>A.<%=list2.get(i).getItem1() %></h4>
		<h5>B.<%=list2.get(i).getItem2() %></h4>
		<h5>C.<%=list2.get(i).getItem3() %></h4>
		<h5>D.<%=list2.get(i).getItem4() %></h4>
		<h5>答案:<%=list2.get(i).getAnswer() %></h5>
	<%} %>
	<h4>二、主观题</h4>
	<%for(int i=0;i<list1.size();i++){%>
		<h4><%=i+1%>.<%=list1.get(i).getQuestion() %></h4>
		<h5>答案:<%=list1.get(i).getAnswer() %></h5>
	<%} %>
</body>
</html>