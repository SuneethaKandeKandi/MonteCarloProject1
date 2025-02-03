package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddingProductPage {
	@FindBy( id="AddToCart")
	private WebElement addtoCart;

	@FindBy( xpath = "//a[@data-tippy-content='Add to Wishlist']")
	private WebElement addToWishlist;
	
	@FindBy( xpath = "//span[@class='icon-title']")
	private WebElement wishlistIcon;
	
	@FindBy(xpath = "(//label[@class='block-swatch__item'])[4]")
	private WebElement size;
	
	@FindBy( xpath = "//button[@class='quantity-selector__button'])[2]")
	private WebElement increaseQuantity;
	
	@FindBy(name="checkout")
	private WebElement checkoutButton;
	
	@FindBy (xpath = "//span[@class='ft__']")
	private WebElement productDetailsDescription;
	
	@FindBy (xpath = "//a[text()='Our Stores']")
	private WebElement ourStores;
	
	@FindBy(id= "pincode")
	private WebElement pincode;
	
	@FindBy(id="check-pincode")
	private WebElement checkPincode;
	
	@FindBy (xpath = "//button[@type='submit']")
	private WebElement addToWishListButton;
	
	@FindBy (xpath="//button[@title='Close']")
	private WebElement closeButton;
	
	public void closeButtonClick() {
		closeButton.click();
	}
	public void addToWishListButtonClick() {
		addToWishListButton.click();
	}
	public void ourStoresClick() {
		ourStores.click();
	}
	public void productDetailsDescriptionClick() {
		productDetailsDescription.click();
	}
	public void checkoutButtonClick() {
		checkoutButton.click();
	}
	public void addtoCartClick() {
		addtoCart.click();
	}
	public void increaseQuantityClick() {
		increaseQuantity.click();
	}
	
	public void checkPincode() {
		checkPincode.click();
	}
	
	public void pincodeSendKeys(String pin) {
		pincode.sendKeys(pin);
	}
	
	public AddingProductPage(WebDriver driver) {	
		PageFactory.initElements(driver, this);
	}
	

	public void addToWishlistClick() {
		addToWishlist.click();
	}

	public void wishlistIconClick() {
		wishlistIcon.click();
	}
	
	public void sizeClick() {
		size.click();
	}
	
}
