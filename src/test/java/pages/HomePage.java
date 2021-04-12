package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
	WebDriver driver;
	
	@FindBy(xpath = "//div[@aria-label='User account menu']")
	WebElement accountBtn;
	
	@FindBy(xpath = "//a[@target='_self']")
	WebElement sellBtn;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickSell() {
		clickElement(driver, accountBtn);
		clickElement(driver, sellBtn);
	}
	
	

}
