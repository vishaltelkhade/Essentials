package ExtentReport;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportGenratingMultipleReports {

	public static void main(String[] args) {
//		long time = System.currentTimeMillis();
//		DateTimeFormatter timeObject = DateTimeFormatter.BASIC_ISO_DATE;
//		String date = timeObject.format(LocalDate.now());
		//File file = new File("./ExtentReport.html");
		ExtentReports extentreport = new ExtentReports();
		ExtentSparkReporter all_Testcases_saprkReport = new ExtentSparkReporter("./ExtentReport/All_TestCases.html");
		
		ExtentSparkReporter all_Failed_saprkReport = new ExtentSparkReporter("./ExtentReport/Failed_TestCases.html");
		all_Failed_saprkReport.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
		
		ExtentSparkReporter all_SkippedAndWarning_saprkReport = new ExtentSparkReporter("./ExtentReport/SkippedAndWarning_TestCases.html");
		all_SkippedAndWarning_saprkReport.filter().statusFilter().as
		(new Status[] 
				{Status.SKIP,
				Status.WARNING
				}).apply();
		extentreport.attachReporter(all_Testcases_saprkReport,all_Failed_saprkReport,all_SkippedAndWarning_saprkReport);
		
		
		
		extentreport.createTest("Test1")
		.fail("this is failed test case");
		
		extentreport.createTest("Test2")
		.pass("this is pass test case");
		
		extentreport.createTest("Test3")
		.warning("this is warning test case");
		
		extentreport.createTest("Test4")
		.skip("this is skipped test case");
		
		extentreport.createTest("Test5")
		.fail("this is failed test case");
		
		extentreport.createTest("Test6")
		.fail("this is failed test case");
		
		extentreport.createTest("Test7")
		.pass("this is pass test case");
		
		extentreport.createTest("Test8")
		.warning("this is warning test case");
		
		extentreport.createTest("Test9")
		.skip("this is skipped test case");
		
		extentreport.createTest("Test10")
		.fail("this is failed test case");
		
		extentreport.createTest("Test11")
		.fail("this is failed test case");
		
		extentreport.createTest("Test12")
		.pass("this is failed test case");
		
		extentreport.createTest("Test13")
		.warning("this is failed test case");
		
		extentreport.createTest("Test14")
		.pass("this is pass test case");
		
		extentreport.createTest("Test15")
		.warning("this is warning test case");
		
		extentreport.createTest("Test16")
		.skip("this is skipped test case");
		
		extentreport.flush();
		
	}

}
