package webAuto;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.StringTokenizer;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.AddWorkPage;
import pages.DashBoardPage;
import pages.HomePage;
import pages.LoginPage;
import pages.UploadPopUp;

public class Test {

	public static void main(String[] args) throws InterruptedException, IOException, AWTException {
		
		String username = "kocochj999@gmail.com";
		String password = "duyvip_123pro";

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.redbubble.com/auth/login");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
		System.out.println("done");
		Thread.sleep(90000);
		System.out.println("woke up");
		
		HomePage homePage = new HomePage(driver);
		homePage.clickSell();
		
		DashBoardPage dash = new DashBoardPage(driver);
		dash.clickAdd();
		
		Thread.sleep(10000);
		
		AddWorkPage addWorkPage = new AddWorkPage(driver);
		addWorkPage.clickAdd();
		
		Thread.sleep(10000);
		
		UploadPopUp popup = new UploadPopUp();
		popup.type("\"G:\\Pic\\415462.jpg\"");
		popup.enter();
		

		// Write cookies
//		File file = new File("Cookies.data");
//		file.delete();
//		file.createNewFile();
//		FileWriter writer = new FileWriter(file);
//		BufferedWriter bWriter = new BufferedWriter(writer);
//		Set<Cookie> cookies = driver.manage().getCookies();
//		for(Cookie cookie:cookies) {
//			bWriter.write((cookie.getName()+";"+cookie.getValue()+";"
//		+cookie.getDomain()+";"+cookie.getPath()+";"+cookie.getExpiry()+";"+cookie.isSecure()));
//			bWriter.newLine();
//		}
//		bWriter.close();
//		writer.close();
//		System.out.println("done");

		// Read cookies
//		try {
//
//			File file = new File("Cookies.data");
//			FileReader fileReader = new FileReader(file);
//			BufferedReader Buffreader = new BufferedReader(fileReader);
//			String strline;
//			while ((strline = Buffreader.readLine()) != null) {
//				StringTokenizer token = new StringTokenizer(strline, ";");
//				while (token.hasMoreTokens()) {
//					String name = token.nextToken();
//					String value = token.nextToken();
//					String domain = "www"+token.nextToken();
//					System.out.println(domain);
//					String path = token.nextToken();
//					Date expiry = null;
//
//					String val;
//					if (!(val = token.nextToken()).equals("null")) {
//						expiry = new Date(val);
//					}
//					Boolean isSecure = new Boolean(token.nextToken()).booleanValue();
//					Cookie ck = new Cookie(name, value, domain, path, expiry, isSecure);
//					System.out.println(ck);
//					driver.manage().addCookie(ck); // This will add the stored cookie to your current session
//				}
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
		System.out.println("done");
		
	}

}
