package DataDriven1;

import java.io.FileNotFoundException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class demo2 {

	
	@Test(dataProvider="lData")
	public void logintest(String user, String password, String result)
	{
		System.out.println(user+""+password+""+result);
	}
	@DataProvider(name="lData")
	public String[][] testData() throws FileNotFoundException
	{
		String path ="./Datafiles/LoginData";
		utilityForXL ulf = new utilityForXL(path);
		int totalRows = ulf.getRowCount("Sheet1");
		int totalCells = ulf.getCellCount("Sheet1", 1);
		String[][] logData = new String[totalRows][totalCells];
		for(int r=1; r<=totalRows; r++)
		{
			for(int c=0; c<totalCells; c++)
			{
				logData[r-1][c]=ulf.getCellData("Sheet1", r, c);
			}
		}
		return logData;
	}

}
