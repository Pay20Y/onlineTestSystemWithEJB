package com.manage.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.database.jdbc.Database;

/**
 * Servlet implementation class findPwd
 */
@WebServlet("/findPwd")
public class findPwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findPwd() {
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
		String result = "user is not existed!";
		String username = request.getParameter("userName");
		String userPhone = request.getParameter("userPhone");
		
		Database DB = new Database();
		Connection conn = DB.getConn();
		String sql1 = "select UserName,UserPhone,Security,Answer from users where UserName='"+username+"'";
		Statement stmt1 = DB.getStatement(conn);
		ResultSet rs1 = DB.getResultSetQ(stmt1, sql1);
		
		try{
			if(rs1.next()){
				if(!rs1.getString("UserPhone").equals(userPhone)){
					result = "UserPhone error";
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.write(result);;
					out.flush();
					out.close();
				}else {
					HttpSession session = request.getSession(); 
					session.setAttribute("action", "true");
					session.setAttribute("security", rs1.getString("Security"));
					session.setAttribute("username",rs1.getString("UserName") );
					RequestDispatcher rd = request.getRequestDispatcher("findPwd.jsp");
			        rd.forward(request,response);
				}
			}else{
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.write(result);;
				out.flush();
				out.close();
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("sql´íÎó");
		}
	}

}
