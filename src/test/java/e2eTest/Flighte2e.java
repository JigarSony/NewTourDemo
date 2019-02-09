package e2eTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.TestBase;
import pages.*;

public class Flighte2e extends TestBase{
	
	Login loginpage;
	Flightfinder flightfinderpage;
	Bookaflights bookaflightpage;
	SelectFlight selectflightpage;
	
	public Flighte2e() {
		super();
	}
	
	@BeforeTest
	public void setUp() {
		initialization();
		
		loginpage = new Login();
		flightfinderpage = new Flightfinder();
		selectflightpage = new SelectFlight();
		bookaflightpage = new Bookaflights();
	}
	
	@Test
	public void flighte2eTest() throws InterruptedException {
		loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		flightfinderpage.findflight();
		selectflightpage.clickOnCountinue();
		Thread.sleep(1000000);
		bookaflightpage.fillDetails();
	}
	
	@AfterClass 
	public void tearDown() {
		driver.close();
		System.out.println("closePass");
	}
}
