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
import com.ejb.stateless.updateTestRemote;

/**
 * Servlet implementation class collectProc
 */
@WebServlet("/collectProc")
public class collectProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public collectProc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int userid = Integer.valueOf(request.getParameter("userID"));
		int paperid = Integer.valueOf(request.getParameter("paperID"));
		
		Hashtable<String, String> jndiProperties = new Hashtable<String,String>();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		Context context;
		try{
			context = new InitialContext(jndiProperties);
			final String appName="";
			final String moduleName="PaperSessionEJB";
			final String distinctName="";
			Object object=context.lookup("ejb:"+appName+"/"+moduleName+"/"+distinctName+"/collectPaper!com.ejb.stateful.collectPaperRemote?stateful");
			collectPaperRemote collectRemote=(collectPaperRemote)object;
		
			collectRemote.insert(userid, paperid);;
		}catch(NamingException e){
			e.printStackTrace();
			System.out.println("²éÕÒEJB³ö´í");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("showPaper.jsp");
        rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
