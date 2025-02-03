package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomenHomePage {
	@FindBy(xpath = "(//img[contains(@src,'//www.montecarlo')])[6]")
    private  WebElement stoleProduct;
    
	@FindBy (xpath = "//img[@src='//www.montecarlo.in/cdn/shop/files/06_Stall.png?v=1732612664']")
	private WebElement stoleProduct1;

	public WomenHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	 public void stoleProduct1Click() {
			stoleProduct1.click();
		}

	public void stoleProductClick() {
		stoleProduct.click();
	}
}
