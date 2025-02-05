package textscripts;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;
import pom.AccountPage;
import pom.AddingProductPage;
import pom.MonteCarloLoginPage;
import pom.MonteCarloSigninPage;
import pom.WishlistPage;

public class TC_02_AddingAndRemovingProductFromWishlist extends BaseClass {
	
	@Test
	public void addingRemovingProductFromWishlist() throws EncryptedDocumentException, IOException, InterruptedException {
		
		logger.info("Adding and RemovingProduct From Wishlist started");
		AccountPage accountObj = new AccountPage(driver);
		AddingProductPage addingProductObj = new AddingProductPage(driver);
		WishlistPage wishlistObj = new WishlistPage(driver);
		MonteCarloLoginPage loginObj = new MonteCarloLoginPage(driver);
		loginObj.LoginButton();
		
		MonteCarloSigninPage signInObj = new MonteCarloSigninPage(driver); 
		signInObj.enterEmailid(dataUtility.readingDataExcelFile("Sheet1", 1, 1));
		signInObj.enterPassword(dataUtility.readingDataExcelFile("Sheet1", 1, 2));
		signInObj.loginButton();
		
		SoftAssert a=new SoftAssert();
		a.assertEquals(driver.getTitle(),dataUtility.readingDataPropertyFile("AccountTitle"));
		
		accountObj.searchClick();
		accountObj.searchTextBoxclick(dataUtility.readingDataPropertyFile("HandTowels"));
		WebElement fourthProduct = accountObj.getSearchFourthProduct();
		utilities.scrollbarToElement(fourthProduct,driver);
		fourthProduct.click();
		logger.info("Product selected");
		
		addingProductObj.addToWishlistClick();
		addingProductObj.wishlistIconClick();
		
		
		WebElement product = wishlistObj.getMouseHoverOnProductInWishlist();
		utilities.waitElement(product);
		
		Actions actions = new Actions(driver);
		actions.moveToElement(product).perform();	
		
		wishlistObj.removeProductFromWishlistClick();
		logger.info("Product is successfully added to cart and removed from wishlist");
		a.assertAll();
		logger.info("Class Adding and RemovingProduct From Wishlist ran Successfully");

	}

}
