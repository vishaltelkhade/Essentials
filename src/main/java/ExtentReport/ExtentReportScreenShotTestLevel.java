package ExtentReport;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportScreenShotTestLevel {
	public static WebDriver driver;

	public static void main(String[] args) throws IOException 
	{
		
		long time = System.currentTimeMillis();
		DateTimeFormatter dateObject = DateTimeFormatter.BASIC_ISO_DATE;
		String date = dateObject.format(LocalDate.now());
		ExtentReports extentReport = new ExtentReports();
		File file1 = new File(".//ExtentReport//extentreport5");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file1+""+date+""+time+".html");
		extentReport.attachReporter(sparkReporter);
		
		
		
		
		
		
		
		ChromeOptions chroOP = new ChromeOptions();
		chroOP.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chroOP);
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		String Base_64 = takeScreenShot("google.jpg",driver);
		String path = takeScreenShot(driver);
		
	    
		
		     extentReport.createTest("Screenshot test1","screen shot of test1 at test level")
	         .info("this info msg")
	         .addScreenCaptureFromPath(path);
		 
		     extentReport.createTest("Screenshot test2","screen shot of test2 at test level")
		    .info("this info msg")
		    .addScreenCaptureFromPath(path,"Google home page this is title of SS");
	    
		     extentReport.createTest("Screenshot test3","screen shot of test3 at test level")
			 .info("this info msg")
		     .addScreenCaptureFromBase64String(Base_64);

		     extentReport.createTest("Screenshot test4","screen shot of test3 at test level")
			 .info("this info msg")
		     .addScreenCaptureFromBase64String(Base_64,"Google home page this is title of SS");
	    
	    extentReport.flush();
	    driver.quit();
	
	}
	
	public static String takeScreenShot(WebDriver driver) throws IOException 
	{         
		TakesScreenshot ts = (TakesScreenshot)driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		File target = new File("./Screenshot/googlehomePage.jpg");
		FileUtils.copyFile(file, target);
		return target.getAbsolutePath();
		
		
		
	}
	public static String takeScreenShot(String fileName ,WebDriver driver) throws IOException
	{
		 TakesScreenshot ts = (TakesScreenshot)driver;
		 String bASE64code = ts.getScreenshotAs(OutputType.BASE64);
		 byte[]bArr= Base64.getDecoder().decode(bASE64code);
		 FileOutputStream fos = new FileOutputStream(".//Screenshot//"+fileName+"");
		 fos.write(bArr);
		 fos.close();
		 return bASE64code;
	}
	

}
