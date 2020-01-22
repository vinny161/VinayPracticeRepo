package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenshot {
	
	public static void captureImage(WebDriver driver)
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("C:\\screenshots\\"+timeStamp()+"_DemoWebshop.png"));
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
   public static String timeStamp() {
	   return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
   }
}
