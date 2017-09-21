package com.manage.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.database.jdbc.*;
import java.sql.*;
/**
 * Servlet implementation class getPwd
 */
@WebServlet("/getPwd")
public class getPwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getPwd() {
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
		String userName = request.getParameter("userName");
		String answer = request.getParameter("userAnswer");
		
		Database DB = new Database();
		Connection conn = DB.getConn();
		String sql = "select Answer,UserPwd from users where UserName='"+userName+"'";
		Statement stmt = DB.getStatement(conn);
		ResultSet rs = DB.getResultSetQ(stmt, sql);
		try{
		if(rs.next()){
			if(answer.equals(rs.getString("Answer"))){
				HttpSession session = request.getSession(); 
				session.setAttribute("answer", "true");
				session.setAttribute("password",rs.getString("UserPwd"));
				RequestDispatcher rd = request.getRequestDispatcher("findPwd.jsp");
		        rd.forward(request,response);
			}else{
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.write("»Ø´ð´íÎó");
				out.flush();
				out.close();
			}
		}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
