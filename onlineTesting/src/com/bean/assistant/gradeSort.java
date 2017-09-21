package com.bean.assistant;
import com.database.jdbc.*;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import com.bean.*;
public class gradeSort {
	public List<String> execute(int paperid){
		List<String> results = new ArrayList();
		try{
		Database DB = new Database();
		Connection conn = DB.getConn();
		Statement stmt = DB.getStatement(conn);
		String sql = "select UserName,Score from test natural join users where PaperID="+paperid+" and Score>=0 order by Score desc";
		ResultSet rs = DB.getResultSetQ(stmt, sql);
		while(rs.next()){
			results.add(rs.getString("UserName")+"\t"+rs.getInt("Score"));
		}
		
		rs.close();
		stmt.close();
		conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	
		return results;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> a = new gradeSort().execute(1);
		for(int i = 0;i<a.size();i++){
			String[] b = a.get(i).split("\t");
			System.out.println("ÐÕÃû£º"+b[0]+"³É¼¨:"+b[1]);
		}
	}

}
