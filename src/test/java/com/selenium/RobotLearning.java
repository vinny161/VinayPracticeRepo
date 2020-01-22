package com.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RobotLearning {
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
	//	driver.quit();
	}
	
	@Test
	public void robotPracticeTest() throws InterruptedException, AWTException {
		driver.get("http://demo.automationtesting.in/Register.html");
		//WebDriverWait wait = new WebDriverWait(driver,10000);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='imagesrc']")));
		//driver.findElement(By.id("imagesrc")).click();
		//driver.findElement(By.xpath("//input[@id='imagesrc']")).click();
		WebElement element1 = driver.findElement(By.xpath("//input[@id='imagesrc']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();",element1);
				
		Robot rb = new Robot();
		rb.setAutoDelay(2000);
		String path = "C:\\Users\\a07208trng_b4b.04.25\\Desktop\\download.jpg";
		StringSelection sel = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
		System.out.println("Selection is: "+ sel);
		
		rb.setAutoDelay(2000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.setAutoDelay(2000);
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(8000);
		
	}
}
