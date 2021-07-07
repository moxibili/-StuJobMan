/**
 * 数据库的连接

 * 
 * 
 */
package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static Connection conn = null;
	
	private static final String CLASSNAME = "com.mysql.cj.jdbc.Driver";//mysql的驱动类
	
	private static final String URL = "jdbc:mysql://localhost:3306/jiuyexinxi?useSSL=false&serverTimezone=UTC";//url
	
	private static final String USER = "root";//数据库用户名
	
	private static final String PASSWORD = "123456";//数据库密码
	
	public static Connection getConnection() {
	try {
			if (conn != null && !conn.isClosed())
					
				return conn;
			
			Class.forName(CLASSNAME);//加载驱动程序
			
			conn = DriverManager.getConnection(URL, USER, PASSWORD);//连接数据库
			
			//System.out.println(conn);  不为null则表明连接成功
			
			return conn;
		} catch (ClassNotFoundException e) {
			
			System.out.println("加载驱动类失败！");
			
			e.printStackTrace();
			
		} catch (SQLException e) {
			
			System.out.println("连接数据库失败！");
			
			e.printStackTrace();
			
		}
	
		return null;
	}
	/*	public static void main(String[] args) {
			String driver="jdbc:mysql://localhost:3306/studentmanager?useSSL=false&serverTimezone=UTC";
			try {
				Class.forName(CLASSNAME);
				System.out.println("加载驱动成功！");
			} catch (ClassNotFoundException e) {
				System.out.println("加载驱动类失败！");
			}
			try {
				Connection con = DriverManager.getConnection(driver,"root","995325");
				System.out.println("连接数据库成功！");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("连接数据库失败！");
			}
		}*/
}
