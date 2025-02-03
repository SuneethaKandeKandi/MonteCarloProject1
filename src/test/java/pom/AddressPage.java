package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage {
	
	@FindBy (xpath = "//button[text() ='Add a new address']")
	private WebElement addNewAddress;
	
	@FindBy (id="address-new[zip]")
	private WebElement zipCode;
	
	@FindBy (id="address-new[default]")
	private WebElement addresscheckBox;
	
	@FindBy (xpath = "//span[@class='loader-button__text']")
	private WebElement newAddressButton;
	
	@FindBy(id="address-new[first_name]")
	private WebElement firstname;
	
	@FindBy(id="address-new[last_name]")
	private WebElement lastname;
	
	@FindBy(id="address-new[company]")
	private WebElement company;
	
	@FindBy(id="address-new[phone]")
	private WebElement phone;
	
	@FindBy(id="address-new[address1]")
	private WebElement address1;
	
	@FindBy(id="address-new[address2]")
	private WebElement address2;
	
	@FindBy(id="address-new[city]")
	private WebElement city;
	
	@FindBy(id="address-new[province]")
	private WebElement addressNewProvince;
	
	@FindBy(xpath="(//button[@is='confirm-button'])[3]")
	private WebElement deleteAddressButton;
	
	@FindBy(xpath="//span[text()='Default address']")
	private WebElement defaultAddress;
	
	@FindBy(xpath="//button[@is='confirm-button']")
	private WebElement defaultDelete;
	
	public void defaultDeleteClick() {
		defaultDelete.click();
	}

	public WebElement getDefaultAddress() {
		return defaultAddress;
	}

	public void deleteAddressButtonClick() {
		deleteAddressButton.click();
	}

	public AddressPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getAddressNewProvince() {
		return addressNewProvince;
	}
		public void firstName(String first)
		{
			firstname.sendKeys(first);
		}
		public void lastName(String last)
		{
			lastname.sendKeys(last);
		}
		public void companyName(String cmp)
		{
			company.sendKeys(cmp);
		}
		public void phoneNumber(String num)
		{
			phone.sendKeys(num);
		}
		public void address1(String address)
		{
			address1.sendKeys(address);
		}
		public void address2(String address)
		{
			address2.sendKeys(address);
		}
		public void city(String cityname)
		{
			city.sendKeys(cityname);
		}
		
	public void newAddressButtonClick() {
		newAddressButton.click();
	}

	public void addresscheckBoxClick() {
		addresscheckBox.click();
	}

	public void sendKeys(String zipcode1) {
		zipCode.sendKeys(zipcode1);
	}

	public void addNewAddressClick() {
		addNewAddress.click();
	}

}
