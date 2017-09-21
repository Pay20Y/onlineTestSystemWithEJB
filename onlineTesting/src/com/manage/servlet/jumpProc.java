package com.manage.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class jumpProc
 */
@WebServlet("/jumpProc")
public class jumpProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jumpProc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("next");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(action.equals("login")){
			out.write("登录成功，点击此处返回首页 "+"<a href='index.jsp'>首页</a>");
			out.flush();
		}
		if(action.equals("signup")){
			out.write("注册成功，点击此处前往登录 "+"<a href='Login.xhtml'>登录</a>/>");
			out.write("点击此处返回首页 "+"<a href='index.jsp'>首页</a>");
			out.flush();
		}
		if(action.equals("update")){
			out.write("修改成功，点击此处返回首页 "+"<a href='index.jsp'>首页</a>");
			out.flush();
		}
		if(action.equals("apply")){
			out.write("申请成功，点击此处查看我的考试 "+"<a href='myZone.jsp'>我的考试</a>");	
			out.flush();
		}
		if(action.equals("post")){
			out.write("发表成功，点击此处返回首页 "+"<a href='index.jsp'>首页</a>");	
			out.flush();
		}
		if(action.equals("add")){
			out.write("添加成功，点击此处继续添加 "+"<a href='adQuestion.xhtml'>继续添加</a><br/>");	
			out.write("点击此处返回首页 "+"<a href='index.jsp'>首页</a>");	
			out.flush();
		}
		if(action.equals("failure")){
			out.write("操作成功，点击此处返回首页"+"<a href='index.jsp'>首页</a>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
