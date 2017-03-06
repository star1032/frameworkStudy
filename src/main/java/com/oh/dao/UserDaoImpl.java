package com.oh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.oh.connection.ConnectionMaker;
import com.oh.domain.User;

public class UserDaoImpl implements UserDao{
	ConnectionMaker connectionMaker = null;
	public UserDaoImpl() {}
	
	public UserDaoImpl(ConnectionMaker connectionMaker) throws ClassNotFoundException {
		this.connectionMaker = connectionMaker;
	}
	
	public void setConnectionMaker(ConnectionMaker connectionMaker){
		this.connectionMaker = connectionMaker;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		
		ApplicationContext context = new GenericXmlApplicationContext("root-context.xml");
//		ApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml", DaoFactory.class);
		
		
		UserDao dao = context.getBean("userDao", UserDaoImpl.class);
		
		dao.deleteAll();
		
		dao.add(new User("1111", "진성", "1111"));
		
		User getUser = dao.get("1111");
		
		System.out.println(getUser.getName());	
		System.out.println(context);
	}
	
	public void deleteAll() throws ClassNotFoundException, SQLException{
		
		Connection c = getConnection();
		
		PreparedStatement ps= c.prepareStatement("DELETE FROM USERS");
				
		ps.executeUpdate();
		ps.close();
		c.close();
	}
	
	public void add(User user) throws ClassNotFoundException, SQLException{
		Connection c = getConnection();
		
		PreparedStatement ps= c.prepareStatement("insert into users(id, name, password) values(?,?,?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		ps.close();
		c.close();
	}
	
	public User get(String id) throws ClassNotFoundException, SQLException{
		Connection c = getConnection();
		
		PreparedStatement ps= c.prepareStatement("select * from users where id= ?");
		ps.setString(1, id);

		ResultSet rs= ps.executeQuery();
		rs.next();

		User user= new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		
		rs.close();
		ps.close();
		c.close();
		
		return user;
	}
	
	
	private Connection getConnection() throws SQLException{
		
		return connectionMaker.makeConnection();
	}
	
	
}
