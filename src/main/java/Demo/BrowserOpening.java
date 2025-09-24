package Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserOpening {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		//options.addExtensions(new File("./path/to/extension.crx"));
		//options.setBinary(new File("./path/to/edge"));
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Thread.sleep(5000);
		driver.get("https://www.google.com/");
		Thread.sleep(5000);
		driver.close();
		

	
//		System.setProperty("webdriver.firefox.driver" , "./drivers/geckodriver.exe");
//		WebDriver driver2 = new FirefoxDriver();
//		driver2.get("https://www.google.com/");
//		
//		
//		System.setProperty("webdriver.chrome.driver" , "./drivers/chromedriver.exe");
//		WebDriver driver3 = new ChromeDriver();
//		driver3.get("https://www.google.com/");
		
		
	}

}
