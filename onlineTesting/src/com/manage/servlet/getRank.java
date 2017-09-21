package com.manage.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.assistant.*;
/**
 * Servlet implementation class getRank
 */
@WebServlet("/getRank")
public class getRank extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getRank() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int paperid = Integer.valueOf(request.getParameter("paperID"));
		gradeSort gs = new gradeSort();
		List<String> rank = new ArrayList();
		rank = gs.execute(paperid);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write("本试卷目前排名如下:<br/>");
		out.write("<table border='1';><tr><td>姓名</td><td>成绩</td></tr>");
		for(int i = 0;i<rank.size();i++){
			String[] b = rank.get(i).split("\t");
		out.write("<tr><td>"+b[0]+"</td><td>"+b[1]+"</td></tr>");
		out.flush();
		}
		out.write("</table>");
		out.flush();
		out.write("<a href='showPaper.jsp'>返回</a>");
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
