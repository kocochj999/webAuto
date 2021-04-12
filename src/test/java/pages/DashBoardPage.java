package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage extends BasePage{

	WebDriver driver;
	
	@FindBy(xpath = "//span[text()='Add new work']//ancestor::a")
	WebElement addnewBtn;
	
	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickAdd() {
		clickElement(driver, addnewBtn);
	}

}
