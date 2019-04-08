import java.sql.*;

public class JDBCtest {
	static final String user = "root";
	static final String password = "123456";	
	static final String dburl = "jdbc:mysql://localhost:3306/test";
	
	public static void main(String[] args) {
		try {
			//2.注册JDBC驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			
			//3.建立连接
			Connection con = java.sql.DriverManager.getConnection(dburl,user,password);
				
			//4.执行一个查询
			System.out.println("Creating statement...");
			Statement stmt = con.createStatement();
			String sql ="select id from employees";
			ResultSet rs =stmt.executeQuery(sql);
			
			//5.从结果集中提取数据
			while(rs.next()) {
				int id = rs.getInt("id");
				System.out.println("ID: " + id);				
			}
			
			//6.清理环境资源
			rs.close();
			stmt.close();
			con.close();		
		
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Goodbye!");
	}
	
}
