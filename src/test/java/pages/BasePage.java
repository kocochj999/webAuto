package pages;

import java.util.List;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.jsoup.Connection;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	private static final String MAIN_OPTION = "//a[@href='/%s']";
	private WebDriverWait explicitwait;
	private long timeOut = 10;
	private WebElement element;
	private Select select;
	private Alert alert;
	private List<WebElement> eList;
	
	//for element
	public void waitElementVisible(WebDriver driver, WebElement e) {
		explicitwait = new WebDriverWait(driver, timeOut);
		explicitwait.until(ExpectedConditions.visibilityOf(e));
	}
	public void waitElementClickable(WebDriver driver, WebElement e) {
		explicitwait = new WebDriverWait(driver, timeOut);
		explicitwait.until(ExpectedConditions.visibilityOf(e));
		explicitwait.until(ExpectedConditions.elementToBeClickable(e));
	}
	
	
	//For Non-Dynamic Element
	public void waitElementClickable(WebDriver driver, String xpath) {
		explicitwait = new WebDriverWait(driver, timeOut);
		explicitwait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}
	public void waitElementVisible(WebDriver driver, String xpath)
	{
		explicitwait = new WebDriverWait(driver, timeOut);
		explicitwait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
	}
	public void click(WebDriver driver, String xpath)
	{
		waitElementVisible(driver, xpath);
		element = driver.findElement((By.xpath(xpath)));
		element.click();
	}
	public void sendKeys(WebDriver driver, String xpath, String keysToSend)
	{
		waitElementVisible(driver, xpath);
		element = driver.findElement(By.xpath(xpath));
		element.clear();
		element.sendKeys(keysToSend);
	}
	public void selectByValue(WebDriver driver, String xPath, String value) {
		select = new Select(driver.findElement(By.xpath(xPath)));
		select.selectByValue(value);
		
	}
	public String getMessage(WebDriver driver,String xpath) {
		element = driver.findElement(By.xpath(xpath));
		waitElementVisible(driver, xpath);
		return element.getText();
		
	}
	public List<WebElement> getElementList(WebDriver driver,String xPath){
		waitElementVisible(driver, xPath);
		eList = driver.findElements(By.xpath(xPath));
		return eList;
	}
	public void sendKeysToElement(WebDriver driver, WebElement e, String keysToSend) {
		waitElementVisible(driver,e);
		e.clear();
		e.sendKeys(keysToSend);
	}
	public void clickElement(WebDriver driver, WebElement e) {
		waitElementClickable(driver,e);
		e.click();
	}
	
	
	
	//For Dynamic Element
	public String getDynamicLocator(String xPath, String...value)
	{
		String locator = String.format(xPath, (Object[])value);
		return locator;
	}
	public WebElement getDynamicElement(WebDriver driver, String xPath, String value) {
		waitElementVisible(driver, xPath, value);
		return driver.findElement(By.xpath(getDynamicLocator(xPath, value)));
	}
	//waits
	public void waitElementClickable(WebDriver driver, String xPath, String value)
	{
		explicitwait = new WebDriverWait(driver, timeOut);
		explicitwait.until(ExpectedConditions.elementToBeClickable(By.xpath(getDynamicLocator(xPath, value))));
	}
	public void waitElementVisible(WebDriver driver, String xPath, String value)
	{
		explicitwait = new WebDriverWait(driver, timeOut);
		explicitwait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(getDynamicLocator(xPath, value))));
	}
	
	public void click(WebDriver driver, String xPath, String value)
	{
		waitElementClickable(driver, xPath, value);		
		element = driver.findElement((By.xpath(getDynamicLocator(xPath, value))));
		if(element.isEnabled()) {
			element.click();
		}
		
	}
	public void sendKeys(WebDriver driver, String xPath, String value, String keysToSend)
	{
		waitElementVisible(driver, xPath, value);
		element = driver.findElement(By.xpath(getDynamicLocator(xPath, value)));
		element.clear();
		element.sendKeys(keysToSend);
	}
	public void selectByValue(WebDriver driver, String xPath, String xpathValue, String value) {
		select = new Select(driver.findElement(By.xpath(getDynamicLocator(xPath, xpathValue))));
		select.selectByValue(value);
		
	}
	public String getMessage(WebDriver driver,String xPath, String value) {
		element = driver.findElement(By.xpath(getDynamicLocator(xPath, value)));
		waitElementVisible(driver, xPath, value);
		return element.getText();	
	}
	
	//superdynamic
	
	public String getSuperDynamicLocator(String xPath, String value1, String value2) {
		String locator = String.format(xPath, value1, value2);
		return locator;
	}
	public void waitElementClickable(WebDriver driver, String xPath, String value1, String value2)
	{
		explicitwait = new WebDriverWait(driver, timeOut);
		explicitwait.until(ExpectedConditions.elementToBeClickable(By.xpath(getSuperDynamicLocator(xPath, value1, value2))));
	}
	public void waitElementVisible(WebDriver driver, String xPath, String value1, String value2)
	{
		explicitwait = new WebDriverWait(driver, timeOut);
		explicitwait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(getSuperDynamicLocator(xPath, value1, value2))));
	}
	public void sendKeys(WebDriver driver, String xPath, String value1, String value2, String keysToSend)
	{
		waitElementVisible(driver, xPath, value1, value2);
		element = driver.findElement(By.xpath(getSuperDynamicLocator(xPath, value1, value2)));
		element.clear();
		element.sendKeys(keysToSend);
	}
	public void click(WebDriver driver, String xPath, String value1, String value2)
	{
		waitElementClickable(driver, xPath, value1, value2);
		element = driver.findElement(By.xpath(getSuperDynamicLocator(xPath, value1, value2)));
		element.click();
	}
	
	//Alert
	public void waitAlert(WebDriver driver)
	{
		explicitwait = new WebDriverWait(driver, timeOut);
		explicitwait.until(ExpectedConditions.alertIsPresent());
	}
	public String getAlerText(WebDriver driver)
	{
		waitAlert(driver);
		return driver.switchTo().alert().getText();
		
	}
	public void acceptAlert(WebDriver driver)
	{
		waitAlert(driver);
		alert = driver.switchTo().alert();
		alert.accept();
	}
	
	//Click main options
	public void clickMainOption(WebDriver driver, String optionName) {
		click(driver, MAIN_OPTION, optionName);
	}
	
}
