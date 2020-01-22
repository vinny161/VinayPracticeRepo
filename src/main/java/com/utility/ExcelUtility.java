package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static DataFormatter formatter = new DataFormatter();
	public static int rowCounter =1;
	
	public static Object[][] readFromExcel(String filePath) throws IOException 
	{
		File f = new File(filePath);
		FileInputStream input = new FileInputStream(f);
		
		wb = new XSSFWorkbook(input);
		sheet = wb.getSheetAt(0);
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rowCount-1][colCount]; // to not consider the header. Assumption is header is included.
		
		for (int i=0; i< rowCount-1; i++) 
		{
			XSSFRow row = sheet.getRow(i+1);
			
			for(int j=0; j<colCount;j++) 
			{
			   XSSFCell cell = row.getCell(j);	
			   if(cell==null) 
			   {
				   data[i][j]="";
				}
			   else {
				   data[i][j]= formatter.formatCellValue(cell);
			   		}
			}
		}
		wb.close();
		return data;
	}
	
	//writing to new excel and specific for my requirement
	public static void writeToExcel(String filePath, String username, String password, String status) throws IOException 
	{
		File f = new File(filePath);
		FileInputStream input = new FileInputStream(f);
		
		wb = new XSSFWorkbook(input);
		sheet = wb.getSheetAt(0);
		
		if(sheet.getRow(rowCounter)==null)
		{
			sheet.createRow(rowCounter).createCell(0).setCellValue(username);
		}
		else
		{
			sheet.getRow(rowCounter).createCell(0).setCellValue(username);
		}
		sheet.getRow(rowCounter).createCell(1).setCellValue(password);
		sheet.getRow(rowCounter).createCell(2).setCellValue(status);
		
		FileOutputStream outFile = new FileOutputStream(new File(filePath));
		wb.write(outFile);
		outFile.close();
		rowCounter++;
	}

}
