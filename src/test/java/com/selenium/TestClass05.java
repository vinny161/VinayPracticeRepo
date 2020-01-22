package com.selenium;


import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass05 {
	WebDriver driver;
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\a07208trng_b4b.04.25\\Desktop\\Selenium_vinay_training\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println("Current page title:"+ driver.getTitle());
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void findingCoordinatesTest() throws InterruptedException , AWTException
	{
		driver.get("http://www.google.com");
		Thread.sleep(4000);
		
		//WebElement searchButton = driver.findElement(By.xpath("//input[@name='btnK']"));
		WebElement searchButton = driver.findElement(By.xpath("//a[text()='Sign in']"));
		Point p = searchButton.getLocation();
		System.out.println("The XY co-ordinates are:"+p.x+"-"+p.y);
		
		Dimension d = searchButton.getSize();
		System.out.println("The Dimensions are:"+d.height+"-"+d.width);
		
		
		
	}
}
