package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass03 {

	WebDriver driver;
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\a07208trng_b4b.04.25\\Desktop\\Selenium_vinay_training\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		System.out.println("Current page title:"+ driver.getTitle());
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void dragAndDropTest() throws InterruptedException {
		driver.get("http://demo.guru99.com/test/drag_drop.html");
		Thread.sleep(5000);
	}
	
}
