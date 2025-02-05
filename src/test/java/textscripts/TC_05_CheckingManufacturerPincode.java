package textscripts;

/*
 * 1) open browser
2) enter url https://www.montecarlo.in/
3) click on login/signup btn 
4) Enter Email
5) Enter Password
6) click on login btn
7) verify you are in profile page
8) click on monte carlo home link it will redirect you "Homes by Monte Carlo"
9) scroll down till shop blankets btn element and click shop blankets button
10) Select the product and click on that product
11) it will redirect you that product page and then click on product details & description
12) get the manufacture address text
13) scroll to end then you will find link Our Stores and then click on it.
14) verify your page through title  that you are in our stores page
15) you will find search box you can search (by city,state or zip) then send keys zip code 
16) you will find store located in that location in that pincode
17) click on getDirections btn that is visible on the store card
18) it should navigates you google map.                                                                                 19)Close the application.
 */
import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
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

public class TC_05_CheckingManufacturerPincode extends BaseClass {

	@Test
	public void manufacturerPincodeChecking() throws EncryptedDocumentException, IOException, InterruptedException {
		String pincode="141010";
		logger.info("Class manufacturerPincodeChecking Started");

		MonteCarloLoginPage loginObj = new MonteCarloLoginPage(driver);
		loginObj.LoginButton();
		
		MonteCarloSigninPage signInObj = new MonteCarloSigninPage(driver); 
		signInObj.enterEmailid(dataUtility.readingDataExcelFile("Sheet1", 1, 1));
		signInObj.enterPassword(dataUtility.readingDataExcelFile("Sheet1", 1, 2));
		signInObj.loginButton();
		logger.info("Successfully logged into MonteCarlo");

		
		Assert.assertEquals(driver.getTitle(),dataUtility.readingDataPropertyFile("AccountTitle"));
		logger.info("Account Page is verified");
		
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
		WebElement element = storeObj.getGetDirecion();
		
		utilities.waitElementClick(element);
		
		logger.info("The ManufacturerPincodeChecking class ran successfully.");
}
}
