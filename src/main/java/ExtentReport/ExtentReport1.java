package ExtentReport;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport1 {

	public static void main(String[] args) throws IOException {
		ExtentReports extentreport = new ExtentReports();
     	long time = System.currentTimeMillis();
		DateTimeFormatter format_Object= DateTimeFormatter.ISO_DATE;
		String DateObject = format_Object.format(LocalDate.now());
		File file = new File(".//ExtentReport//extentReport");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file+" "+DateObject+"___"+time+".html");
        extentreport.attachReporter(sparkReporter);
        extentreport.flush();
        //Desktop.getDesktop().browse(new File(".//ExtentReport//extentReport1.html").toURI());
	}

}
