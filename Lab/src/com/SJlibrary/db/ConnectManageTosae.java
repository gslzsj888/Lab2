package com.SJlibrary.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.sina.sae.util.SaeUserInfo;//���������ṩ��jar����������һϵ�з���
public class ConnectManageTosae {
	private static Connection con;
	private ConnectManageTosae(){}
	public static Connection getConnectionW() throws SQLException{
		con=null;
		String driver = "com.mysql.jdbc.Driver";
		String username = System.getenv("ACCESSKEY");
		String password = System.getenv("SECRETKEY");
		//System.getenv("MYSQL_HOST_S"); Ϊ�ӿ⣬ֻ��
		String dbUrl = String.format("jdbc:mysql://%s:%s/%s", System.getenv("MYSQL_HOST"), System.getenv("MYSQL_PORT"), System.getenv("MYSQL_DB"));
		try {
		    Class.forName(driver).newInstance();
		    con = DriverManager.getConnection(dbUrl, username, password);

		} catch (Exception e) {e.printStackTrace();}
		return con;
	}
	
	
	
	public static Connection getConnectionR() throws SQLException{
		if(con!=null && !con.isClosed())//��Ϊ����û�ر�
			return con;
		String className="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://r.rdc.sae.sina.com.cn:3307/app_gslzsj888";
		String username=SaeUserInfo.getAccessKey();    //��ȡAccessKey,����Ҫ�Լ���д
		String password=SaeUserInfo.getSecretKey(); //��ȡSecretKey
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
