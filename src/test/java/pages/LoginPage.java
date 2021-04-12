package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	WebDriver driver;
	public static final String URL = "https://www.redbubble.com/auth/login";

	@FindBy(id = "ReduxFormInput1")
	WebElement usernameInput;

	@FindBy(id = "ReduxFormInput2")
	WebElement passwordInput;

	@FindBy(xpath = "//button[@type='submit' and contains(@class,'Button')]")
	WebElement loginBtn;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void login(String username, String password) {
		sendKeysToElement(driver, usernameInput, username);
		sendKeysToElement(driver, passwordInput, password);
		clickElement(driver, loginBtn);
	}

}
