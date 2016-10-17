package com.SJlibrary.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectManage {
	private static Connection con;
	private ConnectManage(){}
	public static Connection getConnection() throws SQLException{
		if(con!=null && !con.isClosed())//不为空且没关闭
			return con;
		String className="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/lab2";
		String username="root";
		String password="zzzsyzxl1204";
		//生成一个连接
		try {
			Class.forName(className); //加载MYSQL JDBC驱动程序 
			con = DriverManager.getConnection(url,username,password);
		}catch(ClassNotFoundException e){e.printStackTrace();}
		return con;
	}
	
	public static void closeConnection(){
		try{con.close();}catch(SQLException e){e.printStackTrace();}
		con=null;
	}
}
