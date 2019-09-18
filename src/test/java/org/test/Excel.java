package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
public static void main(String[] args) throws IOException {
	File f=new File("C:\\Users\\Saravanan\\Desktop\\Selenium Tasks\\Sample\\Excel\\Aotomation.xlsx");
	FileInputStream stream=new FileInputStream(f);
	Workbook w= new XSSFWorkbook(stream);
	Sheet s = w.getSheet("Datas");
	Row r = s.getRow(2);
	Cell c = r.getCell(3);
	
	int rowscount=s.getPhysicalNumberOfRows();
	System.out.println(rowscount);
	int cellcount=r.getPhysicalNumberOfCells();
	System.out.println(cellcount);
	
	for (int i=0; i<r.getPhysicalNumberOfCells(); i++) {
	Cell k=r.getCell(i);
	System.out.println(i);}
	
	for (int i=0; i<s.getPhysicalNumberOfRows(); i++) {
		Row m= s.getRow(i);
		System.out.println(m);
		int type=c.getCellType();
		
		if(type==1) {
			String q = c.getStringCellValue();
			System.out.println(q);
			
		}
		else if (type==0) {
		if(DateUtil.isCellDateFormatted(c));
		Date d = c.getDateCellValue();
		SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yy");
		String p = format.format(d);
		System.out.println(p);
		}
		
		else { 
			double n = c.getNumericCellValue();
			long l=(long)n;
			String v = String.valueOf(l);
			System.out.println(v);
			
				
			}
		
		}
		
	
	
	
	}
	
			
	
	
	
	
}

