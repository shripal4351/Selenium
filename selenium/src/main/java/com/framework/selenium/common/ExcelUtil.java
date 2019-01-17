package com.framework.selenium.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtil {
	
	private String excelPath;
	private String sheetName;

	public String getExcelPath() {
		return excelPath;
	}

	public void setExcelPath(String excelPath) {
		this.excelPath = excelPath;
	}
	
	public String getExcelSheetName() {
		return sheetName;
	}

	public void setExcelSheetName(String sheetName) {
		this.sheetName = sheetName;
	}
	
	public void getExcelData(){
		
		File excelFile=null;
		FileInputStream excelFileToRead=null;
		try {
				excelFile = new File(this.excelPath);
				excelFileToRead = new FileInputStream(excelFile);
	            Workbook excelWorkbook = new XSSFWorkbook(excelFile);
	            Sheet excelSheet = excelWorkbook.getSheet(this.sheetName);
	            Iterator<Row> rows = excelSheet.rowIterator();
	
	            while (rows.hasNext()) {
	            	if(rows.next().getRowNum()>0) {
		                Row currentRow = rows.next();
		                Iterator<Cell> columns = currentRow.iterator();
		
		                while (columns.hasNext()) {
		                    Cell currentCell = columns.next();
		            
		                    if (currentCell.getCellType() == CellType.STRING) {
		                        System.out.print(currentCell.getStringCellValue() + "--");
		                    } else if (currentCell.getCellType() == CellType.NUMERIC) {
		                        System.out.print(currentCell.getNumericCellValue() + "--");
		                    }
		
		                }
		                excelFileToRead.close();
	            	}
	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (InvalidFormatException e) {
				e.printStackTrace();
			}
	}
}
