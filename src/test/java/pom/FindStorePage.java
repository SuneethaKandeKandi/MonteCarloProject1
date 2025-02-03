package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindStorePage {
	@FindBy (id="searchInput")
	private WebElement searchTextBox;
	
	@FindBy (xpath = "//a[contains(@class,'directions-btn')]")
	private WebElement getDirecion;
		
	public FindStorePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
    }
	
	public void getDirecionClick() {
		getDirecion.click();
	}

	public void searchTextBox(String pin) {
		searchTextBox.sendKeys(pin);
	}
	
}
