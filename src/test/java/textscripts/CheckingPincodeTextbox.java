package textscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericlibraries.BaseClass;
import pom.AccountPage;
import pom.MonteCarloLoginPage;
import pom.MonteCarloSigninPage;
import pom.ProductFilterSelectorPage;
import pom.RoundNeckProductPage;

public class CheckingPincodeTextbox extends BaseClass {

	@Test
public void AddProductToWishlistVerifyCart() throws EncryptedDocumentException, IOException, InterruptedException {
		
		MonteCarloLoginPage loginObj = new MonteCarloLoginPage(driver);
		loginObj.LoginButton();
		
		MonteCarloSigninPage signInObj = new MonteCarloSigninPage(driver); 
		signInObj.enterEmailid(dataUtility.readingDataExcelFile("Sheet1", 1, 1));
		signInObj.enterPassword(dataUtility.readingDataExcelFile("Sheet1", 1, 2));
		signInObj.loginButton();
		
		Assert.assertEquals(driver.getTitle(),dataUtility.readingDataPropertyFile("AccountTitle"));
		
		AccountPage accountObj = new AccountPage(driver);

		Thread.sleep(2000);
		utilities.mouseHover(accountObj.getMenMouseHover(),driver);
		Thread.sleep(2000);
		accountObj.roundNeckSweaterClick();
		
		ProductFilterSelectorPage filterObj = new ProductFilterSelectorPage(driver);
		filterObj.sizeFilterClick();
		filterObj.selectedSizeClick();
		filterObj.colourClick();
		filterObj.selectedColourClick();
		filterObj.brandclick();
		Thread.sleep(2000);
		filterObj.rockItBrandClick();
		Thread.sleep(2000);
		
		RoundNeckProductPage obj = new RoundNeckProductPage(driver);
		obj.selectProductClick();
		Thread.sleep(2000);
		obj.pincodeSendKeys(dataUtility.readingDataPropertyFile("pin"));
		obj.checkPincode();
		Thread.sleep(2000);

}
}