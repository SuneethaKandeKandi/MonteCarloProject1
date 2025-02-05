package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishlistPage {
	
	@FindBy (xpath = "//p[contains(@data-tippy-content,'Printed 100% Polyster Single')]")
	private WebElement userProduct;
	
	@FindBy (xpath = "//a[@data-tippy-content='Add to Wishlist']")
	private WebElement addToWishlistIcon;

	@FindBy (xpath = "//button[@data-flits-add-action-from='wishlist']")
	private WebElement addToCartInWishlist;
	
	@FindBy (xpath = "//a[@href='/account/login'])[5]")
	private WebElement LoginInWishlist;
	
	@FindBy (name="email")
	private WebElement flits_email_id;
	
	@FindBy (xpath=("//div[@class='flits-product-item']"))
	private WebElement mouseHoverOnProductInWishlist;
	
	@FindBy(xpath=("//button[@class='flits-button flits-primary-btn flits-remove-product']"))
	private WebElement removeProductFromWishlist;
	
	@FindBy(xpath = "//button[@data-flits-lang-default='Add to Wishlist']")
	private WebElement popUpAddToWishlist;
	
	@FindBy (xpath = "(//p[@class='flits-h2 flits-tingle-modal-popup-header-title'])[2]")
	private WebElement wishlistText;

	public WishlistPage(WebDriver driver) {	
		PageFactory.initElements(driver, this);
	}

	public String getWishlistText() {
		return wishlistText.getText();
	}
	
	public void popUpAddToWishlistClick() {
		popUpAddToWishlist.click();
	}

	public void removeProductFromWishlistClick() {
		removeProductFromWishlist.click();
	}

	public WebElement getMouseHoverOnProductInWishlist() {
		return mouseHoverOnProductInWishlist;
	}

	public void flitsEmailIdSendKeys(String email) {
		flits_email_id.sendKeys(email);
	}
	

	public void LoginInWishlistClick() {
		LoginInWishlist.click();
	}
	
	public void addToWishlistIconClick() {
		addToWishlistIcon.click();
	}


	public WebElement getUserProduct() {
		return userProduct;
	}
	
	public void addToCartInWishlist() {
		addToCartInWishlist.click();
	}
	
}
