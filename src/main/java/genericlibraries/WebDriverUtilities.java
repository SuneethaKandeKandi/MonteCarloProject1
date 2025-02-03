package genericlibraries;

import java.time.Duration;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class WebDriverUtilities {
	public WebDriver driver;
	
	public void mouseHover(WebElement element,WebDriver driver1) {
		Actions actions = new Actions(driver1);
		actions.moveToElement(element).perform();
	}
	
	public void rightClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}
	
	public void doubleClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	public void dropDown(WebElement element,String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	public void frameWithIndex(int indexValue) {
		driver.switchTo().frame(indexValue);
	}
	
	public void switchingBackFromFrame()
	{
		driver.switchTo().defaultContent();
	}
	
	public void alertAcceptPopup() {
		driver.switchTo().alert().accept();
	}
	
	public void alertDismissPopup() {
		driver.switchTo().alert().accept();
	}
	
	public void alertPopupText() {
		Alert alert = driver.switchTo().alert();
		Reporter.log(alert.getText(),true);
	}
	
	public void scrollbarTopToBottom(WebDriver driver) {
	    JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
	    javaScriptExecutor.executeScript("window.scrollBy(0,5000)");
		
	}
	
	public void scrollbarBottomtoTop() {
	    JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
	    javaScriptExecutor.executeScript("window.scrollBy(0,-5000)");
		
	}
	
	public void scrollbarToElement(WebElement element,WebDriver driver1) {
	    JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver1;
	    javaScriptExecutor.executeScript("arguments[0].scrollIntoView();",element);
		
	}
	
	public void switchChildWindow() {
		Set<String> child = driver.getWindowHandles();
		
		for(String ch : child) {
			driver.switchTo().window(ch);
		}
	}
	
	public void multipleTabs(int index) {
			Set<String> child = driver.getWindowHandles();
			ArrayList<String> arrayList = new ArrayList<String>(child);
			driver.switchTo().window(arrayList.get(index));
		}

	public void waitElement(WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(12));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	public void waitElementClick(WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(12));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	} 
				
}


