package flighte2e;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class sampleTestNG {

	static WebDriver driver=null; 

	@BeforeTest
	public void setUp() {
		//project path
		String projectpath = System.getProperty("user.dir");
		
		//chrome driver initialization
		System.setProperty("webdriver.chrome.driver", projectpath +"//drivers//chromedriver//chromedriver.exe");
		driver = new ChromeDriver();

		//wait and size
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//wait = new WebDriverWait(driver,30);

		//get url
		String url = "http://newtours.demoaut.com";
		driver.get(url);

		driver.findElement(By.name("userName")).sendKeys("jigar.qa");
		driver.findElement(By.name("password")).sendKeys("qajigar.");
		driver.findElement(By.name("login")).click();
	}

	@Test
	public void flighte2e() {
		Select Passengers = new Select(driver.findElement(By.name("passCount")));
		Passengers.selectByValue("4");

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

		driver.findElement(By.name("findFlights")).click();

		driver.findElement(By.name("reserveFlights")).click();

		driver.findElement(By.name("passFirst0")).sendKeys("Vimal");
		driver.findElement(By.name("passLast0")).sendKeys("Pan");
		driver.findElement(By.name("passFirst1")).sendKeys("Vimal");
		driver.findElement(By.name("passLast1")).sendKeys("Pan");
		driver.findElement(By.name("passFirst2")).sendKeys("Vimal");
		driver.findElement(By.name("passLast2")).sendKeys("Pan");
		driver.findElement(By.name("passFirst3")).sendKeys("Vimal");
		driver.findElement(By.name("passLast3")).sendKeys("Pan");

		Select CardType = new Select(driver.findElement(By.name("creditCard")));
		CardType.selectByValue("IK");

		driver.findElement(By.name("creditnumber")).sendKeys("4111111111111111");

		Select Cardexpmnth = new Select(driver.findElement(By.name("cc_exp_dt_mn")));
		Cardexpmnth.selectByVisibleText("10");

		Select Cardexpyear = new Select(driver.findElement(By.name("cc_exp_dt_yr")));
		Cardexpyear.selectByVisibleText("2010");

		driver.findElement(By.name("cc_frst_name")).sendKeys("Vimal");

		driver.findElement(By.name("cc_mid_name")).sendKeys("P");

		driver.findElement(By.name("cc_last_name")).sendKeys("Panchal");

		driver.findElement(By.name("buyFlights")).click();
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		System.out.println("e2e for flight Successfully");
	}
}


