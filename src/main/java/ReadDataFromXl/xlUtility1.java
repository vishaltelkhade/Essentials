package ReadDataFromXl;
import java.io.FileInputStream;
	import java.io.IOException;
	import java.io.InputStream;
	import org.apache.poi.ss.usermodel.CellType;
	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
    
	    public class xlUtility1 {
	    public static String[][] readExcel(String sheetName) {
	        String[][] data = null;
	        try {
	            String filePath = "/Com.Essetials/Datafiles/LoginData.xlsx";
	            InputStream ExcelFileToRead = new FileInputStream(filePath);
	            XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
	            XSSFSheet sheet = wb.getSheet(sheetName);

	            int totalRows = sheet.getPhysicalNumberOfRows();
	            int totalCols = sheet.getRow(0).getPhysicalNumberOfCells();
	            data = new String[totalRows - 1][totalCols];

	            for (int i = 1; i < totalRows; i++) {
	                XSSFRow row = sheet.getRow(i);
	                for (int j = 0; j < totalCols; j++) {
	                    XSSFCell cell = row.getCell(j);
	                    cell.setCellType(CellType.STRING);
	                    data[i - 1][j] = cell.getStringCellValue();
	                }
	            }
	            wb.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return data;
	    }
	}


