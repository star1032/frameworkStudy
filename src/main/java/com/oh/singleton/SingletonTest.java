package com.oh.singleton;

interface test{
	public SingletonTest newInstance();
}

public class SingletonTest {
	private static SingletonTest test;
	private static String a;
	
	private SingletonTest() {}
	
	public static void setAAa(String a){
		
	}
	
	public static SingletonTest newInstance(){
		if(test == null)
			test = new SingletonTest();
		
		return test;
	}
}


