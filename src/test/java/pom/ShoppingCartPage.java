package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

	@FindBy (xpath="//textarea[@is='cart-note']")
	private WebElement addNote;
	
	@FindBy(xpath="//button[@name='checkout']")
	private WebElement initiateCheckout;
	
	@FindBy(id="order-note-toggle")
	private WebElement addEditNote;
	
		
	public ShoppingCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void addNoteendKeys(String note) {
		addNote.sendKeys(note);
	}

	public void intiateCheckoutClick() {
		initiateCheckout.click();
	}
	
	public void addEditNote() {
		addEditNote.click();
	}

}
