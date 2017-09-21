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
			out.write("��¼�ɹ�������˴�������ҳ "+"<a href='index.jsp'>��ҳ</a>");
			out.flush();
		}
		if(action.equals("signup")){
			out.write("ע��ɹ�������˴�ǰ����¼ "+"<a href='Login.xhtml'>��¼</a>/>");
			out.write("����˴�������ҳ "+"<a href='index.jsp'>��ҳ</a>");
			out.flush();
		}
		if(action.equals("update")){
			out.write("�޸ĳɹ�������˴�������ҳ "+"<a href='index.jsp'>��ҳ</a>");
			out.flush();
		}
		if(action.equals("apply")){
			out.write("����ɹ�������˴��鿴�ҵĿ��� "+"<a href='myZone.jsp'>�ҵĿ���</a>");	
			out.flush();
		}
		if(action.equals("post")){
			out.write("����ɹ�������˴�������ҳ "+"<a href='index.jsp'>��ҳ</a>");	
			out.flush();
		}
		if(action.equals("add")){
			out.write("��ӳɹ�������˴�������� "+"<a href='adQuestion.xhtml'>�������</a><br/>");	
			out.write("����˴�������ҳ "+"<a href='index.jsp'>��ҳ</a>");	
			out.flush();
		}
		if(action.equals("failure")){
			out.write("�����ɹ�������˴�������ҳ"+"<a href='index.jsp'>��ҳ</a>");
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
