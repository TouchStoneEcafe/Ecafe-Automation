package eCafe_DDF;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Set;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelLib {
	
	public static Workbook wrkBook;
	public static Sheet sheet1;
	public static Sheet sheet2;
	public static Hashtable dict1=new Hashtable();
	public static Hashtable dict2=new Hashtable();
	public static Hashtable flaggedMethod=new Hashtable();
	public static Hashtable flaggedClass=new Hashtable();
	public static Hashtable flaggedparameter=new Hashtable();
	public ExcelLib(String path) throws IOException, BiffException{
			
			wrkBook=Workbook.getWorkbook(new File(path));
			sheet1=wrkBook.getSheet("Testcase");
			sheet2=wrkBook.getSheet("Browser");
			testcaseColumDictionary();
			browserColumDictionary();
	}
	// Returns the Sum of Rows in the Excel 
	public static int rowCount(){
		return sheet1.getRows();
	}
	// Returns the Cell value by taking row and column as argument
	public static String getCellValue(int colNumber, int rowNumber){
		return sheet1.getCell(colNumber, rowNumber).getContents();
	}
	public static String readCell(String colName, int rowNumber){
		return getCellValue(getCell(colName),rowNumber);
	}
	// Create Column Dictionary to hold all the Column Names
	public static void testcaseColumDictionary(){
		for(int col=0; col<sheet1.getColumns(); col++){
			dict1.put(getCellValue(col,0), col);
		}
	}
	// Read Column Names
	public static int getCell(String colName){
		try{
		int value;
		value=((Integer) dict1.get(colName)).intValue();
		return value;
		}catch(NullPointerException e){
			return(0);
		}
	}
	// Get all the Flagged methods from Excel Sheet
	public static Hashtable getFlaggedMethods(String columnName){
		try{
			int methodcount=1; // Key count Flag will track of method count
			for(int row=0;row<rowCount();row++){
				if(readCell(columnName, row).equals("EXECUTE")){
				// put method key count and the key name
				flaggedMethod.put(methodcount, readCell("Class", row)+":"+readCell("TestcaseMethods", row)
						+":"+ readCell("ExcelName", row));
					methodcount++;
				}
			}
		}catch(Exception e){
			
		}
		return flaggedMethod;
	}
	public static Hashtable getFlaggedclass(String columnName){
		try{
			int methodcount=1; // Key count Flag will track of method count
			for(int row=0;row<rowCount();row++){
				if(readCell(columnName, row).equals("EXECUTE")){
				// put method key count and the key name
					if(!flaggedClass.containsValue(readCell("Class", row))){				
					flaggedClass.put(methodcount, readCell("Class", row));					
					methodcount++;
					}
				}
			}
		}catch(Exception e){
			
		}
		return flaggedClass;
	}
	
	// **********************************************************************************
	// Browser Sheet
	public static int browserrowCount(){
		return sheet2.getRows();
	}
	// Returns the Cell value by taking row and column as argument
	public static String browsergetCellValue(int colNumber, int rowNumber){
		return sheet2.getCell(colNumber, rowNumber).getContents();
	}
	public static String browserreadCell(String colName, int rowNumber){
		return browsergetCellValue(browsergetCell(colName),rowNumber);
	}
	// Create Column Dictionary to hold all the Column Names
	public static void browserColumDictionary(){
		for(int col=0; col<sheet2.getColumns(); col++){
			dict2.put(browsergetCellValue(col,0), col);
		}
	}
	// Read Column Names
	public static int browsergetCell(String colName){
		try{
		int value;
		value=((Integer) dict2.get(colName)).intValue();
		return value;
		}catch(NullPointerException e){
			return(0);
		}
	}
	public static Hashtable getFlaggedparameter(String columnName){
		try{
			int methodcount=1; // Key count Flag will track of method count
			for(int row=0;row<browserrowCount();row++){
				if(browserreadCell(columnName, row).equals("On")){
				// put method key count and the key name
				flaggedparameter.put(methodcount, browserreadCell("Browsers", row));
					methodcount++;
				}
			}
		}catch(Exception e){
			
		}
		return flaggedparameter;
	}
}
