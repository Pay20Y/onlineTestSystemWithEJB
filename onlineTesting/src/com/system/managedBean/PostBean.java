package com.system.managedBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.ejb.stateless.addQuestion1Remote;
import com.ejb.stateless.postInfoRemote;
import com.bean.assistant.*;

@ManagedBean(name = "postBean")
@SessionScoped
public class PostBean {
	private String title;
	private String cont;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	
	public String post(){
		Date date = new Date();
		String sdate = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(date);
		System.out.println("managebean is OK?--"+getTitle()+"--"+getCont()+"--"+sdate);
		Hashtable<String, String> jndiProperties = new Hashtable<String,String>();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		try{
			Context context=new InitialContext(jndiProperties);
			final String appName="";
			final String moduleName="InfoSessionEJB";
			final String distinctName="";
			Object object=context.lookup("ejb:"+appName+"/"+moduleName+"/"+distinctName+"/postInfo!com.ejb.stateless.postInfoRemote");
			postInfoRemote postRemote=(postInfoRemote)object;
			postRemote.post(getTitle(), getCont(),sdate);
			
			JMSSender jms = new JMSSender();
			jms.sendTextMessage("关于"+getTitle()+"已发布，请注意查看");
		}catch(NamingException e){
			e.printStackTrace();
			System.out.println("寻找EJB出错");
			return "failure";
			}
		return "success";
		}
}
