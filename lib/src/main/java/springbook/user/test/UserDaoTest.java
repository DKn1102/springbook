package springbook.user.test;

import java.sql.SQLException;

import springbook.user.dao.DaoFactory;
import springbook.user.dao.UserDao;
import springbook.user.domain.User;

public class UserDaoTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1.3 DAO의 확장
		//		ConnectionMaker connectionMaker = new DConnectionMaker();
		
		//1.3 DAO의 확장
//		ConnectionMaker connectionMaker = new NConnectionMaker();
//		UserDao dao = new UserDao(connectionMaker);
		
		//1.4 제어의 역전
		UserDao dao = new DaoFactory().userDao();
		
		User user = new User();
		user.setId("david5");
		user.setName("강정구5");
		user.setPassword("Y5");
		
		dao.add(user);
		
		System.out.println(user.getId() + " 등록 성공");
		
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		
		System.out.println(user2.getId() + " 조회 성공");
	}

}
