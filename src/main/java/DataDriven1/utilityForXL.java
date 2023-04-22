package DataDriven1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class utilityForXL
     {
    public static FileInputStream fi;
    public static FileOutputStream fo;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFCell cellData;
	public static XSSFRow rowData;
	public static String path;
	
	public utilityForXL(String path) 
	     {
		    this.path=path;
	     }
	@SuppressWarnings("null")
	public int getRowCount(String sheetName) throws FileNotFoundException
	     {
		    int rowcount;
		    fi = new FileInputStream(path);
		    try {
				workbook = new XSSFWorkbook(fi);
				sheet = workbook.getSheet(sheetName);
			    rowcount = sheet.getLastRowNum();
				
			} catch (Exception e) {
				rowcount= (Integer) null;
				e.printStackTrace();
			}
		    try {
				fi.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
				workbook.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rowcount;
	     }
     
	  @SuppressWarnings("null")
	public int getCellCount(String sheetName,int rownum) throws FileNotFoundException
	     
	    { 
		  int cellcount=0;
		  fi = new FileInputStream(path);
		  try {
			workbook = new XSSFWorkbook(fi);
			sheet = workbook.getSheet(sheetName);
			rowData = sheet.getRow(rownum);
			cellcount = rowData.getLastCellNum();
		    } catch (Exception e) {
		    cellcount = (Integer) null;
			e.printStackTrace();
		}
		  try {
			fi.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return cellcount;
		} 
	  public String getCellData(String sheetname, int rownum, int cellnum) throws FileNotFoundException 
	  {
		  String testData="";
		  fi = new FileInputStream(path);
		  try {
			workbook = new XSSFWorkbook(fi);
			sheet = workbook.getSheet(sheetname);
			rowData = sheet.getRow(rownum);
			cellData = rowData.getCell(cellnum);
			try {
			DataFormatter formatter = new DataFormatter();
			testData = formatter.formatCellValue(cellData);
			}catch(Exception e)
			{
				testData="";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return testData;
	  }
     
     }
	
	
	
	
	
	
	
	

