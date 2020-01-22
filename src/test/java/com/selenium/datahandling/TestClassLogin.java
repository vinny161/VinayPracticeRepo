package com.selenium.datahandling;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.utility.ExcelUtility;

public class TestClassLogin {
	WebDriver driver;
	String userLoginDetailsFilePath = System.getProperty("user.dir")+ "/src/test/resources/UserLoginDetails.xlsx";
	String userLoginStatusFilePath = System.getProperty("user.dir")+ "/src/test/resources/UserLoginStatus.xlsx";
	@BeforeTest
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\a07208trng_b4b.04.25\\Desktop\\Selenium_vinay_training\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println("Current page title:"+ driver.getTitle());
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getLoginData()
	{    
		try {
		return ExcelUtility.readFromExcel(userLoginDetailsFilePath);
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	@Test(dataProvider ="getLoginData")
	public void loginTest(String uname, String pwd) throws InterruptedException, IOException
	{
		driver.findElement(By.linkText("Log in")).click();  ////a[text()='Log in']
		driver.findElement(By.id("Email")).sendKeys(uname); ////input[@name='Email']
		driver.findElement(By.id("Password")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Thread.sleep(5000);
		//Assert.assertEquals(driver.getTitle(),"Demo Web Shop"); //for validation if we want to use assert - Hard asset
		
		//SoftAssert sa = new SoftAssert();   --- to use the soft assert
		//sa.assertEquals(driver.getTitle(),"Demo Web Shop");
		String title = driver.getTitle();
		if(title.equalsIgnoreCase("Demo Web Shop"))
		{
			driver.findElement(By.linkText("Log out")).click();
			ExcelUtility.writeToExcel(userLoginStatusFilePath, uname, pwd, "Login Successful");
		}
		else
		{
			driver.get("http://demowebshop.tricentis.com/");
			ExcelUtility.writeToExcel(userLoginStatusFilePath, uname, pwd, "Login Unsuccessful");
		}
		
	}
	
}
