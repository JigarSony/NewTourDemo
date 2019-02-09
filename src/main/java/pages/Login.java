package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.TestBase;


public class Login extends TestBase {

	@FindBy(name="userName")
	WebElement txtusername;

	@FindBy(name="password")
	WebElement txtpassword;

	@FindBy(name="login")
	WebElement btnlogin;

	//Initializing PageObjects
	public Login() {
		PageFactory.initElements(driver, this);
	}
	
	//Action
	public void login(String username,String password) {
		txtusername.sendKeys(username);
		txtpassword.sendKeys(password);
		btnlogin.click();
	}
}
