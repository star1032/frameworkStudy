package com.oh.dao;

import java.sql.SQLException;

import com.oh.domain.User;

public interface UserDao {
	public void deleteAll() throws ClassNotFoundException, SQLException;
	public void add(User user) throws ClassNotFoundException, SQLException;
	public User get(String id) throws ClassNotFoundException, SQLException;
}
