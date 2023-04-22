package ReadDataFromXl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utility {
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow rowData;
	public XSSFCell cellData;
	//public CellStyle style;
    String file=null;
	
	
	public Utility(String File)
	{
		this.file=File;
	}
	
	public int getRowCount(String sheetName) throws IOException  
	{
	    fi = new FileInputStream(file)  ;
	    workbook = new XSSFWorkbook(fi);
	    sheet = workbook.getSheet(sheetName);
	    int rowCount = sheet.getLastRowNum();
	    workbook.close();
	    fi.close();
	    fo.close();
	    return rowCount;
	}
	
	public int getCellCount(String sheetName, int rowNum) throws IOException
	{
		fi = new FileInputStream(file)  ;
	    workbook = new XSSFWorkbook(fi);
	    sheet = workbook.getSheet(sheetName);
	    rowData = sheet.getRow(rowNum);
	    int cellCount = rowData.getLastCellNum();
	    workbook.close();	
	    fi.close();
	    fo.close();
	    return cellCount;
	}
	
	public String getCellData(String sheetName, int rowCount, int cellCount) throws IOException {
	    fi = new FileInputStream(file);
	    workbook = new XSSFWorkbook(fi);
	    sheet = workbook.getSheet(sheetName);
	    rowData = sheet.getRow(rowCount);
	    cellData = rowData.getCell(cellCount);

	    DataFormatter formatter = new DataFormatter();
	    String data;
	    try {
	        data = formatter.formatCellValue(cellData); // it returns any type of data into string format
	    } catch (Exception e) {
	        data = "";
	    } finally {
	        workbook.close();
	        fi.close();
	        fo.close();
	    }
	    return data;
	}
	
	
	
	public static String[][] getExcelData(String sheetName) {
	    String[][] excelData = null;
	    try {
	        File file = new File(System.getProperty("user.dir") + "/Datafiles/LoginData.xlsx");
	        FileInputStream inputStream = new FileInputStream(file);
	        Workbook workbook = new XSSFWorkbook(inputStream);
	        Sheet sheet = workbook.getSheet(sheetName);
	        int rowCount = sheet.getLastRowNum();
	        int columnCount = sheet.getRow(0).getLastCellNum();
	        excelData = new String[rowCount][columnCount];
	        for (int i = 1; i <= rowCount; i++) {
	            Row row = sheet.getRow(i);
	            for (int j = 0; j < columnCount; j++) {
	                Cell cell = row.getCell(j);
	                String cellData = cell.getStringCellValue();
	                excelData[i - 1][j] = cellData;
	            }
	        }
	        inputStream.close();
	        workbook.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	        // return an empty 2D array if an exception occurs
	        return new String[0][0];
	    }
	    return excelData;
	}







	public void cetCellData()
	{
		// not requred till
	}
	
	
}
