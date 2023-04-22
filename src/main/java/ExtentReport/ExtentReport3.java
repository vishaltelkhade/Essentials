package ExtentReport;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport3 {
 
	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		DateTimeFormatter dateObject = DateTimeFormatter.ISO_DATE;
		String date = dateObject.format(LocalDate.now());
		File file = new File(".//ExtentReport//extentReport3");
		ExtentReports extentReport = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file+""+date+""+time+".html");
		extentReport.attachReporter(sparkReporter);
		
		
		// UNDERSTAND THE LOG LEVEL IN EXTENT_REPORT
		 
		 extentReport
		.createTest("Test9")
		.log(Status.FAIL, "this test is fail")
		.log(Status.SKIP, "this test is skipped")
		.log(Status.WARNING, "this test showing warning")
		.log(Status.PASS, "this test is pass")
		.log(Status.INFO, "this test showing some info");
		 
		 // UDERSTAND THE TERMILOGY OF LOG LEVEL
		 // 1. IF YOU PROVIDE ALL LOG STATUS TO ONE TEST CASE IT MEANS THAT CASE STATUS IS FAIL
		 // 2. IT IS BECAUSE ACORDING TO THE LOG LEVEL FAIL LOG STATUS has highest presidence COMES FIRST
		 // 3 LOG LEVEL 
		          
		          /*   Fail
		           *   Skip
		           *   Warning
		           *   Pass
		           *   Info
		           */       
// YOU PROVIDE WHATEVER SEQUENCE OF LOG IF YOU PROVIDE ALL LOG STATUS IT SHOWS status as FAIL ONLY EX.
		 
		 extentReport
			.createTest("Test10")
			.log(Status.SKIP, "this test is skipped")
			.log(Status.PASS, "this test is pass")
			.log(Status.INFO, "this test showing some info")
		    .log(Status.WARNING, "this test showing warning")
		    .log(Status.FAIL, "this test is fail");
		 
       // IF YOU PROVIDING 
		 /*   
          *   Skip
          *   Warning
          *   Pass
          *   Info
                  STATUS WILL BE SKIPPED
          */   
		 
		 
		// IF YOU PROVIDING 
				 /*   
		          *   
		          *   Warning
		          *   Pass
		          *   Info
		                  STATUS WILL BE WARNING
		          */    
		 
		// IF YOU PROVIDING 
		 /*   
          *   
          *  
          *   Pass
          *   Info
                  STATUS WILL BE PASS
          */    
		 
		 
		// IF YOU PROVIDING 
				 /*   
		          *   
		          *  
		          *   
		          *   Info
		                  STATUS WILL BE  PASS BUT SHOWING ONLY INFO
		          */    
		 
		 
		 
		 //IF YOU PROVIDE
		 
		 /*   Fail
          *   
          *   Warning
          *   
          *   Info
                         STATUS WILL BE FAIL  EXAMPLE
          */       
		 
		 extentReport
		 .createTest("Test 11", "this is test 11")
		 .log(Status.FAIL, "this is fail ")
		 .log(Status.WARNING, "this is showing warnig")
		 .log(Status.INFO, "thsi test is showing info");
		 
		 
 //IF YOU PROVIDE
		 
		 /*   
          *   Info
          *   Pass
          *   
          *   IF YOU GIVE STATUS LIKE THIS LOG STATUS WILL BE PASS
          *   BEACAUSE PASS HAS HIGHEST PRESIDENCE THAN INFO
          */           
		 
		 extentReport
		 .createTest("Test 12", "this is test 12")
		 .log(Status.INFO, "this is INFO ")
		 .log(Status.PASS, "this is pass");
		
		 
		extentReport.flush();	
	}

}
