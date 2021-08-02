package com.companyName.projectName.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.companyName.projectName.Base.TestBase;

public class Utility extends TestBase {

	static FileInputStream fis;
	static XSSFWorkbook workbook;
	static Object[][] dataObj;
	static String TestDataLoaction = prop.getProperty("testDataLocation");
	static String userDir = System.getProperty("user.dir");

	public static Object[][] getDataFromExcel(String sheetName) throws IOException {

		try {
			fis = new FileInputStream(userDir + "/" + TestDataLoaction);
			workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			dataObj = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
				XSSFRow row = sheet.getRow(rowNum+1);
				for (int colNum = 0; colNum < sheet.getRow(1).getLastCellNum(); colNum++) {
					XSSFCell cell = row.getCell(colNum);
					switch (cell.getCellType()) {
					case STRING:
						dataObj[rowNum][colNum] = cell.getStringCellValue();
						break;
					case NUMERIC:
						dataObj[rowNum][colNum] = cell.getNumericCellValue();
						break;
					case BOOLEAN:
						dataObj[rowNum][colNum] = cell.getBooleanCellValue();
						break;
					default:
						break;
					}
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			workbook.close();
			fis.close();
		}
		return dataObj;
	}

}
