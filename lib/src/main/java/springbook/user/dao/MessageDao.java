package springbook.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springbook.user.domain.User;

public class MessageDao {
	//1.3 DAO의 확장
//	private SimpleConnectionMaker simpleConnectionMaker;
	
	//1.3 DAO의 확장 (인터페이스)
	private ConnectionMaker connectionMaker;
	
	public MessageDao(ConnectionMaker connectionMaker) {
//		simpleConnectionMaker = new SimpleConnectionMaker();
		this.connectionMaker = connectionMaker;
	}
	
	public void add(User user) throws ClassNotFoundException, SQLException {
		Class.forName("org.mariadb.jdbc.Driver");
		//1.2 DAO의 분리
//		Connection c = getConnection();
		
		//1.3 DAO의 확장
		Connection c = connectionMaker.makeConnection();
		
		PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values(?,?,?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
		c.close();
		
	}
	
	public User get(String id) throws ClassNotFoundException, SQLException {
		Class.forName("org.mariadb.jdbc.Driver");
		//1.2 DAO의 분리
//		Connection c = getConnection();
		
		//1.3 DAO의 확장
		Connection c = connectionMaker.makeConnection();
		
		PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
		
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		
		rs.close();
		ps.close();
		c.close();
		
		return user;
	}
	
	//1.1 초난감 DAO
//	private Connection getConnection() throws ClassNotFoundException, SQLException {
//		Class.forName("org.mariadb.jdbc.Driver");
//		Connection c = DriverManager.getConnection("jdbc:mariadb://localhost:3306/board", "root", "1234");
//		
//		return c;
//	}
	
	//1.2 DAO의 분리
//	public abstract Connection getConnection() throws ClassNotFoundException, SQLException;
}