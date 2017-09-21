package com.system.managedBean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.database.jdbc.Database;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable{
	private String userName;
	private String userPwd;
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
	public LoginBean() {
		// TODO Auto-generated constructor stub
	}
	public String check(){
		String role = "normal";
		int temp = 1;
		try{
		Database DB = new Database();
		Connection conn = DB.getConn();
		String sql = "select UserPwd,UserID,Security from users where UserName="+"'"+getUserName()+"'";
		Statement stmt = DB.getStatement(conn);
		ResultSet rs = DB.getResultSetQ(stmt, sql);
		if(rs.next()){
			if(rs.getString("Security").equals("teacher")){
				role = "teacher";
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username",getUserName());
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userid",String.valueOf(rs.getInt("UserID")));
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("role", role);
			}else{
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username",getUserName());
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userid",String.valueOf(rs.getInt("UserID")));
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("role", role);
			}
			return "success";
		}
		else{
			return "failure";
		}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("LoginBean Êý¾Ý¿â³ö´í");
		}
		return "failure";
	}

}
