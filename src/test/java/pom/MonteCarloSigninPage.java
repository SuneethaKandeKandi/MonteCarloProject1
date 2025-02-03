package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MonteCarloSigninPage {

	@FindBy (id = "customer[email]")
	private WebElement emailId;
	
	@FindBy (id = "customer[password]")
	private WebElement password;
	
	@FindBy (xpath = "//span[text() = 'Login']")
	private WebElement loginButton;
	
	public MonteCarloSigninPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public void enterEmailid(String userEmailId) {
		emailId.sendKeys(userEmailId);
	}
	
	public void enterPassword(String userPassword) {
		password.sendKeys(userPassword);
	}
	
	public void loginButton () {
		loginButton.click();
	}
	
}

