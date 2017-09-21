<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="com.database.jdbc.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	List<String> testList = new ArrayList<String>();
	Database DB= new Database();
	Connection conn = DB.getConn();
	String sql = "select PaperName from paper";
	Statement stmt = DB.getStatement(conn);
	ResultSet rs = DB.getResultSetQ(stmt, sql);
	while(rs.next()){
		testList.add(rs.getString("PaperName"));
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>考试报名</title>
<link rel="stylesheet" href="./css/bootstrap.min.css"/>
<link rel="stylesheet" href="./css/main.css"/>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<a href="index.jsp">在线考试系统</a>
	</nav>

	<div class="container">
		<div class="row text-center">请填写下列信息完成考试报名</div>
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4 ">
				<form action="applyProc">
					<div class="form-group">
						<p><label><input type="text" name="userName" class="form-control">用户名</label></p>
						<p><label>
							<input type="text" name="userPwd" class="form-control">密码</label></p>
						<p><label><select name="testExist" class="form-control">
							<%for(int i=0;i<testList.size();i++){ %>
							<option value="<%=i%>"><%=testList.get(i) %></option>
							<%} %>
						</select></label></p>
						<p><input class="btn btn-success" type="submit" name="Submit" value="报名"></p>
					</div>
				</form>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
</body>
</html>