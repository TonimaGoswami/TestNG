package com.test;

import org.testng.annotations.Test;

public class InvocationCountFeature {
	
	@Test(invocationCount = 3)
	public void sum() {
		int a = 10;
		int b = 30;
		int c = a + b;
		System.out.println(c);
	}
	
	
	
	

}
