package Demo;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	static {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	}

	public static WebDriver driver;

	@BeforeClass
	public void openBrowser() {
		Reporter.log("openBrowser", true);
		driver = new ChromeDriver();
		
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterClass
	public void closeBrowser() {
		Reporter.log("closeBrowser", true);
		driver.close();
	}

	@BeforeMethod
	public void login() throws IOException {
		Reporter.log("URL & Login" , true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void logout() {
		Reporter.log("logout", true);
	}

	
}
