package textscripts;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericlibraries.BaseClass;
import pom.AccountPage;
import pom.AddressPage;
import pom.MonteCarloLoginPage;
import pom.MonteCarloSigninPage;

public class DeleteAddress extends BaseClass{
	@Test
	public void deletingAddress() throws EncryptedDocumentException, IOException, InterruptedException {
		MonteCarloLoginPage loginObj = new MonteCarloLoginPage(driver);
		loginObj.LoginButton();
		
		MonteCarloSigninPage signInObj = new MonteCarloSigninPage(driver); 
		signInObj.enterEmailid(dataUtility.readingDataExcelFile("Sheet1", 1, 1));
		signInObj.enterPassword(dataUtility.readingDataExcelFile("Sheet1", 1, 2));
		signInObj.loginButton();
		
		Assert.assertEquals(driver.getTitle(),dataUtility.readingDataPropertyFile("AccountTitle"));
		
		AccountPage addressObj = new AccountPage(driver);
		addressObj.addressIconClick();
		AddressPage newAddress = new AddressPage(driver);
		
	/*	WebElement element = newAddress.getDefaultAddress();
		utilities.mouseHover(element, driver);*/
		
		newAddress.defaultDeleteClick();
		
		Thread.sleep(3000);
		driver.switchTo().alert().accept();		
		
}
}