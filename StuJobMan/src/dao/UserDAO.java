package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.User;
import util.DBConnection;

public class UserDAO {
	private Connection conn = null;
	private Statement st = null;
	
	public UserDAO() {
		conn = DBConnection.getConnection();
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 检查用户名密码
	 */
	public User check(String username, String cs) {
		String sql = "select * from user where username='" + username + "' and password='" + cs + "'";
		ResultSet rs;//定义一个结果集
		User user = null;//创建一个User对象
		try {
			rs = st.executeQuery(sql);//在数据库中执行sql语句
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
