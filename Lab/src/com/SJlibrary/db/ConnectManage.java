package com.SJlibrary.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectManage {
	private static Connection con;
	private ConnectManage(){}
	public static Connection getConnection() throws SQLException{
		if(con!=null && !con.isClosed())//��Ϊ����û�ر�
			return con;
		String className="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/lab2";
		String username="root";
		String password="zzzsyzxl1204";
		//����һ������
		try {
			Class.forName(className); //����MYSQL JDBC�������� 
			con = DriverManager.getConnection(url,username,password);
		}catch(ClassNotFoundException e){e.printStackTrace();}
		return con;
	}
	
	public static void closeConnection(){
		try{con.close();}catch(SQLException e){e.printStackTrace();}
		con=null;
	}
}
