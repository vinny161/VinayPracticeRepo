package com.selenium;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass06 {
	Logger log = Logger.getRootLogger();
	WebDriver driver;
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\a07208trng_b4b.04.25\\Desktop\\Selenium_vinay_training\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println("Current page title:"+ driver.getTitle());
		log.info("Current page title of browser is appearing");
	}
	@AfterTest
	public void tearDown() {
		log.info("Browser is closing");
		driver.quit();
	}
	
	@Test
	public void cookiesManagementTest() throws InterruptedException {
		driver.get("https://www.flipkart.com/");
		Thread.sleep(4000);
		log.info("Opening flipcart");
		//add a new cookie in current domain
		Cookie name = new Cookie("mycookie","43535tst");
		driver.manage().addCookie(name);
		//Display all cookies in the current domain
		Set<Cookie> listOfCookies = driver.manage().getCookies();
		for(Cookie c:listOfCookies) {
			System.out.println("");
			System.out.println(c);
		}
		System.out.println("Size of the cookies are--"+listOfCookies.size());
		//display a specific cookie
		System.out.println(driver.manage().getCookieNamed("mycookie"));
		//delete a specific cookie
		driver.manage().deleteCookieNamed("mycookie");
		//Display a specific cookie
		System.out.println(driver.manage().getCookieNamed("mycookie"));
	}
}
