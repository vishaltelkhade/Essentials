package ExtentReport;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportWithDiffConfig {

	public static void main(String[] args) throws IOException 
	{
		        // CREATING THE EXTENT REPORT
				long time = System.currentTimeMillis();
				DateTimeFormatter dateObject = DateTimeFormatter.BASIC_ISO_DATE;
		        String date = dateObject.format(LocalDate.now());
		        ExtentReports extentreport = new ExtentReports();
		        File file = new File("./ExtentReport/extentReport7");
		        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file+""+date+""+time+".html");
		       
		        ExtentSparkReporterConfig config = sparkReporter.config();
		        
		      
		        
		        
		        // ---------------------------USING JAVA-----------------------------

		        // FOR A DARK BLACK THEME
		       // config.setTheme(Theme.DARK);
		        
		        // SET REPORT NAME
		       // config.setReportName("Report Name");
		    
		        // SET DOC TITLE
		      //  config.setDocumentTitle("Doc Title");
		        
		        // SET DATE & TIME STAMP FORMAT
		       // config.setTimeStampFormat("dd-MM-yyyy hh-mm-ss");
		        
		        // SET THE CSS
		        
		        // SET THE JAVASCRIPT
		        
		       
		        
		        
		        
		        
		        //--------------------USING JSON CONFIG FILE----------------------
		        
		        //sparkReporter.loadJSONConfig(new File("./Configuration/extent-report-config.json"));
		        
		        //--------------------USING XML CONFIG FILE----------------------
		        
		         sparkReporter.loadXMLConfig(new File("./Configuration/extent-report-config.xml"));
		        
		       
		        
		        
		        
		        
		        extentreport.attachReporter(sparkReporter);
		        
		        
		        
		        
		       
		        //creation of test
				
				ExtentTest test2 = extentreport.createTest("Test2");
				ExtentTest test3 = extentreport.createTest("Test3");
				ExtentTest test4 = extentreport.createTest("Test4");
				ExtentTest test5 = extentreport.createTest("Test5");
				ExtentTest test6 = extentreport.createTest("Test6");
		        // CREATING TEST
		        
		        test2.pass("Test2 is pass");
				test3.fail("Test3 is fail");
				test4.skip("Test4 is skip");
				test5.info("it is pass and info of test 5");
				test6.warning("Test6 is giving warning");
				
				ExtentTest test7= extentreport.createTest("Test7");
				test7.log(Status.FAIL, "this is failed");
				ExtentTest test8 = extentreport.createTest("Test8");
				test8.skip("This is skipped");
				
				
				extentreport.flush();


	}

}
