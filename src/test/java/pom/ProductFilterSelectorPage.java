package pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductFilterSelectorPage {
	
	@FindBy (xpath = "(//input[@aria-label='To price'])[2]")
	private WebElement toPrice;

	@FindBy (xpath = "//button[text()='Size']")
	private WebElement sizeFilter;
	
	@FindBy (xpath = "(//label[@class='block-swatch__item'])[1]")
	private WebElement selectedSize;
	
	@FindBy (xpath = "//button[text()='Color']")
	private WebElement colour;
	
	@FindBy (xpath = "(//div[contains(@class,'color-swatch')])[2]")
	private WebElement selectedColour;
	
	@FindBy (xpath = "//button[text()='Brand']")
	private WebElement brand;
	
	@FindBy (xpath = "(//input[@name='filter.p.m.custom.brand'])")
	private WebElement brandCheckbox;
	
	@FindBy(xpath ="//label[@for = 'filter.p.m.custom.brand-3']")
	private WebElement rockItBrand;
	
	@FindBy(xpath ="//button[@class='popover-button hidden-pocket']")
	private WebElement bestSelling;
	

	@FindBy (linkText = "Sleeve")
	private WebElement sleeve;
	
	@FindBy (xpath = "//input[@name='filter.p.m.custom.sleeve_id']")
	private WebElement sleevCheckbox;
	
	@FindBy (xpath = "//button[text()='Availability']")
	private WebElement availability;
	
	@FindBy (id ="filter.v.availability-1")
	private WebElement inStockCheckbox;
	
	@FindBy (xpath="(//img[contains(@class,'product-item__primary-image')])[1]")
	private WebElement selectProduct;
	
	@FindBy (xpath = "(//a[@data-action='clear-filters'])[3]")
	private WebElement clearProducts;	
	
	@FindBy (xpath = "(//input[@aria-label=\"From price\"])[2]")
	private WebElement fromPrice;	
	
	@FindBy (xpath = "//span[text() ='Date, old to new']")
	private WebElement dateOldToNew;
	
	@FindBy (xpath = "//a[contains(@class,'product-item')]")
	private WebElement productOldToNew;
	
	@FindBy (xpath = "(//a[contains(text(),'Printed 100% Polyster Single')])[8]")
    private WebElement homeFurninshingProduct;
	
	@FindBy (xpath = "(//a[contains(text(),'Women Maroon')])[1]")
    private WebElement womenProduct;
	@FindBy(xpath="(//a[contains(text(),' Cotton')])[10]")
	private WebElement productTC10;
	
	public void productTC10Click() {
		productTC10.click();
	}

	public void highToLowClick() {
		highToLow.click();
	}

	@FindBy(xpath="//span[text()='Price, high to low']")
	private WebElement highToLow;
	
	public void womenProductClick() {
		womenProduct.click();
	}

	public ProductFilterSelectorPage(WebDriver driver) {	
		PageFactory.initElements(driver, this);
	}
	
	public void homeFurninshingProductClick() {
		homeFurninshingProduct.click();
	}
	
	public void productOldToNewClick() {
		productOldToNew.click();
	}
	public void dateOldToNewClick() {
		dateOldToNew.click();
	}

	public void bestSellingClick() {
		bestSelling.click();
	}

	public void fromPriceClick() {
		fromPrice.click();
	}
	
	public void rockItBrandClick() {
		rockItBrand.click();
	}
	public void toPriceClick() {
		fromPrice.sendKeys(Keys.ENTER);
	}

	public void fromPriceSendKeys(String minPrice) {
		fromPrice.sendKeys(minPrice);
	}

	public void clearProductsClick() {
		clearProducts.click();
	}
	
	public void sizeFilterClick() {
		sizeFilter.click();
	}

	public void selectedSizeClick() {
		selectedSize.click();
	}
	
	public void colourClick() {
		colour.click();
	}
	
	public void selectedColourClick() {
		selectedColour.click();
	}
	
	public void brandclick() {
		brand.click();
	}

	public void brandCheckboxClick() {
		brandCheckbox.click();
	}
	
	public void availabilityClick() {
		availability.click();
	}
	
	public void inStockCheckboxClick() {
		inStockCheckbox.click();
	}
	
	public void selectProductClick() {
		selectProduct.click();
	}
	
	public void toPriceSend(String maxPrice) {
		toPrice.sendKeys(maxPrice);
	}
	
}
