package com.oh.dao;

import java.util.ArrayList;
import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.oh.domain.BDto;

public class BDao {

	DataSource dataSource;
	
	public BDao(){
		
		try {
			Context  context = new InitialContext();
		//	dataSource = context.lookup()
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}
	
	public ArrayList<BDto> list(){
		
		ArrayList<BDto> dtos= null;
		
		return dtos;
	}
}
