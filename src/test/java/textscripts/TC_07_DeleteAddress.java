package textscripts;

/*1)Open Browser.
2)maximize the browser
3)Enter url
4)Click on Login/Signup.
5)Enter username and password.
6)Click on Login.
7)Verify whether you are on Account page.
8)Click on addresses.
9)Click on delete default address.                                      
10)verify the address is deleted                              
11)close the window.*/

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericlibraries.BaseClass;
import pom.AccountPage;
import pom.AddressPage;
import pom.MonteCarloLoginPage;
import pom.MonteCarloSigninPage;

public class TC_07_DeleteAddress extends BaseClass{
	@Test
	public void deletingAddress() throws EncryptedDocumentException, IOException, InterruptedException {
		MonteCarloLoginPage loginObj = new MonteCarloLoginPage(driver);
		loginObj.LoginButton();
		
		MonteCarloSigninPage signInObj = new MonteCarloSigninPage(driver); 
		signInObj.enterEmailid(dataUtility.readingDataExcelFile("Sheet1", 1, 1));
		signInObj.enterPassword(dataUtility.readingDataExcelFile("Sheet1", 1, 2));
		signInObj.loginButton();
		logger.info("Signed into application Successfully");
		
		logger.info(driver.getTitle());
		Assert.assertEquals(driver.getTitle(),dataUtility.readingDataPropertyFile("AccountTitle"));
		
		AccountPage addressObj = new AccountPage(driver);
		addressObj.addressIconClick();
		AddressPage newAddress = new AddressPage(driver);
		
		newAddress.defaultDeleteClick();
		logger.info("Address deleted Successfully");
		driver.switchTo().alert().accept();		
		logger.info("class deletingAddress ran Successfully");
}
}