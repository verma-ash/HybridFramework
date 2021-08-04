package com.companyName.projectName.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.companyName.projectName.Base.PageBase;
import com.companyName.projectName.Base.TestBase;

/**
 * This class will contain the common operation or methods which can be used
 * through out the project excel data provider, capture screenshots, execute
 * javascript handle alerts, handle windows,
 * 
 * @author Ashish
 *
 */
public class Utility extends TestBase {

	static FileInputStream fis;
	static XSSFWorkbook workbook;
	static Object[][] dataObj;
	static String TestDataLoaction = prop.getProperty("testDataLocation");
	static String userDir = System.getProperty("user.dir");

	/**
	 * Static method for fetching the data from excel(.xlsx) file to data provider
	 * methods of test class
	 * 
	 * @param sheetName
	 * @return
	 * @throws IOException
	 */
	public static Object[][] getDataFromExcel(String sheetName) throws IOException {

		try {
			fis = new FileInputStream(userDir + "/" + TestDataLoaction);
			workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			dataObj = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

			for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
				XSSFRow row = sheet.getRow(rowNum + 1);
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

	public static void captureScreenshotOfFullPage(String screenshotName) {

		File src = ((TakesScreenshot) PageBase.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./Screenshots/" + screenshotName + prop.getProperty("screenshotFormat")));
		} catch (Exception e) {
			System.out.println("Unable to take screenshot of " + screenshotName + "----" + e.getMessage());
		}

	}

}
