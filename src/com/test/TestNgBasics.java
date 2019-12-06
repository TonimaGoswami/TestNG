package com.test;
import org.testng.annotations.*;

public class TestNgBasics {
	
//	Sequence of Annotations execution
	
//	BeforeSuite--- setup system property for chrome
//	BeforeTest --- launch browser
//	BeforeClass --- enter url 
	
//	BeforeMethod --- login to app 
//	Test2 --- check the logo
//	AfterMethod --- logout from app
	
//	BeforeMethod --- login to app 
//	Test1 --- get the Title
//	AfterMethod --- logout from app
	
//	BeforeMethod --- login to app 
//	Test3 --- search test
//	AfterMethod --- logout from app
	
//	AfterClass --- close the browser
//	AfterTest -- delete all cookies

	
		@BeforeSuite
		public void setUp(){
			System.out.println("BeforeSuite--- setup system property for chrome");
			
		}
		@BeforeTest
		public void launchBrowser(){
			System.out.println("BeforeTest --- launch browser");
		}
		
		@BeforeClass
		public void enterURL(){
			System.out.println("BeforeClass --- enter url ");
		}
		
		@BeforeMethod
		public void login(){
			System.out.println("BeforeMethod --- login to app ");
		}	
		@Test
		public void googleTitleTest(){
			System.out.println("Test1 --- get the Title");
			
		}
		@Test
		public void googleLogoTest(){
			System.out.println("Test2 --- check the logo");
		}
		@Test
		public void searchTest(){
			System.out.println("Test3 --- search test");
		}
		

		@AfterMethod
		public void logout(){
			System.out.println("AfterMethod --- logout from app");
		}
		
		@AfterClass
		public void closeTheBrowser(){
			System.out.println("AfterClass --- close the browser");
		}
			
		@AfterTest
		public void deleteAllCookies(){
			System.out.println("AfterTest -- delete all cookies");
			
		}
		
}		
		
		

