package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JsExecutor {
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
	public void javaScriptExecutorTest() throws InterruptedException {
		driver.get("https://www.w3schools.com/");
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Fetch Domain name
		String domainName = (String) js.executeScript("return document.domain");
		System.out.println("Domain name: "+domainName);
		
		//Generate alert box
		//js.executeScript("alert('pop box notification');");
		//Thread.sleep(6000);
		//Scrolling Down
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
		//
		WebElement element = driver.findElement(By.xpath("//a[text()='HTML REFERENCE']"));
		js.executeScript("arguments[0].setAttribute('style','border: 2px solid red;');",element);
		Thread.sleep(5000);
		//click on the element
		js.executeScript("arguments[0].click()",element);		
				
		
		
	}
}
