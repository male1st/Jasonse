package com.jason.se.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleJdbc {
	private static String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	private static String user="scott";
	private static String password="tiger";
	private static Connection conn = null;
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private static PreparedStatement ps;
	private static ResultSet rs;
	
	public static void main(String[] args) throws Exception {
		count();
		//delete();
		//statement();
		//preparedStatement();
		conn.close();
		
	}

 
	public static void count() throws Exception{
		ps= conn.prepareStatement("select count(1) from test");
		rs=ps.executeQuery();
		rs.next();
		System.out.println(rs.getInt(1));
	}
	
	
	public static void delete() throws Exception{
		ps=conn.prepareStatement("delete from test");
		ps.executeUpdate();
		ps.close();
		conn.commit();
	}
	
	//640
	public static void preparedStatement() throws Exception{
		long start=System.currentTimeMillis();
		ps=conn.prepareStatement("insert into test values(?,?)");
		conn.setAutoCommit(false);
		for (int i = 0; i < 1000000; i++) {
			ps.setInt(1, i);
			ps.setInt(2, i);
			ps.addBatch();
			/*if(i%1000==0){
				ps.executeBatch();
				conn.commit();
				ps.clearBatch();
			}*/
		}
		ps.executeBatch();
		ps.clearBatch();
		conn.commit();
		System.out.println((System.currentTimeMillis()-start)/1000);
	}
	
	//158599
	public  static void statement() throws Exception{
			long start=System.currentTimeMillis();
			Statement statement = conn.createStatement();
			for (int i = 0; i < 100000; i++) {
				statement.executeUpdate("insert into test values("+i+","+i+")");
			}
			conn.commit();
			System.out.println((System.currentTimeMillis()-start));
	}
	
}
