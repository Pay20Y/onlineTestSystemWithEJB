package com.manage.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.jdbc.Database;
import com.ejb.stateless.signupTestRemote;

import java.sql.*;
import java.util.Hashtable;
import java.util.*;;

/**
 * Servlet implementation class applyProc
 */
@WebServlet("/applyProc")
public class applyProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public applyProc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("userName");
		String Password = request.getParameter("userPwd");
		//String index = request.getParameter("testExist");
		int paper = Integer.valueOf(request.getParameter("testExist"));
//System.out.println(name);
//System.out.println(Password);
//System.out.println("试卷:"+paper);
		String result = "success";
		boolean user = false;
		int userId = -1;
		int paperId = -1;
		List<Integer> paperIDs = new ArrayList(); 
		Database DB = new Database();
		Connection conn = DB.getConn();
		String sql = "select UserPwd,UserID from users where UserName= '"+name+"'";
		Statement stmt = DB.getStatement(conn);
		ResultSet rs = DB.getResultSetQ(stmt, sql);
		try{
		if(rs.next()){
			if(rs == null){
				result = "username doesn't exist!!";
			}else if(!Password.equals(rs.getString("userPWD"))){
				result = "password error!!";
			}
			else{
				result = " success";
				userId = rs.getInt("UserID");
				user = true;
			}
		}else{
			result = "username doesn't exist!!";
		}
		rs.close();
		stmt.close();
		}catch(SQLException e){
			result = "failed";
			System.out.println("SQL error");
		}
		
		if(user){
		try{
			String sql2 = "select PaperID from paper";
			Statement stmt2 = DB.getStatement(conn);
			ResultSet rs2 = DB.getResultSetQ(stmt2, sql2);
			while(rs2.next()){
				paperIDs.add(rs2.getInt("PaperID"));
			}
			paperId = paperIDs.get(paper);
		}catch(SQLException e){
			e.printStackTrace();
			}
		String test = String.valueOf(userId)+"\t"+String.valueOf(paperId);
//System.out.println("最后传给EJB的值是--"+test);
		
		Hashtable<String, String> jndiProperties = new Hashtable<String,String>();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		String title = null;
			Context context;
			try {
				context = new InitialContext(jndiProperties);
				final String appName="";
				final String moduleName="TestSessionEJB";
				final String distinctName="";
				Object object=context.lookup("ejb:"+appName+"/"+moduleName+"/"+distinctName+"/signupTest!com.ejb.stateless.signupTestRemote");
				signupTestRemote testRemote=(signupTestRemote)object;
				
				testRemote.signup(test);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("查找EJB出错");
			}
		}
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(result);
		out.write("点击<a href='myZone.jsp'>此处</a>查看我的考试");
		out.write("点击<a href='index.jsp'>此处</a>回到首页");
		out.flush();
		out.close();
		
	}

}
