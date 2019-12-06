package com.test;

import org.testng.annotations.Test;

public class ExceptionTimeoutFeature {
	
//	@Test(timeOut = 2)
//	public void infiniteLoop() {
//	int i = 1;
//	while(i == 1) {
//		System.out.println(i);
//	}
//	}
	
	@Test(expectedExceptions = NumberFormatException.class)
	public void test1() {
		String s1 = "100A";
		Integer.parseInt(s1);
		
	}
	
	
		
	}


