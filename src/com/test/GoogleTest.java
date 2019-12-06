package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
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
	
	@Test(priority=1, groups= "Title")
	public void googleTitleTest(){
		String title = driver.getTitle();
		System.out.println("Title :" + title);
		}
	@Test(priority=3, groups= "Logo")
	public void googleLogoTest(){
		Boolean bool = driver.findElement(By.id("hplogo")).isDisplayed();
		System.out.println(bool);
		}
	@Test(priority=4, groups= "LinkTest")
	public void googleMailTest() {
		Boolean b = driver.findElement(By.xpath("//a[@class='gb_e']")).isDisplayed();
		System.out.println(b);
	}
	@Test(dependsOnGroups= "Title", priority=5, groups= "LinkTest")
	public void googleLinkTest() {
		Boolean b = driver.findElement(By.linkText("About")).isDisplayed();
		System.out.println(b);
	}
	@Test(priority=2, groups= "SearchTest")
	public void googleSearchTest() {
		driver.findElement(By.xpath("//input[@class = 'gLFyf gsfi']")).sendKeys("TestNG tutorials");
		
	}
	@Test(priority=6, groups= "Logo")
	public void googleAccountImageTest() {
		Boolean b = driver.findElement(By.xpath("//a[@class='gb_z gb_Ia gb_g']")).isDisplayed();
		System.out.println(b);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
