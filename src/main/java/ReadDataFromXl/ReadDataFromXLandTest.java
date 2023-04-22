package ReadDataFromXl;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadDataFromXLandTest {
	public static ChromeDriver driver;

	@SuppressWarnings("deprecation")
	@BeforeClass
	public void setup() throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Thread.sleep(3000);
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		//Thread.sleep(3000);

	}

	@Test(dataProvider="LoginData")
	public void logInTest(String user, String password, String result) throws InterruptedException
	{
	
		System.out.println(user+""+password+""+result);
	}

	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException 
	{
	    String path = ".//Datafiles/LoginData";
		Utility utils = new Utility(path);
        String[][]datalogin= utils.getExcelData("Sheet1");
	    return  datalogin; 
	  }
	    
	    
	
	
	

	@AfterClass
	public void tearDown() {
		driver.close();
	}
}































/*String[][] loginData = {
{"admin@yourstore.com","admin","Valid"},
{"admin@yourstore.com","adm","Invalid"},
{"adm@yourstore.com","admin","Invalid"},
{"admi@yourstore.com","admi","Invalid"}*/




















//@DataProvider(name="Logindata12")
//public  String[][] getdata1() 
//{
//	String[][] data = null;
//    try {
//        String filePath = "/Com.Essetials/Datafiles/LoginData.xlsx";
//        InputStream ExcelFileToRead = new FileInputStream(filePath);
//        XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
//        XSSFSheet sheet = wb.getSheet("Sheet1");
//
//        int totalRows = sheet.getPhysicalNumberOfRows();
//        int totalCols = sheet.getRow(0).getPhysicalNumberOfCells();
//        data = new String[totalRows - 1][totalCols];
//
//        for (int i = 1; i < totalRows; i++) {
//            XSSFRow row = sheet.getRow(i);
//            for (int j = 0; j < totalCols; j++) {
//                XSSFCell cell = row.getCell(j);
//                cell.setCellType(CellType.STRING);
//                data[i - 1][j] = cell.getStringCellValue();
//            }
//        }
//        wb.close();
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//    return data;
//}


































//WebElement emailField = driver.findElement(By.xpath("//input[@id=\"Email\"]"));
//emailField.clear();
//Thread.sleep(3000);
//emailField.sendKeys(user);
//
//WebElement passWordField = driver.findElement(By.xpath("//input[@id=\"Password\"]"));
//passWordField.clear();
//Thread.sleep(3000);
//passWordField.sendKeys(password);
//
//WebElement loginBtn = driver.findElement(By.xpath("//button[text()=\"Log in\"]"));
//loginBtn.click();
//
//String expectedTitle = "Dashboard / nopCommerce administration";
//String actualTitle = driver.getTitle();
//
//if(result.equals("Valid"))
//{
//	if(expectedTitle.equals(actualTitle))
//	{
//		driver.findElement(By.xpath("//a[text()=\"Logout\"]")).click();
//		Assert.assertTrue(true,"test is passed");
//	}
//	else 
//	{
//		Assert.assertTrue(false,"test case is failed");
//	}
//}
//else {
//	if(result.equals("Invalid")) 
//	{
//		if(expectedTitle.equals(actualTitle))
//		{
//			Assert.assertTrue(false,"test case is failed");
//		}
//		else 
//		{
//			Assert.assertTrue(true,"test case is failed");
//		}
//	}
//}




































//try {
//	String path1 =".\\Datafiles\\LoginData.xlsx";
//	    Utility utils = new Utility(path1);
//	    int totalrows = utils.getRowCount("Sheet1");
//	    int totalcells = utils.getCellCount("Sheet1", 1);
//	    String[][] loginData = new String[totalrows][totalcells];
//    for(int r=0; r<totalrows; r++)
//    {
//        for(int c=0; c<totalcells; c++)
//        {
//            loginData[r][c]= utils.getCellData("Sheet1", r+1, c);
//        }
//    }
//    return loginData;
//} catch (Exception e) {
//    System.err.println("Error retrieving data from Excel file: " + e.getMessage());
//    throw e;
//}  
