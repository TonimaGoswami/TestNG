package com.test;

	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	public class AssertionInTestNG {
		WebDriver driver;
		
		@BeforeMethod
		public void setUp() {
			System.setProperty("webdriver.chrome.driver", "/Users/tanu/Downloads/IMP-Drivers/chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("http://www.google.com");
		}
		
		@Test()
		public void googleTitleTest(){
			String title = driver.getTitle();
			System.out.println("Title :" + title);
			Assert.assertEquals(title, "google");
			}
		
		@Test()
		public void googleLogoTest(){
			Boolean bool = driver.findElement(By.id("hplogo")).isDisplayed();
			System.out.println(bool);
			Assert.assertTrue(bool);
			//OR Assert.assertEquals(bool, true);
			}
		
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
		

}
