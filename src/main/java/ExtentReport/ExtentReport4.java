package ExtentReport;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport4 {

	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		DateTimeFormatter dateObject = DateTimeFormatter.BASIC_ISO_DATE;
		String date = dateObject.format(LocalDate.now());
		File file = new File (".//ExtentReport//extentReport4");
		ExtentReports extentReport = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file+""+date+""+time+".html");
		extentReport.attachReporter(sparkReporter);

		// LOG DIFFERENT TYPE OF INFORMATION TO THE EXTENT REPORT
		//TEXT-BOLD, ITALIC
		extentReport
		.createTest("text based test")
		.log(Status.INFO, "normal info1")
		.log(Status.INFO,"<b>info2</b>")
		.log(Status.INFO,"<i>info3</i>")
		.log(Status.INFO,"<b><i>info4</i></b>");
	   
		// COLLECTION DATA (LIST ,SET & MAP)
		List<String> list = new ArrayList();
		//details
		list.add("Vishal");
		list.add("Sumit");
		list.add("Saloni");
		
		Map<Integer, String> map = new HashMap();
		//details
		map.put(101, "vishal");
		map.put(102, "saloni");
		map.put(103, "sumit");
		
		
		Set<Integer> set = map.keySet();
		
		
		// ordered deatails list (bullet format)
		//using .info(MarkupHelper.createOrderedList(list));
		
		
		 extentReport
		.createTest("List based Test")
		.info(MarkupHelper.createOrderedList(list)); //details in ordered means number order
		  
		 extentReport
		 .createTest("Map based Test")
		 .info(MarkupHelper.createOrderedList(map)); //same
		 
		 extentReport
		 .createTest("set based Test")
		 .info(MarkupHelper.createOrderedList(set)); //same
		
		 // Unordered deatails list (bullet format)
		 // Using .info(MarkupHelper.createUnorderedList(list));
		 
		     extentReport
			.createTest("List based unOrdered Test")
			.info(MarkupHelper.createUnorderedList(list)); //details in Unordered means bullet format
			  
			 extentReport
			 .createTest("Map based unOrdered Test")
			 .info(MarkupHelper.createUnorderedList(map)); //same
			 
			 extentReport
			 .createTest("set based unOrdered Test")
			 .info(MarkupHelper.createUnorderedList(set)); //same
			 
			 
	  // HIGHLIGHT ANY MASSAGE
	  //using .info(MarkupHelper.createLabel("this is highlighted massage", ExtentColor.GREEN));	 
	  // using MarkUpHelper class and method from that class createLabel 
	  // and in argument of Status we have to use Enum class called ExtentColor
	  // for example ExtentColor.GREEN	 
			 extentReport.createTest("HighLight Based Test")
			 .info(MarkupHelper.createLabel("this is highlighted massage", ExtentColor.GREEN));
			 
			 extentReport.createTest("HighLight Based Test2")
			 .fail(MarkupHelper.createLabel("this is highlighted massage for failed Test case", ExtentColor.RED));
		    
		// EXCEPTION
			 
			 try {
				int i = 5/0;
			} catch (Exception e) {
				extentReport
				.createTest("This is Exception Test1")
				.info(e);
			}
			 
			 //Or
			 
			 Throwable t = new RuntimeException("This is custom runtime exception");
			 extentReport
			 .createTest("This is Exception Test2")
			 .info(t);
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 extentReport.flush();
		
		
		
	}
}
