package genericlibraries;

import java.io.IOException;



import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;


@Listeners (Listener1.class)
public class BaseClass {
	
	public Logger logger;
	
	public static WebDriver driver;
	public DataUtilities dataUtility = new DataUtilities();
    public WebDriverUtilities utilities = new WebDriverUtilities();
    
	@BeforeMethod
	public void openApp() throws EncryptedDocumentException, IOException
	{
		logger = LogManager.getLogger(this.getClass());
		logger.info("TestCase Started Running");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(dataUtility.readingDataExcelFile("Sheet1", 1, 0)); // extract data from excel file from Baseclass
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}
	
	@AfterMethod
	public void closeApp() 
	{
		driver.quit();
	}
	
	
}
