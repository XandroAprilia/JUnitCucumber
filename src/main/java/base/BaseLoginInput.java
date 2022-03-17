package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseLoginInput extends BaseElementDo{
	By inputUserName = By.xpath("//input[@id='username']");
	By inputPassword = By.xpath("//input[@id='password']");
	By clickB = By.xpath("//button[normalize-space()='Login']");
	
	String vlog = "//strong[normalize-space()='fullstackdemo']";
	String getError = "//div[@class='learn-press-message error']";

	public BaseLoginInput(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
	}
	
	public void addUserName(String email) {
		clickAndWaitByXpath(inputUserName);
		setText(inputUserName, email);
	}
	
	public void addPassword(String password) {
		clickAndWaitByXpath(inputPassword);
		setText(inputPassword, password);
	}
	
	public void clickbutton() {
		clickAndWaitByXpath(clickB);
	}	
	
	public String getVerifyText(String v) {
		By finalXpath = By.xpath(String.format(vlog, v));
		return getText(finalXpath);
	}
	
	public String getErrorText(String teror) {
		By finalXpath = By.xpath(String.format(getError, teror));
		return getText(finalXpath);
	}

}
