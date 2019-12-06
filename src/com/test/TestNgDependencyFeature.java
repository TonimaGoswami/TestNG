package com.test;

	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	public class TestNgDependencyFeature {
		WebDriver driver;
		
		@Test
		public void setUp() {
			System.setProperty("webdriver.chrome.driver", "/Users/tanu/Downloads/IMP-Drivers/chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("http://www.facebook.com");
		}
		
		@Test(dependsOnMethods = { "setUp" })
		public void login() {
			driver.findElement(By.id("email")).sendKeys("tonimagoswami@gmail.com");
			driver.findElement(By.id("pass")).sendKeys("Victoria2017");
			driver.findElement(By.xpath("//input[@value = 'Log In']")).click();
			
		}
		
		@Test(dependsOnMethods = { "setUp" })
		public void homepage() {
			driver.findElement(By.xpath("//span[@class = '_1qv9']/span[@class='_1vp5 f_click']")).click();
		}
		
		
		
		
		
		

}
