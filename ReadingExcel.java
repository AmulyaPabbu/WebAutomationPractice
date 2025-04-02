package day32;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Excel file --> workbook --> sheet --> rows --> cells
public class ReadingExcel {

	public static void main(String[] args) throws IOException {
		
		//opens file in reading mode
		FileInputStream file=new FileInputStream("C:\\Users\\location"); //right click on excel file and go to properties and then location
		//FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\testdata\\data.xlsx"); //in case you moved your project to some other location
		
		//get workbook from file
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		//capture specific sheet from workbook
		XSSFSheet sheet=workbook.getSheet("Sheet1"); //specify sheet name
		//workbook.getSheetAt(0);  //specify index of sheet
		
		//to know number of rows
		int totalrows=sheet.getLastRowNum();
		
		//to know number of cells/columns
		int totalcells=sheet.getRow(1).getLastCellNum();
		
		//according to excel and java rows are counted from 0
		System.out.println("Number of rows: " +totalrows);  
		//according to excel cells are counted from 1 and according to java cells are counted from 0
		System.out.println("Number of cells: " +totalcells);
		
		for(int r=0;r<=totalrows;r++)
		{
			XSSFRow currentRow=sheet.getRow(r);
			for(int c=0;c<totalcells;c++)
			{
				XSSFCell cell=currentRow.getCell(c);
				String value=cell.toString();
				System.out.print(value);			
			}
			System.out.println();
		}
		
		workbook.close();
		file.close();	

	}

}
