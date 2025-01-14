package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NUserDao extends UserDao {
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		// N사 DB connection 생성코드
		Class.forName("org.mariadb.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mariadb://localhost:3306/board", "root", "1234");
		
		return c;
	}
}