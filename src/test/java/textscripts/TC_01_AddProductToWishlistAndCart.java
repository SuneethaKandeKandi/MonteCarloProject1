package textscripts;
/*
1-launch browser

2-enter application url-https://www.montecarlo.in/
3-click on Login/Signup icon
4-enter email address
5-enter password
6-click on  login
7-verify you are in AccountPage.
8-Mouse over on Home Furnishing
9-click on  AC Comforter
10.click on size and select the size
11-Scroll down click on color and select the colour
12-Scroll down click on brand and select the brand of item
13-Scroll down click on availability and choose in stock
14-Click on any product and click add to wishlist.
15-click on wishlist button
16-verify you are in wishlist page
18-click on add to cart icon
19-verify the item is  added  to cart 
20-close the application.*/

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericlibraries.BaseClass;
import pom.AccountPage;
import pom.AddingProductPage;
import pom.MonteCarloLoginPage;
import pom.MonteCarloSigninPage;
import pom.ProductFilterSelectorPage;
import pom.WishlistPage;

public class TC_01_AddProductToWishlistAndCart extends BaseClass {

	@Test 
	public void addProductToWishlistandCart() throws EncryptedDocumentException, IOException, InterruptedException {
		
		logger.info("Class AddProductToWishlistandCart Started");
		MonteCarloLoginPage loginObj = new MonteCarloLoginPage(driver);
		loginObj.LoginButton();
		
		MonteCarloSigninPage signInObj = new MonteCarloSigninPage(driver); 
		signInObj.enterEmailid(dataUtility.readingDataExcelFile("Sheet1", 1, 1));
		signInObj.enterPassword(dataUtility.readingDataExcelFile("Sheet1", 1, 2));
		signInObj.loginButton();
		
		Assert.assertEquals(driver.getTitle(),dataUtility.readingDataPropertyFile("AccountTitle"));
		logger.info("Account Page is verified");
		
		AccountPage accountObj = new AccountPage(driver);
		WebElement homeFurnish = accountObj.getHomeFurnishing();

		utilities.mouseHover(homeFurnish,driver);
		accountObj.acComforterClick();
		
		ProductFilterSelectorPage filterObj = new ProductFilterSelectorPage(driver);
		filterObj.sizeFilterClick();
		filterObj.selectedSizeClick();
		filterObj.colourClick();
		filterObj.selectedColourClick();
		filterObj.brandclick();
		filterObj.brandCheckboxClick();
		filterObj.availabilityClick();
		filterObj.inStockCheckboxClick();
		filterObj.homeFurninshingProductClick();
		
		logger.info("Product selected");
		
		AddingProductPage productObj = new AddingProductPage(driver);
		productObj.addToWishlistClick();
		productObj.wishlistIconClick();
		
		Assert.assertEquals(driver.getTitle(),dataUtility.readingDataPropertyFile("WishlistTitle"));
		WishlistPage wishListObj = new WishlistPage(driver);
		wishListObj.addToCartInWishlist();
		Assert.assertEquals(driver.getTitle(),dataUtility.readingDataPropertyFile("ShoppingCartTitle"));
		
		logger.info("Class AddProductToWishlistandCart Runned Successfully");
		
	}
	
}
