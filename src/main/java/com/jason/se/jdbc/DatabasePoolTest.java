package com.jason.se.jdbc;

import java.sql.Connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class DatabasePoolTest {

	
	public static Connection getC3P0Bean() throws Exception{
		 ComboPooledDataSource dataSource=new ComboPooledDataSource();
		 dataSource.setDriverClass(oracle.jdbc.OracleDriver.class.getName());
		 dataSource.setJdbcUrl("jdbc:oracle:thin:@127.0.0.1:1521:orcl");
		 dataSource.setUser("scott");
		 dataSource.setPassword("tiger");
		return dataSource.getConnection();
	}
	
	
	public static void main(String[] args) throws Exception {
		System.out.println(getC3P0Bean().isClosed());
		/*JDBCBean jdbc = getJDBCBean();
		String sql = "SELECT * FROM student_basic";
		DataConnectMgr mgr =  DataConnectMgr.getInstance(jdbc);
		//从数据库连接池中获取连接
		Connection con = mgr.getConnection(jdbc.getName());
        try {
        	System.out.println("正在使用刚刚获得的数据库连接");
            java.sql.Statement sm = con.createStatement();
            sm.executeQuery(sql);
            //do something
            sm.close();
        } catch (java.sql.SQLException e) {
        	System.err.println("连接数据库出错！");
        } finally {
        	//释放连接到数据库连接池
        	mgr.freeConnection(jdbc.getName(), con);
        }
        mgr.release();*/
	}
}
