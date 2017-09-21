package com.system.managedBean;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.database.jdbc.Database;

@ManagedBean(name = "testBean")
@SessionScoped
public class TestBean {
	private String userName;
	private String userPwd;
	private int index;
	private List<String> papers = new ArrayList<String>();
	
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
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public List<String> getPapers() {
		List<String> exist = new ArrayList<String>();
		try{
		Database DB = new Database();
		Connection conn = DB.getConn();
		String sql = "select PaperName from paper";
		Statement stmt = DB.getStatement(conn);
		ResultSet rs = DB.getResultSetQ(stmt, sql);
		while(rs.next()){
			exist.add(rs.getString("PaperName"));
		}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("访问数据库查找卷子出错");
		}
		return exist;
	}
	public void setPapers(List<String> papers) {
		this.papers = papers;
	}
	
	public String apply(){
		System.out.println("apply info:");
		System.out.println(getUserName());
		System.out.println(getPapers().get(getIndex()));
		return "success";
	}
	
	
}
