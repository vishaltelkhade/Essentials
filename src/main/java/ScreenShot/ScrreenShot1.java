package ScreenShot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrreenShot1 {
    public static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		
		
		
	//	long time = System.currentTimeMillis();
//		DateTimeFormatter dateObject = DateTimeFormatter.BASIC_ISO_DATE;
//		String date = dateObject.format(LocalDate.now());
		ExtentReports extentReport = new ExtentReports();
		//File file1 = new File(".//ExtentReport//extentreport5");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(new File(".//ExtentReport//extentreport5"));
		extentReport.attachReporter(sparkReporter);
		
		
		
		
		
		
		
		
		
		
		ChromeOptions chroOP = new ChromeOptions();
		chroOP.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chroOP);
		driver.manage().window().maximize();
		//takeScreenShot("Google.jpg");
	    driver.get("https://www.google.com/");
	   // takeScreenShot();
	    String bASE64 = takeScreenShot();
	    
	    extentReport.createTest("Test1", " ScreeShot At test level")
	    .info("this is info msg")
	    .addScreenCaptureFromBase64String(bASE64,"This is Google HomePage");
	    
	    
	    
	   extentReport.flush();
	    driver.quit();
	} 
	public static String takeScreenShot() {
		 TakesScreenshot takesScreenShot = (TakesScreenshot)driver;
		 String src = takesScreenShot.getScreenshotAs(OutputType.BASE64);
		 return src;
	}
	

}
