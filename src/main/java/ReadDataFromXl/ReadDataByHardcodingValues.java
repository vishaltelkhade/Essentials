package ReadDataFromXl;

import java.util.concurrent.TimeUnit;

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

public class ReadDataByHardcodingValues {

	public static WebDriver driver;

	@SuppressWarnings("deprecation")
	@BeforeClass
	public static void setup() throws InterruptedException 
	{
		ChromeOptions chroOP = new ChromeOptions();
		chroOP.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chroOP);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		Thread.sleep(3000);
	}

	@Test(dataProvider="LoginData")
	public void logInTest(String user, String password, String result) throws InterruptedException {
		WebElement emailField = driver.findElement(By.xpath("//input[@id=\"Email\"]"));
		emailField.clear();
		Thread.sleep(3000);
		emailField.sendKeys(user);

		WebElement passWordField = driver.findElement(By.xpath("//input[@id=\"Password\"]"));
		passWordField.clear();
		Thread.sleep(3000);
		passWordField.sendKeys(password);
		WebElement loginBtn = driver.findElement(By.xpath("//button[text()=\"Log in\"]"));
		loginBtn.click();
		
		String expectedTitle = "Dashboard / nopCommerce administration";
		String actualTitle = driver.getTitle();
		
		if(result.equals("Valid"))
		{
			if(expectedTitle.equals(actualTitle))
			{
				driver.findElement(By.xpath("//a[text()=\"Logout\"]")).click();
				Assert.assertTrue(true,"test is passed");
			}
			else 
			{
				Assert.assertTrue(false,"test case is failed");
			}
		}
		else {
			if(result.equals("Invalid")) 
			{
				if(expectedTitle.equals(actualTitle))
				{
					Assert.assertTrue(false,"test case is failed");
				}
				else 
				{
					Assert.assertTrue(true,"test case is failed");
				}
			}
		}
	}
	

	@DataProvider(name="LoginData")
	public String[][] getData()
	{
		String[][] loginTestData = 
			{
					{"admin@yourstore.com","admin","Valid"},
					{"admin@yourstore.com","adm","Invalid"},
					{"adm@yourstore.com","admin","Invalid"},
					{"admi@yourstore.com","admi","Invalid"}
		    };
		return loginTestData;
	}

	@AfterClass
	public static void tearDown() {
		driver.close();
	}

}
