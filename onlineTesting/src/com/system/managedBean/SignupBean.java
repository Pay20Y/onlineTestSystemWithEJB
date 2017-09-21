package com.system.managedBean;

import java.sql.*;
import java.util.Hashtable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.database.jdbc.Database;
import com.ejb.stateless.SignupAddRemote;
import com.bean.assistant.*;
@ManagedBean(name = "signupBean")
@SessionScoped
public class SignupBean {
	private int userId;
	private String userName;
	private String userPwd;
	private String userPhone;
	private String security;
	private String answer;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
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
	/*
	public void write2DB(){
		try{
		Database DB = new Database();
		Connection conn = DB.getConn();
		String sql = "insert into Users values (null,?,?,?,?,?)";
		PreparedStatement pstmt = DB.getpStatement(conn, sql);
		pstmt.setString(1, getUserName());
		pstmt.setString(2, getUserPwd());
		pstmt.setString(3, getUserPhone());
		pstmt.setString(4, getSecurity());
		pstmt.setString(5, getAnswer());
		pstmt.execute();
		conn.close();
		pstmt.close();
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("插入注册信息出错");
		}
	}*/
	public String write2DB(){
		System.out.println(getUserName());
		String result = "success";
		boolean go = true;
		checkUsername cu = new checkUsername();
		String get = cu.doCheck(getUserName());
		if(get.equals("no")){
			result = "failure";
			go = false;
		}
		if(go){
		String userinfo = getUserName()+"\t"+getUserPwd()+"\t"+getUserPhone()+"\t"+getSecurity()+"\t"+getAnswer();
		try{
		Hashtable<String, String> jndiProperties = new Hashtable<String,String>();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			Context context=new InitialContext(jndiProperties);
			final String appName="";
			final String moduleName="SignupSessionEJB";
			final String distinctName="";
			Object object=context.lookup("ejb:"+appName+"/"+moduleName+"/"+distinctName+"/SignupAdd!com.ejb.stateless.SignupAddRemote");
			SignupAddRemote addUserRemote=(SignupAddRemote)object;
			System.out.println("接下来调用insert方法");
			addUserRemote.insert(userinfo);
		}catch(NamingException e){
			e.printStackTrace();
			System.out.println("生成EJB出错");
		}
		}
		return result;
	}
	public String toSuccess(){
		return "success";
	}
	
	
}
