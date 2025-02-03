package textscripts;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericlibraries.BaseClass;
import pom.AccountPage;
import pom.AddingProductPage;
import pom.MonteCarloLoginPage;
import pom.MonteCarloSigninPage;
import pom.WishlistPage;

public class AddingAndRemovingProductFromWishlist extends BaseClass {
	
	@Test
	public void AddingRemovingProductFromWishlist() throws EncryptedDocumentException, IOException, InterruptedException {
		
		AccountPage accountObj = new AccountPage(driver);
		AddingProductPage addingProductObj = new AddingProductPage(driver);
		WishlistPage wishlistObj = new WishlistPage(driver);
		MonteCarloLoginPage loginObj = new MonteCarloLoginPage(driver);
		loginObj.LoginButton();
		
		MonteCarloSigninPage signInObj = new MonteCarloSigninPage(driver); 
		signInObj.enterEmailid(dataUtility.readingDataExcelFile("Sheet1", 1, 1));
		signInObj.enterPassword(dataUtility.readingDataExcelFile("Sheet1", 1, 2));
		signInObj.loginButton();
		Assert.assertEquals(driver.getTitle(),dataUtility.readingDataPropertyFile("AccountTitle"));
		
		accountObj.searchClick();
		accountObj.searchTextBoxclick(dataUtility.readingDataPropertyFile("HandTowels"));
		WebElement fourthProduct = accountObj.getSearchFourthProduct();
		utilities.scrollbarToElement(fourthProduct,driver);
		fourthProduct.click();
		
		addingProductObj.addToWishlistClick();
		addingProductObj.wishlistIconClick();
		WebElement product = wishlistObj.getMouseHoverOnProductInWishlist();
		
		Thread.sleep(2000);	

		Actions actions = new Actions(driver);
		actions.moveToElement(product).perform();
		
		//utilities.mouseHover(product, driver);
		
		wishlistObj.removeProductFromWishlistClick();
		Thread.sleep(2000);	
	
	}

}
