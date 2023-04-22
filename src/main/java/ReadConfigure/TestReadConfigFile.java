package ReadConfigure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestReadConfigFile {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions chroOP = new ChromeOptions();
		chroOP.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chroOP);
		driver.manage().window().maximize();
		
		Readconfig readconfig= new Readconfig();
		
		driver.get(readconfig.getBaseUrl());
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(readconfig.getuserName());
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(readconfig.getPassword());
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		Thread.sleep(3000);
		driver.quit();
	}

}
