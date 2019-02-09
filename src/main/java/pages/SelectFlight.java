package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class SelectFlight extends TestBase{

	@FindBy(name="reserveFlights")
	WebElement btncountinue;

	//Initializing PageObjects
	public SelectFlight() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnCountinue() {
		btncountinue.click();
	}
}