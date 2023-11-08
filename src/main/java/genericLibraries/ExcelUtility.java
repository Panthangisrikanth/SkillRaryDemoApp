package genericLibraries;


/**
 * This class contains reusable methods to read from excel
 * @author Srikanth
 *
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	private Workbook wb;
	/**
	 * this method is used to initialize excel
	 * @param excelPath 
	 */
	public void excelInitilization(String excelPath) {
		FileInputStream fis =null;
		try {
			 fis =new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb=WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Map<String ,String>  readFromExcel(String sheetName, Object expectedTest){
		Map<String ,String>map=new HashMap<>();
		DataFormatter df=new DataFormatter();
		Sheet sh = wb.getSheet(sheetName);
		for(int i=0;i<=sh.getLastRowNum();i++) {
			if(df.formatCellValue( sh.getRow(i).getCell(1)).equals(expectedTest)) {
				for(int j=i;j<=sh.getLastRowNum();j++) {
					map.put(df.formatCellValue(sh.getRow(j).getCell(2)), df.formatCellValue(sh.getRow(j).getCell(3)));
					if(df.formatCellValue(sh.getRow(j).getCell(2)).contains("###")){
						break;
					}
				}
				break;
			}
		}
		return map;
		
	}
 /**
  * This method is used to update test status in excel	
  * @param sheetName
  * @param expectedTest
  * @param status
  * @param excelpath
  */
public void writToExcel(String sheetName, String expectedTest, String status, String excelpath) {
	  Sheet sh = wb.getSheet(sheetName);
	  for(int i = 0; i <=sh.getLastRowNum() ;i++) {
		  if(sh.getRow(i).getCell(1).getStringCellValue().equals(expectedTest)) {
			  sh.getRow(i).createCell(4).setCellValue(status);
			  break;
		  }
	  }
	  FileOutputStream fos = null;
	  try {
		  fos = new FileOutputStream(excelpath);
	} catch (FileNotFoundException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
	/**
	 * This method is used to Close excel
	 */
	
public void closeExcel() {
	try {
		wb.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
