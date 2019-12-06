package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil {
	
	FileInputStream fis;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	public static String projectPath = System.getProperty("user.dir");
	public static String path =  projectPath + "/TestData/RegistrationData.xlsx"; 
		
		

	public String getCellData(String sheetname, String colName, int rowNum) {
		
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);

			}catch(Exception e) {
				e.printStackTrace();
			}
	
		
		int col_Num = 0;
		try {

			int index = workbook.getSheetIndex(sheetname);
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().equals(colName)) {
					col_Num = i;
				}
			}
			row = sheet.getRow(rowNum);
			XSSFCell cell = row.getCell(col_Num);
			if (cell.getCellType() == CellType.STRING) {
				return cell.getStringCellValue();
			} else if (cell.getCellType() == CellType.NUMERIC) {
				return String.valueOf(cell.getNumericCellValue());
			} else if (cell.getCellType() == CellType.BOOLEAN) {
				return String.valueOf(cell.getBooleanCellValue());
			} else if (cell.getCellType() == CellType.BLANK) {
				return "";
			}
		} catch (Exception exp) {
			exp.printStackTrace();

		}
		return null;
	}
	
	public int getRowCount(String sheetname) {
		try {
		int index = workbook.getSheetIndex(sheetname);
		if(index == -1) {
			return 0;
		}
		else {
			sheet = workbook.getSheetAt(index);
			int rowCount = sheet.getLastRowNum() + 1;
			return rowCount;
		}
		}catch(Exception exp) {
			exp.printStackTrace();
	}
		return 0;
	}
	
	public int getColumnCount(String sheetname) {
		try {
		int index = workbook.getSheetIndex(sheetname);
		if(index == -1) {
			return 0;
		}
		else {
			sheet = workbook.getSheet(sheetname);
			row = sheet.getRow(0);
			return row.getLastCellNum();
	}
		}catch(Exception exp) {
			exp.printStackTrace();
		}
		return 0;
}
	
	
		
}
