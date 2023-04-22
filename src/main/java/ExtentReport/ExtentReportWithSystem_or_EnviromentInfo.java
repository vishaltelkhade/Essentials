package ExtentReport;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportWithSystem_or_EnviromentInfo {

	public static void main(String[] args) {
		
		
		
		// CREATING THE EXTENT REPORT
		long time = System.currentTimeMillis();
		DateTimeFormatter dateObject = DateTimeFormatter.BASIC_ISO_DATE;
        String date = dateObject.format(LocalDate.now());
        ExtentReports extentreport = new ExtentReports();
        File file = new File("./ExtentReport/extentReport7");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file+""+date+""+time+".html");
        // FOR A DARK BLACK THEME
        sparkReporter.config().setTheme(Theme.DARK);
        extentreport.attachReporter(sparkReporter);
        
        // LAUNCHING BROWSER 
        ChromeOptions chroOP = new ChromeOptions();
		chroOP.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chroOP);
		// TO KNOW THE BROWSER VERSION AND NAME
		Capabilities capabilities = ((RemoteWebDriver)driver).getCapabilities();
	    //System.out.println(capabilities.getBrowserName());
		//System.out.println(capabilities.getBrowserVersion());
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		String base64 = takesScreenShot(driver,"Google HomePage.png");
		String path = takesScreenShot(driver);
		
		
        
        
        // ENVIRONMENT OR SYSTEM INFORMATION/PROPERTIES ATTCHING TO EXTENT REPORT 
        extentreport.setSystemInfo("OS",System.getProperty("os.name"));
        extentreport.setSystemInfo("Java version",System.getProperty("java.version"));
        extentreport.setSystemInfo("Browser",capabilities.getBrowserName()+"   "+capabilities.getBrowserVersion());
                                              
                                              //USE THIS INFO FROM CONFIG FILE DONT HARDCODE
        extentreport.setSystemInfo("App url", "www.google.com");
        extentreport.setSystemInfo("username", "vishal@gmail.com");
        extentreport.setSystemInfo("password", "vishal@123");
        
		
		//CREATING TEST TO ATTACHED SCREENSHOT AT BOTH LEVEL(TEST & LOG)
		
		// 1 ATTACHING SS AT TEST LEVEL  and PROVIDING DIFFERENT ATTRIBUTES
		
		extentreport.createTest("Test 1","This is screenshot test")
		.info("this is the ifo msg")
		.assignAuthor("SUMIT","VISHAL")
		.assignCategory("SMOKE")
		.assignDevice("CHROME")
		.addScreenCaptureFromPath(path);
		
		extentreport.createTest("Test 2","This is screenshot test")
		.info("this is the ifo msg")
		.assignAuthor("SUMIT","VISHAL")
		.assignCategory("SANITY")
		.assignDevice("CHROME")
		.addScreenCaptureFromPath(path,"This is title of Screen Shot at test level");
		
		extentreport.createTest("Test 3","This is screenshot test")
		.info("this is the ifo msg")
		.assignAuthor("SUMIT","AKHILESH")
		.assignCategory("SMOKE")
		.assignDevice("CHROME")
		.addScreenCaptureFromBase64String(base64);
		
		extentreport.createTest("Test 4","This is screenshot test")
		.info("this is the ifo msg")
		.assignAuthor("SUMIT","AKHILESH")
		.assignCategory("SANITY")
		.assignDevice("CHROME")
		.addScreenCaptureFromBase64String(base64,"this is title of the Screenshot at test level");
		
		// 2 ATACHING SS AT LOG LEVEL and PROVIDING DIFFERENT ATTRIBUTES
		
		extentreport.createTest("Test 5","This is screenshot test")
		.info("this is the ifo msg")
		.assignAuthor("SUMIT","AKSHAY")
		.assignCategory("SMOKE")
		.assignDevice("CHROME")
		.fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		
		extentreport.createTest("Test 6","This is screenshot test")
		.info("this is the ifo msg")
		.assignAuthor("SUMIT","AKSHAY")
		.assignCategory("SANITY")
		.assignDevice("CHROME")
		.fail(MediaEntityBuilder.createScreenCaptureFromPath(path, "This is Title of ss at log level").build());
		
		extentreport.createTest("Test 7", "This is a screenShot of skipped test")
		.assignAuthor("SUMIT","AKHILESH","VISHAL","SALONI")
		.assignCategory("SMOKE")
		.assignDevice("CHROME","FIREFOX")
		.skip(MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());
		
		extentreport.createTest("Test 8", "This is a screenShot of skipped test")
		.assignAuthor("SUMIT","AKHILESH","VISHAL","SALONI")
		.assignCategory("SANITY")
		.assignDevice("CHROME","EDGE")
		.skip(MediaEntityBuilder.createScreenCaptureFromBase64String(base64,"This is Title of ss of skipped test at log level").build());
		
		extentreport.flush();
		driver.quit();
		
		
		
		
	}
       public static String takesScreenShot(WebDriver driver) 
       {
    	  TakesScreenshot ts = (TakesScreenshot)driver ;
    	  File file = ts.getScreenshotAs(OutputType.FILE);
    	  File target = new File("./Screenshot/gHomepage.jpeg");
    	  try {
			FileUtils.copyFile(file, target);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  System.out.println("screenshot saved sucessfully");
    	  return target.getAbsolutePath();
       }
       public static String takesScreenShot(WebDriver driver, String fileName) 
       {
    	   TakesScreenshot ts = (TakesScreenshot)driver;
    	   String base64_code = ts.getScreenshotAs(OutputType.BASE64);
    	   return base64_code;
       }
}
