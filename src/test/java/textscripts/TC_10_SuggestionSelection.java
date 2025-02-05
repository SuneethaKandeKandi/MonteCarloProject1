package textscripts;
/*01. open browser
02. enter url https://www.montecarlo.in/
03. verify homepage
04. click on login/sign up
05. enter username
06. enter password
07. click login
08. click on cart
09. make sure "Your cart is empty" text is displaying
10. click start shopping.
11  click on sort by
12. select 'high to low'
13. add any product to wishlist
14. click on wishlist
15. verify if product got added to wishlist
16. add that item to cart
17. enter text in 'add order note' 
18. initiate checkout click
19. enter text bangalore and select second suggesstion
20.close the application*/

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericlibraries.BaseClass;
import pom.AccountPage;
import pom.AddingProductPage;
import pom.CheckoutMonteCarlo;
import pom.MonteCarloLoginPage;
import pom.MonteCarloSigninPage;
import pom.ProductFilterSelectorPage;
import pom.ShoppingCartPage;
import pom.WishlistPage;

public class TC_10_SuggestionSelection extends BaseClass {

	@Test
     public void checkOut() throws EncryptedDocumentException, IOException, InterruptedException {
		logger.info("class  SuggestionSelection started");
		MonteCarloLoginPage loginObj = new MonteCarloLoginPage(driver);
		loginObj.LoginButton();
		
		MonteCarloSigninPage signInObj = new MonteCarloSigninPage(driver); 
		signInObj.enterEmailid(dataUtility.readingDataExcelFile("Sheet1", 1, 1));
		signInObj.enterPassword(dataUtility.readingDataExcelFile("Sheet1", 1, 2));
		signInObj.loginButton();
		logger.info("Successfully logged into MonteCarlo");

		
		Assert.assertEquals(driver.getTitle(),dataUtility.readingDataPropertyFile("AccountTitle"));
		AccountPage accountObj = new AccountPage(driver);
		accountObj.cartIconClick();
		accountObj.startShopingButtonClick();
		
		ProductFilterSelectorPage productObj = new ProductFilterSelectorPage(driver);
		productObj.bestSellingClick();
		productObj.highToLowClick();
		productObj.productTC10Click();
		
		AddingProductPage addProductobj = new AddingProductPage(driver);
		addProductobj.addToWishlistClick();
		addProductobj.wishlistIconClick();
		logger.info("product added to wishlist");
		
		WishlistPage wishlistObj = new WishlistPage(driver);
		wishlistObj.addToCartInWishlist();
		logger.info("product added to cart");
		
		ShoppingCartPage shoppingCartObj = new ShoppingCartPage(driver);
		shoppingCartObj.addEditNote();
		shoppingCartObj.addNoteendKeys(dataUtility.readingDataPropertyFile("note"));
		shoppingCartObj.intiateCheckoutClick();
		logger.info("checkout initiated");
		
		CheckoutMonteCarlo checkoutObj = new CheckoutMonteCarlo(driver);
		checkoutObj.addAddressSendKeys(dataUtility.readingDataPropertyFile("BangaloreCity"));
		checkoutObj.addressSecondOptionClick();	
		
		logger.info("class SuggestionSelection ran Successfully");
}
}
