package ExtentReport;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport2 {
	// how to add Test in extent report
	// by default status of Test is pass in Extent report
	//how to Add Status of test in extent reports
	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		DateTimeFormatter dateObject = DateTimeFormatter.ISO_DATE;
		String date = dateObject.format(LocalDate.now());
		File file = new File(".//ExtentReport//extentreport2");
		ExtentReports extentReport = new ExtentReports();
		ExtentSparkReporter spartReporter = new ExtentSparkReporter(file + "" + date + "" + time + ".html");
		extentReport.attachReporter(spartReporter);
		extentReport.createTest("Test 1");
		
		//creation of test
		
		ExtentTest test2 = extentReport.createTest("Test2");
		ExtentTest test3 = extentReport.createTest("Test3");
		ExtentTest test4 = extentReport.createTest("Test4");
		ExtentTest test5 = extentReport.createTest("Test5");
		ExtentTest test6 = extentReport.createTest("Test6");
		
		//status of test
		//way of giving log status to test
		test2.pass("Test2 is pass");
		test3.fail("Test3 is fail");
		test4.skip("Test4 is skip");
		test5.info("it is pass and info of test 5");
		test6.warning("Test6 is giving warning");
		
		ExtentTest test7= extentReport.createTest("Test7");
		test7.log(Status.FAIL, "this is failed");
		ExtentTest test8 = extentReport.createTest("Test8");
		test8.skip("This is skipped");
		
		
		extentReport.flush();

	}

}
