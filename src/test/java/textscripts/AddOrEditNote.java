package textscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericlibraries.BaseClass;
import pom.AccountPage;
import pom.MonteCarloLoginPage;
import pom.MonteCarloSigninPage;

public class AddOrEditNote extends BaseClass {
	@Test
	public void addOrEdit() throws EncryptedDocumentException, IOException {
	MonteCarloLoginPage loginObj = new MonteCarloLoginPage(driver);
	loginObj.LoginButton();
	
	MonteCarloSigninPage signInObj = new MonteCarloSigninPage(driver); 
	signInObj.enterEmailid(dataUtility.readingDataExcelFile("Sheet1", 1, 1));
	signInObj.enterPassword(dataUtility.readingDataExcelFile("Sheet1", 1, 2));
	signInObj.loginButton();
	Assert.assertEquals(driver.getTitle(),dataUtility.readingDataPropertyFile("AccountTitle"));
	
	AccountPage accountObj = new AccountPage(driver);
	accountObj.cartIconClick();
	accountObj.addOrderNoteButtonClick();
	accountObj.addNoteBoxSendKeys(dataUtility.readingDataPropertyFile("note"));
	accountObj.saveNoteButtonClick();
	accountObj.closeCartDrawerButtonClick();
	
	}
}
