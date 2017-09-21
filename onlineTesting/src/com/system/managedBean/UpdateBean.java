package com.system.managedBean;

import java.util.Hashtable;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.ejb.stateless.updateUserRemote;

@ManagedBean(name="updateBean")
public class UpdateBean {
	private String userPwd;
	private String userPhone;
	private String security;
	private String answer;
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getSecurity() {
		return security;
	}
	public void setSecurity(String security) {
		this.security = security;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public String executeUpdate(){
		int userid = -1;
		String result = "failure";
		String userID = (String)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userid");
		if(userID != null){
			userid = Integer.valueOf(userID);
		}
		if(userid != -1){
		try{
		Hashtable<String, String> jndiProperties = new Hashtable<String,String>();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			Context context=new InitialContext(jndiProperties);
			final String appName="";
			final String moduleName="SignupSessionEJB";
			final String distinctName="";
			Object object=context.lookup("ejb:"+appName+"/"+moduleName+"/"+distinctName+"/updateUser!com.ejb.stateless.updateUserRemote");
			updateUserRemote updateRemote=(updateUserRemote)object;
			
			if(!getUserPwd().equals("")){
				updateRemote.updatePwd(userid, getUserPwd());
				result = "success";
			}
			if(!getUserPhone().equals("")){
				updateRemote.updatePhone(userid, getUserPhone());
				result = "success";
			}
			if(!getSecurity().equals("")){
				updateRemote.updateSecurity(userid, getSecurity());
				result = "success";
			}
			if(!getAnswer().equals("")){
				updateRemote.updateAnswer(userid, getAnswer());
				result = "success";
			}
		}catch(NamingException e){
			e.printStackTrace();
			result = "failure";
			System.out.println("Ñ°ÕÒEJB³ö´í");
		}
		}
		return result;
	}
}
