package utils;

public class ExcelUtilsDemo {

	public static void main(String[] args) {

		String projectPath = System.getProperty("user.dir");
		ExcelUtils excel = new ExcelUtils(projectPath + "/excel/data.xlsx", "Sheet1");

		excel.getRowCount();
		excel.getCellStringData(0, 0);
		excel.getCellNumericalData(1, 1);
	} // end main method

} // end class ExcelUtilsDemo
