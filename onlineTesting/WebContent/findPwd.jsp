<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	boolean right = false;
	boolean right2 = false;
	String action = (String)session.getAttribute("action");
	String answer = (String)session.getAttribute("answer");
	String question = (String)session.getAttribute("security");
	String password = (String)session.getAttribute("password");
	String username = (String)session.getAttribute("username");
	if(action != null){
		if(action.equals("true")){
		right = true;
		}
	}
	if(answer != null){
		if(answer.equals("true")){
		right2 = true;
		}
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>�һ�����</title>
</head>
<body>
	<a href="index.jsp">��ҳ</a>
	<form name="forml" method="post" action="./findPwd">
		<table align="center" border="1">
			<tr>
				<td>�û���</td>
				<td><input type="text" name="userName"></td>
			</tr>
			<tr>
				<td>Ԥ���ֻ���</td>
				<td><input type="text" name="userPhone"></td>
			</tr>
		</table>
		<p align="center" ><input type="submit" name="Submit" value="�ύ"></p>
	</form>
	<%if(right){ %>
	<form name="form2" method="post" action="./getPwd">
		<table align="center" border="1">
			<tr>
				<td>��ȫ����</td>
				<td><%=question %></td>
			</tr>
			<tr>
				<td>��Ĵ�</td>
				<td><input type="text" name="userAnswer"></td>
			</tr>
		</table>
		<input type="hidden" name="userName" value="<%=username %>"/> 
		<p align="center" ><input type="submit" name="Submit" value="�ύ"></p>
	</form>
	<%} %>
	<%if(right2){ %>
		<h3>���������: <%=password %>  <a href="Login.xhtml">ǰ����¼</a></h3>
	<%} %>
</body>
</html>