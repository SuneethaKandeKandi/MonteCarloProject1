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

public class TC_03_CheckingPincodeTextbox extends BaseClass {

	@Test
public void pinCodeVerification() throws EncryptedDocumentException, IOException, InterruptedException {
		logger.info("Class manufacturerPincodeChecking Started");
		MonteCarloLoginPage loginObj = new MonteCarloLoginPage(driver);
		loginObj.LoginButton();
		
		MonteCarloSigninPage signInObj = new MonteCarloSigninPage(driver); 
		signInObj.enterEmailid(dataUtility.readingDataExcelFile("Sheet1", 1, 1));
		signInObj.enterPassword(dataUtility.readingDataExcelFile("Sheet1", 1, 2));
		signInObj.loginButton();
		
		Assert.assertEquals(driver.getTitle(),dataUtility.readingDataPropertyFile("AccountTitle"));
		logger.info("Account Page is verified");

		AccountPage accountObj = new AccountPage(driver);

		utilities.mouseHover(accountObj.getMenMouseHover(),driver);
		accountObj.roundNeckSweaterClick();
		
		ProductFilterSelectorPage filterObj = new ProductFilterSelectorPage(driver);
		filterObj.sizeFilterClick();
		filterObj.selectedSizeClick();
		filterObj.colourClick();
		filterObj.selectedColourClick();
		filterObj.brandclick();
		filterObj.rockItBrandClick();
		
		RoundNeckProductPage obj = new RoundNeckProductPage(driver);
		obj.selectProductClick();
		obj.pincodeSendKeys(dataUtility.readingDataPropertyFile("pin"));
		logger.info("Pincode verified");
		obj.checkPincode();

		logger.info("The pinCodeVerification class ran successfully.");

}
}