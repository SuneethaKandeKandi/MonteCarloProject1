package textscripts;
/*1.Open the browser
2.Maximize the browser
3.Enter the url                                                             
4.click on signin
5.Enter the username
6..Enter the password
7..click on login
8..click on search bar and search for women hooded jackets                                            
9.click on view all results
10.click on any product
11.select the size
12.Increase the quantity to 2
13.Add the product to cart
14.intiate checkout
15.close the application.*/

import java.io.IOException;



import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericlibraries.BaseClass;
import pom.AccountPage;
import pom.AddingProductPage;
import pom.MonteCarloLoginPage;
import pom.MonteCarloSigninPage;
import pom.ProductFilterSelectorPage;

public class TC_04_InitializingCheckout extends BaseClass {

	@Test
	public void Initalize() throws EncryptedDocumentException, IOException {
		logger.info("class InitializingCheckout started");
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

		accountObj.searchClick();
		accountObj.searchTextBoxclick(dataUtility.readingDataPropertyFile("WomenHoodedJacket"));
		accountObj.viewAllResultsClick();
		logger.info("view all results button clicked");
		
		ProductFilterSelectorPage productObj = new ProductFilterSelectorPage(driver);
		productObj.womenProductClick();
		
		AddingProductPage addProductObj = new AddingProductPage(driver);
		addProductObj.sizeInProductPageClick();
		addProductObj.increaseQuantityClick();
		addProductObj.addtoCartClick();
		addProductObj.checkoutButtonClick();
		
		logger.info("class InitializingCheckout ran successfully");
	}
}
