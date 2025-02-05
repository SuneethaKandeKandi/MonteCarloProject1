package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutMonteCarlo {

	@FindBy (id="shipping-address1")
	private WebElement addAddress;
	
	public void addAddressSendKeys(String city) {
		addAddress.sendKeys(city);
	}

	@FindBy(id="shipping-address1-option-1")
	private WebElement addressSecondOption;
	
	public void addressSecondOptionClick() {
		addressSecondOption.click();
	}

	public CheckoutMonteCarlo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
