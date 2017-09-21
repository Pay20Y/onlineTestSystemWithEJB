package com.manage.servlet;

import java.io.IOException;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ejb.stateful.collectPaperRemote;

/**
 * Servlet implementation class rcollectProc
 */
@WebServlet("/rcollectProc")
public class rcollectProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public rcollectProc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int collectid = Integer.valueOf(request.getParameter("collectID"));
		String from = request.getParameter("from");
		if(collectid != -1){
			Hashtable<String, String> jndiProperties = new Hashtable<String,String>();
			jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			Context context;
			try{
				context = new InitialContext(jndiProperties);
				final String appName="";
				final String moduleName="PaperSessionEJB";
				final String distinctName="";
				Object object=context.lookup("ejb:"+appName+"/"+moduleName+"/"+distinctName+"/collectPaper!com.ejb.stateful.collectPaperRemote?stateful");
				collectPaperRemote rcollectRemote=(collectPaperRemote)object;
			
				rcollectRemote.remove(collectid);
			}catch(NamingException e){
				e.printStackTrace();
				System.out.println("²éÕÒEJB³ö´í");
			}
		}
		if(from.equals("1")){
			RequestDispatcher rd = request.getRequestDispatcher("myCollect.jsp");
	        rd.forward(request,response);
		}else if(from.equals("2")){
		RequestDispatcher rd = request.getRequestDispatcher("showPaper.jsp");
        rd.forward(request,response);
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
