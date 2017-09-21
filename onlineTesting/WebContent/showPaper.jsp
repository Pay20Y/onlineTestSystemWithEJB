<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="javax.naming.*"%> 
<%@page import="com.ejb.stateless.*"%> 
<%@page import="com.xml.dom4j.*"%> 
<%@page import="com.bean.*"%> 
<%@page import="com.database.jdbc.*"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	boolean admin = false;
	int userid = -1;
	if(session.getAttribute("userid") != null){
		 userid = Integer.valueOf((String)session.getAttribute("userid"));
	}
	if(session.getAttribute("username") != null){
		if(session.getAttribute("username").equals("admin")){
			admin = true;
		}
	}
	Database DB = new Database();
	Connection conn = DB.getConn();
	
	
	
	//List<Boolean>status = new ArrayList();
	List<String> papers = new ArrayList();
	List<String> paths = new ArrayList();
	List<Integer> scores = new ArrayList();
	List<Integer> ids = new ArrayList();
	Hashtable<String, String> jndiProperties = new Hashtable<String,String>();
	jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
	Context context=new InitialContext(jndiProperties);
	final String appName="";
	final String moduleName="PaperSessionEJB";
	final String distinctName="";
	Object object=context.lookup("ejb:"+appName+"/"+moduleName+"/"+distinctName+"/getPaper!com.ejb.stateless.getPaperRemote");
	getPaperRemote paperRemote=(getPaperRemote)object;
	
	ids = paperRemote.searchId();
	papers = paperRemote.searchTitle();
	paths = paperRemote.searchPath();
	scores = paperRemote.searchtotalScore();
	
	
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>现存试卷</title>
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
					<td>试卷名</td>
					<td>总分</td>
					<%if((userid != -1) && (userid != 5)) {%>
					<td>收藏</td>
					<td>排名</td>
					<%} else if(userid == 5){%>
					<td>删除</td>
					<td>排名</td>
					<% }%>
				</tr>
				<%for(int i = 0;i<papers.size();i++){ %>
				<%	boolean status = false;
					int collectID = -1;
					String sql = "select CollectID from CollectPaper where UserID="+userid+" and PaperID="+ids.get(i);
					Statement stmt = DB.getStatement(conn);
					ResultSet rs = DB.getResultSetQ(stmt, sql);
					if(rs.next()){
						status = true;
						collectID = rs.getInt("CollectID");
					}
					rs.close();
					stmt.close();
				%>
				<tr>
					<td><%=i+1 %></td>
					<td><a href="showPaperDetail.jsp?id=<%=ids.get(i)%>"><%=papers.get(i) %></a></td>
					<td><%=scores.get(i)%></td>
					<%if((userid != -1) && (userid != 5)) {%>
					<%if(status == true){ %>
					<td><a href="rcollectProc?collectID=<%=collectID %>&from=2"><img src="already.JPG" border="0"/></a></td>
					<%}else { %>
					<td><a href="collectProc?userID=<%=userid%>&paperID=<%=ids.get(i)%>"><img src="not.JPG" border="0"/></a></td>
					<%}%>
					<%}else if(userid ==5){%>
					<td><a href="deletePaper?paperID=<%=ids.get(i)%>"><img src="delete.JPG" border="0"/></a></td>
					<%} %>
					<td><a href="getRank?paperID=<%=ids.get(i)%>">成绩排名</a></td>
				</tr>
				<%} %>
			</table>

			<%if(admin){ %>
			<a role="button" class="btn btn-success" href="addPaper.jsp">添加试卷</a>
			<% }%>
		</div>
	</div>


</body>
</html>