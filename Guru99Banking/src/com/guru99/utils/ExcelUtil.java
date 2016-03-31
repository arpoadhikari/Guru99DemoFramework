package com.guru99.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class ExcelUtil {

	private FileInputStream excelFile;
	private XSSFWorkbook excelBook;
	private XSSFSheet excelSheet;
	private XSSFRow excelRow;
	private XSSFCell excelCell;
	private String fPath;
	
	// Constructor of this class
	public ExcelUtil(String filePath, String sheetName) throws Exception {
		fPath = filePath;
		excelFile = new FileInputStream(fPath);
		excelBook = new XSSFWorkbook(excelFile);
		excelSheet = excelBook.getSheet(sheetName);
	}
	
	// Method which read from a cell
	public String readCell(Integer rowNum, Integer colNum) throws Exception {		
		String data = "";
		DataFormatter formatter = new DataFormatter();
		excelRow = excelSheet.getRow(rowNum);
		if (excelRow != null) { //Checking for null row
			excelCell = excelRow.getCell(colNum, Row.RETURN_BLANK_AS_NULL);
			if (excelCell != null) { // Checking for null cell
				data = formatter.formatCellValue(excelCell);//Returns the formatted value of a cell as a String regardless of the cell type
			}
			else {
				data = "";
			}
		}
		return data;		
	}
	
	// Method which write into a cell
	public void writeCell(String data, Integer rowNum, Integer colNum) throws Exception {
		excelRow = excelSheet.getRow(rowNum);
		if (excelRow == null) { // Checking for null row
			excelRow = excelSheet.createRow(rowNum);
		}
		excelCell = excelRow.getCell(colNum, Row.RETURN_BLANK_AS_NULL);
		if (excelCell == null) { // Checking for null cell
			excelCell = excelRow.createCell(colNum);
			excelCell.setCellValue(data); // Write into the cell
		}
		excelCell.setCellValue(data);
		FileOutputStream outputStream = new FileOutputStream(fPath);
		excelBook.write(outputStream);
        outputStream.close();
	}
	
	// Method which searches for values in a excel sheet
	public List<XSSFCell> findValue(String value) throws Exception {
		int firstRow = excelSheet.getFirstRowNum(); // Get first row number
		int lastRow = excelSheet.getLastRowNum(); // Get last row number
		List<XSSFCell> cells = new ArrayList<XSSFCell>(); // Creating a list in which matching cells will be stored

		for (int i = firstRow; i <= lastRow; i++) {
			int firstCol = excelSheet.getRow(i).getFirstCellNum(); // Get first cell of respective row
			int lastCol = excelSheet.getRow(i).getLastCellNum(); // Get last cell of respective row
			for (int j = firstCol; j <= lastCol; j++) {
				if (this.readCell(i, j).equalsIgnoreCase(value)) {
					cells.add(excelSheet.getRow(i).getCell(j)); // Add matching cells in the list
				}
			}
		}
		return cells;	
	}
	
	// Method to return the last row index
	public int getLastRow() {
		return excelSheet.getLastRowNum();	
	}
	
}
