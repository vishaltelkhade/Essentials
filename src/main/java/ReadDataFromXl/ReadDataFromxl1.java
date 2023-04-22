package ReadDataFromXl;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class ReadDataFromxl1 {

	@SuppressWarnings("incomplete-switch")
	public static void main(String[] args) throws IOException {
		String path = "./Datafiles/Population.xlsx";
		FileInputStream inputStream = new FileInputStream(path);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("Sheet1");

		// to know the row count
		int rows = sheet.getLastRowNum();
		// to know the cols count
		int cols = sheet.getRow(1).getLastCellNum();

		for (int r = 0; r <= rows; r++) 
		{
			XSSFRow rowData  = sheet.getRow(r);
            for(int c =0; c < cols; c++) 
            {
            	XSSFCell cellData = rowData.getCell(c);
            	switch(cellData.getCellType())
            	{
            	case STRING: 
            		System.out.print(cellData.getStringCellValue());break;
            	case NUMERIC:
            		System.out.print(cellData.getNumericCellValue());break;
            	case BOOLEAN:
            		System.out.print(cellData.getBooleanCellValue());break;
            	case FORMULA:
            		System.out.println(cellData.getNumericCellValue());break;
            	}
           	System.out.print(" | ");
            }
            System.out.println();
		}
		
	}

}
