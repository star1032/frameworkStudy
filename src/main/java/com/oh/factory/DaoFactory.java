package com.oh.factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.oh.connection.ConnectionMaker;
import com.oh.connection.OurConnection;
import com.oh.dao.UserDaoImpl;

@Configuration
public class DaoFactory {
	@Bean
	public static UserDaoImpl getUserDao() throws ClassNotFoundException{
		return new UserDaoImpl(getMyConnectionMaker());
	}
	
	@Bean
	public static ConnectionMaker getMyConnectionMaker() throws ClassNotFoundException{
		return new OurConnection();
	}
}
