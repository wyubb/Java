package chapter2.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTest {
	public static void main(String[] args) {
		//1.指定JDBC驱动类名
		String driverName = "com.mysql.jdbc.Driver";
		//2.指定本机MySQL的JDBC URL
		String connectionString = "jdbc:mysql://localhost:3306/diary";
		String user ="root";
		String password = "123456";
		
		try {
			//3.加载JDBC驱动类
			Class.forName(driverName);
			//4.得到一个Connection连接
			Connection conn =DriverManager.getConnection(connectionString,user,password);
			//5.关闭Connection连接
			conn.close();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
