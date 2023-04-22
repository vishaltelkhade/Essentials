package DataDriven1;

import java.io.FileNotFoundException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadData {
    public static WebDriver driver;
	@SuppressWarnings("deprecation")
	@BeforeClass
	public void setup() 
	{
		ChromeOptions chroOP = new ChromeOptions();
		chroOP.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chroOP);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Thread.sleep(3000);
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		//Thread.sleep(3000);
	}
	@Test(dataProvider="lData")
	public void logintest(String user, String password, String result)
	{
		System.out.println(user+""+password+""+result);
	}
	@DataProvider(name="lData")
	public String[][] testData() throws FileNotFoundException
	{
		String path ="./Datafiles/LoginData";
		utilityForXL ulf = new utilityForXL(path);
		int totalRows = ulf.getRowCount("Sheet1");
		int totalCells = ulf.getCellCount("Sheet1", 1);
		String[][] logData = new String[totalRows][totalCells];
		for(int r=1; r<=totalRows; r++)
		{
			for(int c=0; c<totalCells; c++)
			{
				logData[r-1][c]=ulf.getCellData("Sheet1", r, c);
			}
		}
		return logData;
	}
	
	
	public void teaDown()
	{
		driver.close();
	}

}
