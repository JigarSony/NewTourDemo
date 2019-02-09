package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class Bookaflights extends TestBase {

	@FindBy(name="passFirst0")
	WebElement paxF1;
	
	@FindBy(name="passLast0")
	WebElement paxL1;
	
	@FindBy(name="creditCard")
	WebElement ddcctype;
	
	@FindBy(name="creditnumber")
	WebElement txtcreditnumber;
	
	@FindBy(name="cc_exp_dt_mn")
	WebElement ddccexpmn;
	
	@FindBy(name="cc_exp_dt_yr")
	WebElement ddccexpyr;
	
	@FindBy(name="cc_frst_name")
	WebElement txtccfname;
	
	@FindBy(name="cc_mid_name")
	WebElement txtccmname;
	
	@FindBy(name="cc_last_name")
	WebElement txtcclname;
	
	@FindBy(name="cc_mid_name")
	WebElement btnbuyFlights;
	
	public void clickOnFlight() {
		btnbuyFlights.click();
	}
	public void fillDetails() {
		paxF1.sendKeys("Vimal");
		paxL1.sendKeys("Pan");
		
		Select CardType = new Select(driver.findElement(By.name("creditCard")));
		CardType.selectByValue("IK");
		
		txtcreditnumber.sendKeys("4111111111111111");
		
		Select Cardexpmnth = new Select(driver.findElement(By.name("cc_exp_dt_mn")));
		Cardexpmnth.selectByVisibleText("10");

		Select Cardexpyear = new Select(driver.findElement(By.name("cc_exp_dt_yr")));
		Cardexpyear.selectByVisibleText("2010");

		txtccfname.sendKeys("Vimal");

		txtccmname.sendKeys("P");

		txtcclname.sendKeys("Panchal");
		clickOnFlight();
	}
}
