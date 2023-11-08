package genericLibraries;
/**
 * This class contains reusable methods to read data from properties file 
 * @author Srikanth
 *
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {
	private Properties property;
	/**
	 * This method is used to initialize properties file  
	 * @param filePath
	 */
	public void propertiesInitilization(String filePath) {
		FileInputStream fis =null;
		try {
			fis =new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		property=new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * this method is used to fetch data from properties file
	 * @param key
	 * @return
	 */
	public String readFromProperties(String key) {
		return property.getProperty(key);
	}

}