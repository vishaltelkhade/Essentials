package ReadDataFromXl;

import java.io.IOException;

public class demo 
    {

	public static void main(String[] args) throws IOException {
		
		getData();
	}
	public static String[][] getData() throws IOException 
	{
		String path1 ="/Com.Essetials/Datafiles/LoginData.xlsx";
		Utility utils = new Utility(path1);
		int totalrows = utils.getRowCount("Sheet1");
		int totalcells = utils.getCellCount("Sheet1", 1);
		String[][] loginData = new String[totalrows][totalcells];
		
		for(int r=1; r<=totalrows; r++)
		{
			for(int c=0; c<totalcells; c++)
			{
				loginData[r-1][c]= utils.getCellData("Sheet1", r, c);
			}
		}
		
		return loginData;
    }

}
