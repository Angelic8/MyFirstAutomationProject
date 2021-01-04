package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;

	public ExcelUtils(String excelPath, String sheetName) {

		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		} catch (IOException e) {
			e.printStackTrace();
		}

	} // end constructor ExcelUtils()

	/*public static void main(String[] args) {

		getRowCount();
		getCellStringData(0, 0);
		getCellNumericalData(1, 1);

	} // end main method*/

	public void getRowCount() {

		try {
			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("The number of rows: " + rowCount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}

	} // end method getRowCount()

	public void getCellStringData(int rowNum, int colNum) {

		try {
			String cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			System.out.println("The column data is: " + cellData);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}

	} // end method getCellStringData()

	public void getCellNumericalData(int rowNum, int colNum) {

		try {
			double cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			System.out.println("The column's numerical data is: " + cellData);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}

	} // end method getCellNumericalData()

} // end class ExcelUtils
