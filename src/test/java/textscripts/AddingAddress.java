package textscripts;
/*
1)Open Browser.
2)maximize the browser
3)Enter url
4)Click on Login/Signup.
5)Enter username and password.
6)Click on Login.
7)Verify whether you are on Account page.
8)Click on addresses.
9)Click on add a new address.
10)Enter all the details
11)Click on Set it as default address.
12)Click on add a new address.
13)Verify weather the new address is added or not.
14)close the Window.*/

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import genericlibraries.BaseClass;
import pom.AccountPage;
import pom.AddressPage;
import pom.MonteCarloLoginPage;
import pom.MonteCarloSigninPage;

public class AddingAddress extends BaseClass {

    @Test	
	public void addingAddress() throws EncryptedDocumentException, IOException, InterruptedException {
    	logger.info("Adding address started");
    	
    	MonteCarloLoginPage loginObj = new MonteCarloLoginPage(driver);
		loginObj.LoginButton();
		
		MonteCarloSigninPage signInObj = new MonteCarloSigninPage(driver); 
		signInObj.enterEmailid(dataUtility.readingDataExcelFile("Sheet1", 1, 1));
		signInObj.enterPassword(dataUtility.readingDataExcelFile("Sheet1", 1, 2));
		signInObj.loginButton();
		logger.info("Logged into appliaction");

		Assert.assertEquals(driver.getTitle(),dataUtility.readingDataPropertyFile("AccountTitle"));
		
		AccountPage addressObj = new AccountPage(driver);
		addressObj.addressIconClick();
		
		AddressPage newAddress = new AddressPage(driver);
		newAddress.addNewAddressClick();
		
		newAddress.firstName(dataUtility.readingDataPropertyFile("FirstName"));
		newAddress.lastName(dataUtility.readingDataPropertyFile("Lastname"));
		newAddress.companyName(dataUtility.readingDataPropertyFile("Company"));
		newAddress.phoneNumber(dataUtility.readingDataPropertyFile("PhoneNumber"));
		newAddress.address1(dataUtility.readingDataPropertyFile("Address1"));
		
		utilities.dropDown(newAddress.getAddressNewProvince(),"Andhra Pradesh");
		newAddress.addresscheckBoxClick();
		newAddress.newAddressButtonClick();		
		
    }
}
