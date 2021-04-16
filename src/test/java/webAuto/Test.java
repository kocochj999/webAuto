package webAuto;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.StringTokenizer;

import common.ScreenFactory;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.service.DriverCommandExecutor;
import pages.*;

public class Test {

	public static void main(String[] args) throws InterruptedException, IOException, AWTException {
		
		String username = "kocochj999@gmail.com";
		String password = "duyvip_123pro";

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("debuggerAddress", "127.0.0.1:9233");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.redbubble.com/en/");

		/*LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
		System.out.println("done");
		Thread.sleep(90000);
		System.out.println("woke up");*/

		HomePage homePage = new HomePage(driver);
		homePage.clickSell();
		
		DashBoardPage dash = new DashBoardPage(driver);
		dash.clickAdd();

		AddWorkPage addWorkPage = new AddWorkPage(driver);
		addWorkPage.clickAdd();
		
		Thread.sleep(10000);
		
		UploadPopUp popup = new UploadPopUp();
//		popup.type("\\Documents\\pics\\dota_heroes.png");
//		popup.enter();
		Thread.sleep(10000);

		ProductDescriptionPage productDescriptionPage = new ProductDescriptionPage(driver);
		productDescriptionPage.inputDetails("title","tag","des");

		


		System.out.println("done");
		
	}

}
