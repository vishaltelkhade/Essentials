package ExtentReport;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import freemarker.core._MarkupBuilder;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportScreenShotLogLevel {

	public static void main(String[] args) {
		
		// EXTENT REPORT SETUP
		long time = System.currentTimeMillis();
	    DateTimeFormatter dateObject = DateTimeFormatter.BASIC_ISO_DATE ;
	    String date = dateObject.format(LocalDate.now());
	    File file = new File (".//ExtentReport//extentReport6");
	    ExtentReports extentReport = new ExtentReports();
	    ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file+""+date+""+time+".html");
	    extentReport.attachReporter(sparkReporter);
	    
	    // LAUCHING BROWSER AND URL
	    ChromeOptions chroOP = new ChromeOptions();
		chroOP.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chroOP);
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		String path = takeScreenShot(driver);
		String base_64= takeScreenShot(driver,"Google HomePage.jpg");
		
		// TEST CREATION AND ATTACHING THE SCREENSHOTS AT LOG LEVEL TO TEST
		extentReport.createTest("ScreenShot Test 2","This is at log level")
		.info("this is info msg")
		.fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		
		extentReport.createTest("ScreenShot Test 3","This is at log level")
		.info("this is info msg")
		.fail(MediaEntityBuilder.createScreenCaptureFromPath(path,"This tilte of ss at log level").build());
		
		extentReport.createTest("ScreenShot Test 4","this is at log level")
		.info("this is info msg")
		.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base_64).build());
		
		extentReport.createTest("ScreenShot Test 5","this is at log level")
		.info("this is info msg")
		.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base_64,"This tilte of ss at log level").build());
	
		Throwable t= new Throwable("this run time exception");
		
		
		extentReport.createTest("ScreenShot Test 6","this is at log level")
		.info("this is info msg")
		.fail(t, MediaEntityBuilder.createScreenCaptureFromBase64String(base_64,"This tilte of ss at log level").build());
	
		
		

		
		
		
		//CLOSING BROWSER AND FLUSHING THE REPORT 
		extentReport.flush();
		driver.quit();
		
		
		
	
	}
	
	    
	
	
	
	public static String takeScreenShot(WebDriver driver, String fileName) 
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		String base64code = ts.getScreenshotAs(OutputType.BASE64);
		return base64code;
	}
	public static String takeScreenShot(WebDriver driver)
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		File target = new File (".//Screenshot//gHome_Page.jpg");
		try {
			FileUtils.copyFile(file, target);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("screeshot saved Successfully");
		return target.getAbsolutePath() ;
	}

}
