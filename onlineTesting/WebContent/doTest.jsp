<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%@page import="com.xml.dom4j.*" %>
<%@page import="com.database.jdbc.*" %>
<%@page import="com.bean.*" %>
<%@page import="java.io.*" %>
<%@page import="java.util.*" %>
<%@page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	int testid = Integer.valueOf(request.getParameter("testID"));
	int paperid = Integer.valueOf(request.getParameter("paperID"));
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
	
	int i = 0;
	int j = 0;
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>开始答题</title>
</head>
<body>
	<form name="forml" method="post" action="./judgePaper">
		<table border="1">
		<tr><h4>一、选择题</h4></tr>
		<%for(i = 0;i<list2.size();i++){ %>
			<tr>
				<%=i+1%>.<%=list2.get(i).getQuestion() %><br/>
					<p/><label><input name="radio<%=i%>" type="radio" value="A"/>A.<%=list2.get(i).getItem1() %></label>
					<p/><label><input name="radio<%=i%>" type="radio" value="B"/>B.<%=list2.get(i).getItem2() %></label>
					<p/><label><input name="radio<%=i%>" type="radio" value="C"/>C.<%=list2.get(i).getItem3() %></label>
					<p/><label><input name="radio<%=i%>" type="radio" value="D"/>D.<%=list2.get(i).getItem4() %></label>				
			</tr>
		<%} %>
		<tr><h4>二、问答题</h4></tr>
		<%for(j = 0;j<list1.size();j++){ %>
			<tr>
				<%=j+1 %>.<%=list1.get(j).getQuestion() %><br/>
				<input name="answer<%=j%>" type="text"/>
			</tr>
		<%} %>
		</table>
		<input type="hidden" name="num1" value="<%=i %>"/>
		<input type="hidden" name="num2" value="<%=j %>"/>
		<input type="hidden" name="testID" value="<%=testid %>"/>
		<input type="hidden" name="paperID" value="<%=paperid %>"/>
		<input type="submit" name="Submit" value="交卷">
	</form>
</body>
</html>