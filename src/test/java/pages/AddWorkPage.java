package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddWorkPage extends BasePage {

	WebDriver driver;

	@FindBy(xpath = "//input[@id='select-image-single']")
	WebElement uploadBtn;
	
	@FindBy(xpath = "//span[text()='Upload new work']")
	WebElement uploadBtn2;

	public AddWorkPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickAdd() {
		clickElement(driver, uploadBtn2);
	}

}
