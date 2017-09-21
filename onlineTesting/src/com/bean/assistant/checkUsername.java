package com.bean.assistant;
import com.database.jdbc.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class checkUsername {
	public String doCheck(String name){
		try{
		Database DB = new Database();
		Connection conn = DB.getConn();
		String sql = "select UserName from users";
		List<String> exists = new ArrayList<String>();
		Statement stmt = DB.getStatement(conn);
		ResultSet rs = DB.getResultSetQ(stmt, sql);
		while(rs.next()){
			exists.add(rs.getString("UserName"));
		}
		for(String exist:exists){
			if(exist.equals(name)){
				return "no";
			}
		}
		
		}catch(SQLException e){
			e.printStackTrace();
		}

		return "ok";
	}
}
