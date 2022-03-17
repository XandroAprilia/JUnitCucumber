package logPageTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseLoginInput;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.Assert.*;

public class BasePageTest implements IDriverManager {
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<WebDriverWait>();
	
	String errA = "fullstackdemo";
	String errB = "Error: The password you entered for the username fullstackdemo is incorrect. Lost your password?";
	String errC = "Error: The username notfullstackdemo is not registered on this site. If you are unsure of your username, try your email address instead.";

	BaseLoginInput input = new BaseLoginInput(driver, explicitWait);
	
	public void createChromeDriver() {
		// base page
		WebDriverManager.chromedriver().setup();
		driver.set(new ChromeDriver());
		driver.get().get("https://testautomasi.com/profile/");
		driver.get().manage().window().maximize();
		explicitWait.set(new WebDriverWait(driver.get(), Duration.ofSeconds(60)));
	}
	
	public void enterUserName() {
		String inputEmail = "fullstackdemo";
		input.addUserName(inputEmail);
	}
	
	public void enterInvUserName() {
		String inputEmail = "notfullstackdemo";
		input.addUserName(inputEmail);
	}
	
	public void enterPassword() {
		String inputPassword = "fullstackdemo";
		input.addPassword(inputPassword);	
	}
	
	public void enterInvPassword() {
		String inputPassword = "notfullstackdemo";
		input.addPassword(inputPassword);	
	}
	
	public void clk() {
		input.clickbutton();
	}
	
	public void verifLogSuccess() {
		String logSucess = input.getVerifyText(errA);
		assertEquals(logSucess, errA);
	}
	
	public void errorMPassword() {
		String passGagal = input.getErrorText(errB);
		assertEquals(passGagal, errB);
	}
	
	public void errorNotRegis() {
		String nRegis = input.getErrorText(errC);
		assertEquals(nRegis, errC);
	}

	public void quitChromeDriver() {
		driver.get().quit();
	}

}
