package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataExcel {
	

	public static Object[][] getTableArray(String fileName, String sheetname) throws IOException {

		String[][] tabArray = null;

		String excelResource = System.getProperty("user.dir") + System.getProperty("file.separator") + "resources"

				+ System.getProperty("file.separator") + fileName;

		File srcFile = new File(excelResource);

		FileInputStream fin = new FileInputStream(srcFile);

		Workbook wb = null;

		if (fileName.substring(fileName.indexOf('.')).equals(".xls")) {

			wb = new HSSFWorkbook(fin);

			//FormulaEvaluator objFormulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) wb);

		} else {

			wb = new XSSFWorkbook(fin);

			//FormulaEvaluator objFormulaEvaluator = new XSSFFormulaEvaluator((XSSFWorkbook) wb);

		}

		Sheet ws = wb.getSheet(sheetname);

		int rows = ws.getLastRowNum();

		tabArray = new String[ws.getLastRowNum() - 2][ws.getRow(2).getLastCellNum() - 1];

		for (int i = 3; i <= rows; i++) {

			try {

				Row row = ws.getRow(i);

				for (int j = 1; j < (row.getLastCellNum()); j++) {

					try {

						row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);

						tabArray[i - 3][j - 1] = row.getCell(j).getStringCellValue().toString().trim();

						// System.out.println(tabArray[i - 3][j - 1]);

					} catch (NullPointerException e) {

						continue;

					}

				}

			} catch (NullPointerException e) {

				break;

			}

		}

		return tabArray;

	}

@SuppressWarnings("resource")

public static Object[][] getTableArrayOne(String fileName, String sheetname) throws IOException {

       String[][] tabArray = null;

       String excelResource = System.getProperty("user.dir") + System.getProperty("file.separator") + "resources"

                    + System.getProperty("file.separator") + fileName;

       System.out.println(excelResource);

       File srcFile = new File(excelResource);

       FileInputStream fin = new FileInputStream(srcFile);

       Workbook wb = null;

       if (fileName.substring(fileName.indexOf('.')).equals(".xls")) {



              wb = new HSSFWorkbook(fin);

       } else {

              wb = new XSSFWorkbook(fin);

       }

       Sheet ws = wb.getSheet(sheetname);

       System.out.println("First Row :" + ws.getFirstRowNum() + ":Last Row :" + ws.getLastRowNum());

       int rowCount = ws.getLastRowNum() - ws.getFirstRowNum();

       System.out.println("Row Count:" + rowCount);

       int rows = rowCount;

       Row sr = ws.getRow(1);

       int noOfCols = sr.getLastCellNum();

       System.out.println("No Of Columns :" + noOfCols);

       tabArray = new String[rows][noOfCols];



       for (int i = 1; i <= rows; i++) {

              try {

                    if (ws.getRow(i) != null) {

                           sr = ws.getRow(i);

                           for (int j = 0; j < noOfCols; j++) {

                                  if (sr.getCell(j).toString() != null) {

                                         tabArray[i - 1][j] = sr.getCell(j).toString();

                                         System.out.println(tabArray[i - 1][j]);

                                  } else {

                                         continue;

                                  }

                           }

                    } else {

                           continue;

                    }

              } catch (NullPointerException e) {

                    continue;

              }

       }

       return tabArray;

}
}
