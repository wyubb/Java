package chapter2.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.GregorianCalendar;

public class JdbcSQLTest {
	//用jdbc执行SQL INSERT语句
	public static void testInsert() {
		//指定JDBC驱动类名
		String driverName = "com.mysql.jdbc.Driver";
		//指定本机MYSQL的jdbc url
		String connectionString = "jdbc:mysql://localhost:3306/diary";
		String user ="root";
		String password = "123456";
		
		try {
			//加载JDBC驱动类
			Class.forName(driverName);
			//得到一个Connection
			Connection connection = DriverManager.getConnection(connectionString,user,password);
			//1.得到一个用于执行SQL语句的Statement
			Statement statement = connection.createStatement();
			//2.执行INSERT语句
			String insertSQL = "insert into diary(title,content,authorName,time) values('一篇日记','寥寥数字','匿名',NOW()),('第一篇日记','第一篇日记的内容','javaweb爱好者','2011-11-11 09:00:00')";
			int count = statement.executeUpdate(insertSQL);
			//3.输出操作结果
			System.out.println("成功插入了" + count + "条记录");
			//4.关闭Statement
			statement.close();
			//关闭Connection
			connection.close();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//用JDBC执行SQL SELECT语句
	public static void testSelect() {
		//指定JDBC驱动类名
		String driverName = "com.mysql.jdbc.Driver";
		//指定本机MySQL的JDBC URL
		String connectionString = "jdbc:mysql://localhost:3306/diary";
		String user ="root";
		String password = "123456";
		
		try {
			//加载JDBC驱动类
			Class.forName(driverName);
			//得到一个Connection
			Connection connection =DriverManager.getConnection(connectionString,user,password);
			//得到一个用于执行SQL语句的Statement
			Statement statement = connection.createStatement();
			//执行SELECT语句
			String selectSQL = "select * from diary";
			ResultSet resultSet = statement.executeQuery(selectSQL);
			
			while(resultSet.next()) {
				//得到日记的id
				int id = resultSet.getInt("id");
				//得到日记的作者姓名
				String authorName = resultSet.getString("authorName");
				//得到日记的标题、内容
				String title =resultSet.getString("title");
				String content = resultSet.getString("content");
				//得到创建日记的时间
				Date time =resultSet.getTime("time");
				//将Dtae类型转换为GregorianCalendar类型
				GregorianCalendar gc = new GregorianCalendar();
				gc.setTime(time);
				//得到创建日记的年月日时分
				int year = gc.get(GregorianCalendar.YEAR);
				int month = gc.get(GregorianCalendar.MONTH);
				int day = gc.get(GregorianCalendar.DATE);
				int hour = gc.get(GregorianCalendar.HOUR_OF_DAY);
				int minute = gc.get(GregorianCalendar.MINUTE);
			
				System.out.println("第" + id + "篇的日记的作者：" + authorName);
				System.out.println("第" + id + "篇的日记的标题：" + title);
				System.out.println("第" + id + "篇的日记的内容：" + content);
				System.out.println("第" + id + "篇的日记的时间：" + year + "-" + month + "-" + day + " " + hour + ":" + minute);
			}
				//关闭Statement、Connection
				statement.close();
				connection.close();
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
	}

	//用JDBC执行SQL UPDATE语句
	public static void testUpdate() {
		//指定JDBC驱动类名
		String driveName = "com.mysql.jdbc.Driver";
		//指定本机MySQL的JDBC URL
		String url ="jdbc:mysql://localhost:3306/diary";
		String user = "root";
		String pwd ="123456";
		
		try {
			//加载JDBC驱动类
			Class.forName(driveName);
			//得到一个Connection
			Connection  conn = DriverManager.getConnection(url,user,pwd);
			//得到一个用于执行SQL语句的的Statement
			Statement stmt =conn.createStatement();
			//执行UPDATE语句
			String insertSQL = "update diary set title = '第一篇日记的题目-已修改', content = '第一篇日记的内容-已修改',time = NOW() WHERE title = '第一篇日记'";
			int count =stmt.executeUpdate(insertSQL);
			
			//输出操作结果
			System.out.println("成功修改了" + count + "条记录");
			//关闭Statement,Conection
			stmt.close();
			conn.close();
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	//用JDBC执行SQL DELETE语句
	public static void testDelete() {
		String diverName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/diary";
		String user = "root";
		String pwd = "123456";
		
		
		try {
			Class.forName(diverName);
			Connection conn =DriverManager.getConnection(url, user, pwd);
			
			Statement stmt = conn.createStatement();
			String insertSQL ="delete from diary where id = 1";
			int count =stmt.executeUpdate(insertSQL);
			
			System.out.println("成功删除了" + count + "条记录");
			stmt.close();
			conn.close();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		//testInsert();
		//testSelect();
		//testUpdate();
		testDelete();
	}
}


