package ExtentReport;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.observer.ExtentObserver;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportScreenshot2 {
	 
	public static void main(String[] args) {
		   //Create ExtentSparkReporter and attach it to ExtentReports
		 ExtentObserver spark = new ExtentSparkReporter("extent-report.html");
	     ExtentReports extent = new ExtentReports();
	     extent.attachReporter(spark);

        //Create a test
        ExtentTest test = extent.createTest("MyTest", "Test Description");

        //Initialize the WebDriver
        ChromeOptions chroOP = new ChromeOptions();
		chroOP.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chroOP);

        //Navigate to the URL
        driver.get("https://www.google.com");

        //Take a screenshot as Base64String and attach it to the report
        String base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        test.addScreenCaptureFromBase64String(base64Screenshot);

        //Take a screenshot and attach it to the report
        String screenshotPath = System.getProperty("user.dir") + "/screenshot.png";
        ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE).renameTo(new File(screenshotPath));
        test.addScreenCaptureFromPath(screenshotPath);

        //Log a message with status
        test.log(Status.PASS, MarkupHelper.createLabel("Test Passed", ExtentColor.GREEN));

        //Close the WebDriver
        driver.quit();

        //Flush the report
        extent.flush();

	}

}
