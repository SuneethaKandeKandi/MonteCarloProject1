package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	
	@FindBy (xpath ="(//a[contains(@class,'header__linklist')])[5]")
	private WebElement homeFurnishing ;
	
	@FindBy (xpath = "//img[@class='mega-menu__image']")
	private WebElement womenImage ;
		
	@FindBy (linkText = "AC Comforter")
	private WebElement acComforter;
	
	@FindBy (xpath = "//a[text()='MEN']")
	private WebElement menMouseHover ;
	
	@FindBy (xpath = "//img[@class='header__logo-image2']")
	private WebElement monteCarloHome ;
	
	@FindBy (xpath = "//h3[text()='Addresses']")
	private WebElement addressIcon;
	
	@FindBy (xpath = "//a[@href='/collections/round-neck-sweater-for-men']")
	private WebElement roundNeckSweater ;
	
	@FindBy (xpath = "//a[@aria-controls='search-drawer']")
	private WebElement search;
	
	@FindBy (name="q")
	private WebElement searchTextBox;
	
	@FindBy (xpath = "(//a[@aria-controls='desktop-menu-2'])")
	private WebElement womenMenu;
	
	@FindBy (xpath = "(//img[@class='line-item__image'])[4]")
	private WebElement searchFourthProduct;
	
	@FindBy (xpath = "//a[@aria-label='Cart']")
	private WebElement cartIcon;
	
	@FindBy (xpath = "//a[text() = 'Start shopping']")
	private WebElement startShopingButton;
	
	
	@FindBy(id = "order-note-toggle")
	private WebElement addOrderNoteButton;
 
 
	@FindBy(id = "cart[note]")
	private WebElement addNoteBox;
 
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveNoteButton;
 
	@FindBy(xpath = "//button[@data-action=\"close\"]")
	private WebElement closeCartDrawerButton;
	
	@FindBy(xpath = "//button[@form='predictive-search-form']")
	private WebElement viewAllResults;
	
	
	public void viewAllResultsClick() {
		viewAllResults.click();
	}


	public void addNoteBoxSendKeys(String note) {
		addNoteBox.sendKeys(note);
	}


	public void saveNoteButtonClick() {
		saveNoteButton.click();
	}


	public void closeCartDrawerButtonClick() {
		closeCartDrawerButton.click();
	}


	public void addOrderNoteButtonClick() {
		addOrderNoteButton.click();
	}


	public AccountPage(WebDriver driver) {    
		PageFactory.initElements(driver, this);
	}
	
	
	public void startShopingButtonClick() {
		startShopingButton.click();
	}


	public void cartIconClick() {
		cartIcon.click();
	}


	public WebElement getSearchFourthProduct() {
		return searchFourthProduct;
	}


	public void womenMenuClick() {
		womenMenu.click();
	}
	
	public void searchClick() {
		search.click();
	}
	
	public void searchTextBoxclick(String productname) {
		searchTextBox.sendKeys(productname);
	}

	public void homeFurnishingClick() {
		homeFurnishing.click();
	}

	public void addressIconClick() {
		addressIcon.click();
	}

	public void monteCarloHomeClick() {
		monteCarloHome.click();
	}

	public void roundNeckSweaterClick() {
		roundNeckSweater.click();
	}

	public WebElement getMenMouseHover() {
		return menMouseHover;
	}

	public void womenImageClick() {
		womenImage.click();
	}
	
	public WebElement getHomeFurnishing() {
		return homeFurnishing;
	}

	public void acComforterClick() {
		acComforter.click();
	}
}
