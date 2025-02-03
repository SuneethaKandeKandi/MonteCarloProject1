package genericlibraries;

import java.util.Properties;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataUtilities {
	
	
	public String readingDataPropertyFile(String data) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(AutoConstant.propertyFilePath));
		return properties.getProperty(data);
	}
	
	public String readingDataExcelFile (String sheetName,int rowNumber,int cellNUmber) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream(AutoConstant.excelFilePath);
		Workbook workbook = WorkbookFactory.create(fis);
		return workbook.getSheet(sheetName).getRow(rowNumber).getCell(cellNUmber).getStringCellValue();
	}

}
