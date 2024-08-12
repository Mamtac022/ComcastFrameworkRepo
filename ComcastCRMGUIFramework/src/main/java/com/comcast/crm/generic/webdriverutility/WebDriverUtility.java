package com.comcast.crm.generic.webdriverutility;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriverUtility {
	
	// for implicitly wait
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	// for explicitly wait
	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public void waitForAllElementsPresent(WebDriver driver, WebElement elements)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	
	public void waitForElementSelected(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	
	public void waitForElementClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForTitleContains(WebDriver driver, String key)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.titleContains(key));
	}
	
	
	// for handling child window
	public void switchToTabOnURL(WebDriver driver, String partialURL) {
		Set<String> set =driver.getWindowHandles();
	    Iterator<String> it = set.iterator();
	    
	    while(it.hasNext())
	    {
	    	String windowID = it.next();
	    	driver.switchTo().window(windowID);
	    	
	    	String actUrl =driver.getCurrentUrl();
	    	if(actUrl.contains(partialURL))
	    	{
	    		break;
	    	}
	    }
	}
	
	// for handling parent window
	public void switchToTabOnTitle(WebDriver driver, String partialTitle) {
		Set<String> set =driver.getWindowHandles();
	    Iterator<String> it = set.iterator();
	    
	    while(it.hasNext())
	    {
	    	String windowID = it.next();
	    	driver.switchTo().window(windowID);
	    	
	    	String actUrl =driver.getTitle();
	    	if(actUrl.contains(partialTitle))
	    	{
	    		break;
	    	}
	    }
	}
	
	// for switching to frame
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}

	public void switchToFrame(WebDriver driver, String nameID)
	{
		driver.switchTo().frame(nameID);
	}
	
	public void switchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	//for switching to parent frame
	public void switchToParentFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}

	public void switchToParentFrame(WebDriver driver, String nameID)
	{
		driver.switchTo().frame(nameID);
	}
	
	public void switchToParentFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	// for switching to alert
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	//for handling dropdown
	public Select select(WebElement element) {
		Select sel = new Select(element);
		return sel;
	}
	
	public void selectByVisibleText(WebElement element, String text) {
		
		select(element).selectByVisibleText(text);
		
	}
	
	public void selectByIndex(WebElement element, int index) {
		
		select(element).selectByIndex(index);
		
	}
	
	public void selectByValue(WebElement element, String value) {
		
		select(element).selectByValue(value);
		
	}
	
	public void deselectByVisibleText(WebElement element, String text) {
		
		select(element).deselectByVisibleText(text);
		
	}
	
	public void deselectByIndex(WebElement element, int index) {
		
		select(element).deselectByIndex(index);
		
	}
	
	public void deselectByValue(WebElement element, String value) {
		
		select(element).deselectByValue(value);
		
	}
	
	//performing mouse actions
	public Actions actions(WebDriver driver) {
		Actions act = new Actions(driver);
		return act;
	}
	
	public void mousehover(WebDriver driver, WebElement element) {
		actions(driver).moveToElement(element).perform();
	}
	
	public void scrollToElement(WebDriver driver, WebElement element) {
		actions(driver).scrollToElement(element).perform();
	}
	
	public void contextClick(WebDriver driver, WebElement element) {
		actions(driver).contextClick(element).perform();
	}
	
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement dest) {
		actions(driver).dragAndDrop(src,dest).perform();
	}
	
	public void doubleClick(WebDriver driver, WebElement element) {
		actions(driver).doubleClick(element).perform();
	}

	//By javaScript Executor
	public void scrollUntilElementToBeVisible(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")");
	}
	
	public void scrollIntoView(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIn"
				+ "toView()",element);
		
		//for taking screenshot
		
		
		}



}

