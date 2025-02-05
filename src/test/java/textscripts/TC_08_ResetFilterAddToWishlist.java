package textscripts;
/*1. Open the Browser
2. Enter the Url.
3. Click on Women.
4. Click on stole.
5. Set the price range from 0 to 500.
6. No result text should be visible.
7.Click on reset filter button.
8.Set the range from 299 to 2000.
9.Click on the first product.
10.Click on the wishlist of the product.
11.Verify the popup Text
12.Check the producted is added to wishlist.*/

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import genericlibraries.BaseClass;
import pom.AccountPage;
import pom.ProductFilterSelectorPage;
import pom.WishlistPage;
import pom.WomenHomePage;

public class TC_08_ResetFilterAddToWishlist extends BaseClass {
	
	@Test
	public void enterDetails() throws EncryptedDocumentException, IOException, InterruptedException {
		logger.info("class EnterDetailsOnProductAdding started");

		AccountPage accountObj = new AccountPage(driver);
		accountObj.womenMenuClick();
		
		WomenHomePage obj = new WomenHomePage(driver);
	    obj.stoleProduct1Click();
	    
	    ProductFilterSelectorPage productObj = new ProductFilterSelectorPage(driver);
	    productObj.toPriceSend(dataUtility.readingDataPropertyFile("MinPrice"));
	    productObj.toPriceClick();
	    
	    productObj.clearProductsClick();
	    logger.info("no such product is clicked");
	    productObj.fromPriceSendKeys(dataUtility.readingDataPropertyFile("MinPrice"));
	    productObj.toPriceSend(dataUtility.readingDataPropertyFile("MaxPrice"));	    
	    productObj.selectProductClick();
	    
	    WishlistPage wishlistObj = new WishlistPage(driver);
	    wishlistObj.addToWishlistIconClick();
	    wishlistObj.flitsEmailIdSendKeys(dataUtility.readingDataExcelFile("Sheet1", 1, 1));
	    logger.info("Eamil entered once the popup is shown");
	    
	    wishlistObj.popUpAddToWishlistClick();
	    String message = wishlistObj.getWishlistText();
	    logger.info(wishlistObj.getWishlistText());
	    
	    Assert.assertEquals(message, "Product has been added to your wishlist");
	    
	    logger.info("class EnterDetailsOnProductAdding ran successfully");
		
    }
}
