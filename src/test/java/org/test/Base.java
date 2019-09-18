package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	static WebDriver driver;
	
	public static WebDriver getBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Saravanan\\Desktop\\Selenium Tasks\\Selenium\\Drivers\\chromedriver.exe");
	     driver=new ChromeDriver();
		return driver;
		
	}	
	public static void launchBrowser(String url) {
		driver.get(url);

	}
	public static WebElement Locators(String id) {
		WebElement i=driver.findElement(By.id(id));
		return i;
		

	}
	public static WebElement findElementByXpath(String loc) {
		WebElement x = driver.findElement(By.xpath(loc));
		return x;

	}
	public static  void type(WebElement input, String value) {
		input.sendKeys(value);

	}
	 public static void btnClick(WebElement btn) {
		 btn.click();
		 

	}
	public static void quitBrowser() {
		driver.quit();

	}
	public static String getData(int rowNo,int cellNo) throws IOException{

		File f=new File("C:\\Users\\Saravanan\\Desktop\\Selenium Tasks\\Sample\\Excel\\Aotomation.xlsx");
		FileInputStream stream=new FileInputStream(f);
		Workbook w= new XSSFWorkbook(stream);
		Sheet s = w.getSheet("Datas");
		Row r = s.getRow(rowNo);
		Cell c = r.getCell(cellNo);
		int type=c.getCellType();
		String name=null;
		if(type==1) {
			name = c.getStringCellValue();
		}
		else if (type==0) {
		if(DateUtil.isCellDateFormatted(c));
		new SimpleDateFormat("dd-MMM-yy").format(c.getDateCellValue());
		}
		
		else { 
			name = String.valueOf((long)c.getNumericCellValue());
			}
		return name;
	}
}
