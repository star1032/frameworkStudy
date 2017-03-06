package com.oh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.oh.domain.User;

public class UserDao {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		UserDao dao = new UserDao();
		
		dao.deleteAll();
		
		dao.add(new User("1111", "해봉", "1111"));
		
		User getUser = dao.get("1111");
		
		System.out.println(getUser.getName());
	}
	
	
	public void deleteAll() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection c =DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.56:1521:XE", 
				"yun",
				"1111");
		PreparedStatement ps= c.prepareStatement("DELETE FROM USERS");
				
		ps.executeUpdate();
		ps.close();
		c.close();
	}
	
	public void add(User user) throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection c =DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.56:1521:XE", 
				"yun",
				"1111");
		PreparedStatement ps= c.prepareStatement("insert into users(id, name, password) values(?,?,?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		ps.close();
		c.close();
	}
	
	public User get(String id) throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection c =DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.56:1521:XE", 
				"yun",
				"1111");
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
	
	
	
}
