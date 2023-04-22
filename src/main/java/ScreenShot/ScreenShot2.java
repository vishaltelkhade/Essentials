package ScreenShot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShot2 {
       public static WebDriver driver;
	public static void main(String[] args) throws IOException {
		ChromeOptions chroOP = new ChromeOptions();
		chroOP.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver(chroOP);
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		takeScreenShot();
		driver.findElement(By.xpath("//input[@name=\"q\"]")).sendKeys("dhokla",Keys.ENTER);
		takeScreenShot("google2.jpg");
		
		driver.quit();

	}
	public static void takeScreenShot() throws IOException 
	{
	 TakesScreenshot ts = (TakesScreenshot)	driver;
	 File file = ts.getScreenshotAs(OutputType.FILE);
	 File target = new File(".//Screenshot//google.png");
	 FileUtils.copyFile(file, target);
	 String st2 = target.getAbsolutePath();
	 System.out.println(st2);
	}
	public static FileOutputStream takeScreenShot(String filename) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)	driver;
		 String bASE64code = ts.getScreenshotAs(OutputType.BASE64);
		 byte[]bArr= Base64.getDecoder().decode(bASE64code);
		 FileOutputStream fos = new FileOutputStream(".//Screenshot//"+filename+"");
		 fos.write(bArr);
		 fos.close();
		return fos;
	}

}
