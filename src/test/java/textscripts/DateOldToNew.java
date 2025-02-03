package textscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genericlibraries.BaseClass;
import pom.AccountPage;
import pom.AddingProductPage;
import pom.MonteCarloLoginPage;
import pom.MonteCarloSigninPage;
import pom.ProductFilterSelectorPage;

/*1.Open the browser
2.Maximize the browser                     
3.Enter the Url
4.Click on Login
5.Enter Username and password
6.Verify the homepage 
7.Click on cart
8.Click on start Shopping
9.Select Filters : Date Old to New
10.Click on the Product
11.Click on add to cart
12.Click on Close Button.*/


public class DateOldToNew extends BaseClass {
	
	@Test
	public void filterOldToNew() throws EncryptedDocumentException, IOException, InterruptedException {
		MonteCarloLoginPage loginObj = new MonteCarloLoginPage(driver);
		ProductFilterSelectorPage filterObj = new ProductFilterSelectorPage(driver);
		AddingProductPage addingProductPageObj = new AddingProductPage(driver);
		loginObj.LoginButton();
		AccountPage accountPageObj = new AccountPage(driver);
		
		MonteCarloSigninPage signInObj = new MonteCarloSigninPage(driver); 
		signInObj.enterEmailid(dataUtility.readingDataExcelFile("Sheet1", 1, 1));
		signInObj.enterPassword(dataUtility.readingDataExcelFile("Sheet1", 1, 2));
		signInObj.loginButton();
		
		accountPageObj.cartIconClick();
		accountPageObj.startShopingButtonClick();
		filterObj.bestSellingClick();
		filterObj.dateOldToNewClick();

		filterObj.productOldToNewClick();
		
		addingProductPageObj.addtoCartClick();
		Thread.sleep(2000);

		addingProductPageObj.closeButtonClick();

		
	}

}
