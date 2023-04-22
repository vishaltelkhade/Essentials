package ReadConfigure;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Readconfig {

	
		//We have create an Object of Properties class
		
		Properties properties;
		
		//Create a constructor so that as soon as we create an Object of this class this counstructor will invoke

		public  Readconfig()
		{
			properties = new Properties();
			try {
				//to open the file from path
				FileInputStream fis = new FileInputStream(".//Configuration//Config.properties");
			    try {
			    //to load the files keys and value	
					properties.load(fis);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				  e.printStackTrace();
			}
		}
		
		   //to read
		public String getBaseUrl() 
		{
			String url = properties.getProperty("baseurl");
			if(url!=null) {
				return url;
			}
			else
				throw new RuntimeException("url is not specified in configuration.properties file");		
		}
		public String getuserName() 
		{
			String username = properties.getProperty("username");
			if(username!=null) {
				return username;
			}
			else
				throw new RuntimeException("username is not specified in configuration.properties file");		
		}
		public String getPassword() 
		{
			String password = properties.getProperty("password");
			if(password!=null) {
				return password;
			}
			else
				throw new RuntimeException("password is not specified in configuration.properties file");		
		}
		
	

}
