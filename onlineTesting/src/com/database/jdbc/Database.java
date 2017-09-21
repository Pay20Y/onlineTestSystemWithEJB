package com.database.jdbc;

import java.sql.*;

public class Database {
	public static Connection getConn(){
		Connection conn = null;
		try{
		Class.forName("com.mysql.jdbc.Driver");
		 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineTest?user=root&password=admin");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		//System.out.println("connect");
		return conn;
	}

	public static Statement getStatement(Connection conn){
		Statement stmt = null;
		try{
			if(conn != null){
				stmt = conn.createStatement();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return stmt;
	}
	public static PreparedStatement getpStatement(Connection conn,String sql){
		PreparedStatement pstmt = null;
		try{
			if(conn != null){
				pstmt = conn.prepareStatement(sql);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return pstmt;
	}

	public static ResultSet getResultSetQ(Statement stmt,String sql){
		ResultSet rs = null;
		try{
			if(stmt != null){
				rs= stmt.executeQuery(sql);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}

	public static void UpdateDB(Statement stmt,String sql){
		ResultSet rs = null;
		try{
			if(stmt != null){
				 stmt.executeUpdate(sql);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public static void deleteDB(Statement stmt,String str){
		try {
			stmt.executeUpdate("delete from employee where EMPNO="+"'"+str+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(Connection conn,Statement stmt,ResultSet rs){
		try{
		conn.close();
		stmt.close();
		rs.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public static void close(Connection conn,Statement stmt1,Statement stmt2,ResultSet rs1,ResultSet rs2){
		try{
		conn.close();
		stmt1.close();
		stmt2.close();
		rs1.close();
		rs2.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}	
	public static void close(Connection conn,PreparedStatement pstmt){
		try{
		conn.close();
		pstmt.close();
		
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public static void close(Connection conn,Statement stmt){
		try{
		conn.close();
		stmt.close();
		
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public static void close(Connection conn){
		try{
		conn.close();
		
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
