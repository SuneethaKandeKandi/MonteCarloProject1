package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MonteCarloLoginPage {
	
	@FindBy (xpath = "//span[contains(text(),'Login/Signup')]")
	private WebElement loginButton;

	public MonteCarloLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
    }
	
	public void LoginButton ()
	{
		loginButton.click();
	}
}
