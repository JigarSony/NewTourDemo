package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class Flightfinder extends TestBase{

	@FindBy(name="passCount")
	WebElement ddpassengercount;

	@FindBy(name="fromPort")
	WebElement ddfrom;

	@FindBy(name="fromMonth")
	WebElement ddfromMonth;

	@FindBy(name="fromDay")
	WebElement ddfromDay;

	@FindBy(name="toPort")
	WebElement ddtoPort;

	@FindBy(name="toMonth")
	WebElement ddtoMonth;

	@FindBy(name="toDay")
	WebElement ddtoDay;

	@FindBy(name="airline")
	WebElement ddairline;

	@FindBy(name="findFlights")
	WebElement btnfindFlights;


	//Initializing PageObjects
	public Flightfinder() {
		PageFactory.initElements(driver, this);
	}

	public  void ddpasscount() {

		Select Passengers = new Select(driver.findElement(By.name("passCount")));
		Passengers.selectByValue("1");

		Select Departing = new Select(driver.findElement(By.name("fromPort")));
		Departing.selectByValue("London");

		Select Onmonth = new Select(driver.findElement(By.name("fromMonth")));
		Onmonth.selectByValue("11");

		Select Onmday= new Select(driver.findElement(By.name("fromDay")));
		Onmday.selectByValue("12");

		Select Arriving = new Select(driver.findElement(By.name("toPort")));
		Arriving.selectByValue("New York");

		Select Tomonth = new Select(driver.findElement(By.name("toMonth")));
		Tomonth.selectByValue("11");

		Select Today= new Select(driver.findElement(By.name("toDay")));
		Today.selectByValue("24");

		Select air= new Select(driver.findElement(By.name("airline")));
		air.selectByVisibleText("Blue Skies Airlines");
		
	}
	
	public void clickOnFindflight() {
		btnfindFlights.click();
	}

	public void findflight() {
		ddpasscount();
		clickOnFindflight();
	}
	
}

