package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RoundNeckProductPage {
	
	@FindBy (xpath = "(//img[@class='product-item__secondary-image'])[1]")
	private WebElement selectProduct;

	@FindBy(id= "pincode")
	private WebElement pincode;
	
	@FindBy(id="check-pincode")
	private WebElement checkPincode;
	
	public RoundNeckProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void selectProductClick() {
		selectProduct.click();
	}
	
	public void checkPincode() {
		checkPincode.click();
	}
	
	public void pincodeSendKeys(String pin) {
		pincode.sendKeys(pin);
	}	

}
