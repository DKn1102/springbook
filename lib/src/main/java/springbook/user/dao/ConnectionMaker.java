package springbook.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

//1.3 DAO의 확장
public interface ConnectionMaker {
	public Connection makeConnection() throws ClassNotFoundException, SQLException;
}
