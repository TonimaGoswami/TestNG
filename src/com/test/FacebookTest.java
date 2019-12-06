package com.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;




public class FacebookTest {
	
		WebDriver driver;
		
		
		@Parameters({"url"})
		@BeforeMethod
		public void setUp(String Url) {
			System.setProperty("webdriver.chrome.driver", "/Users/tanu/Downloads/IMP-Drivers/chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(Url);
		}
		
		@DataProvider(name= "myData1")
		public Object[][] LoginTestData() {
			
			Object[][] obj = new Object[2][2];
			obj[0][0] = "tonimagoswami@gmail.com";
			obj[0][1] = "Victoria2017";
			obj[1][0] = "tanu_tanuut@yahoo.ca";
			obj[1][1] = "flaskdjango#3344";
			return obj;
		}
		
//		@Test()
//		public void registrationTest(String firstname,String lastname, String mobileNumber, String password){
//			driver.findElement(By.name("firstname")).sendKeys(firstname);
//			driver.findElement(By.name("lastname")).sendKeys(lastname);
//			driver.findElement(By.xpath("//input[@id='u_0_j']")).sendKeys(mobileNumber);
//			driver.findElement(By.xpath("//input[@id='u_0_q']")).sendKeys(password);;
//			driver.findElement(By.xpath("//input[@id='u_0_9']")).click();
//			driver.findElement(By.name("websubmit")).click();
//		
//			
//		}

//	@Parameters({"username", "password"})
	@Test(dataProvider= "myData1")
		public void Login(String Username, String Password){
		driver.findElement(By.name("email")).sendKeys(Username);
		driver.findElement(By.name("pass")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		
	}
		
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
		
		

}
