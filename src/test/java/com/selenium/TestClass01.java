package com.selenium;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.utility.CaptureScreenshot;

public class TestClass01 {

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
	public void mouseHoverTest() throws InterruptedException {
		driver.get("http://demowebshop.tricentis.com/");
		Thread.sleep(4000);
		CaptureScreenshot.captureImage(driver);
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.linkText("Electronics")))
		.moveToElement(driver.findElement(By.linkText("Cell phones")))
				.click()
				.build()
				.perform();
		Thread.sleep(10000);
		System.out.println("Current Page title:"+driver.getTitle());
	}
}
