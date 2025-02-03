package textscripts;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericlibraries.BaseClass;
import pom.AccountPage;
import pom.AddingProductPage;
import pom.FindStorePage;
import pom.MonteCarloLoginPage;
import pom.MonteCarloSigninPage;
import pom.MonteCarloWebHomePage;
import pom.ProductFilterSelectorPage;

public class CheckingManufacturerPincode extends BaseClass {

	@Test
	public void manufacturerPincodeChecking() throws EncryptedDocumentException, IOException, InterruptedException {
		String pincode="141010";

		MonteCarloLoginPage loginObj = new MonteCarloLoginPage(driver);
		loginObj.LoginButton();
		
		MonteCarloSigninPage signInObj = new MonteCarloSigninPage(driver); 
		signInObj.enterEmailid(dataUtility.readingDataExcelFile("Sheet1", 1, 1));
		signInObj.enterPassword(dataUtility.readingDataExcelFile("Sheet1", 1, 2));
		signInObj.loginButton();
		
		Assert.assertEquals(driver.getTitle(),dataUtility.readingDataPropertyFile("AccountTitle"));
		
		AccountPage accountObj = new AccountPage(driver);
		accountObj.monteCarloHomeClick();
		
		MonteCarloWebHomePage homeObj = new MonteCarloWebHomePage(driver);
		homeObj.shopBlanketsClick();
		
		ProductFilterSelectorPage filterObj = new ProductFilterSelectorPage(driver);
		filterObj.selectProductClick();
		
		AddingProductPage productObj = new AddingProductPage(driver);
		productObj.productDetailsDescriptionClick();
		productObj.ourStoresClick();
		
		FindStorePage storeObj = new FindStorePage(driver);
		storeObj.searchTextBox(pincode);
		storeObj.getDirecionClick();
		Thread.sleep(2000);

		
}
}
