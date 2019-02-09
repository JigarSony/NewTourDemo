package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.netflights.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static String projectpath;
	public static WebDriverWait wait;

	public TestBase(){

		projectpath = System.getProperty("user.dir");
		//System.out.println("Projectpath is " + projectpath);

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(projectpath+"/src/main/java/config/config.properties");
			//F:\Automation\Selenium\newtourDemo\src\main\java\config\config.properties
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");

		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectpath+"/drivers/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if(browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", projectpath+"/drivers/geckodriver/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else if(browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", projectpath +"/drivers/iedriver/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		//driver.get("https://nfdv2_feature.netflights.com");
	}
}


