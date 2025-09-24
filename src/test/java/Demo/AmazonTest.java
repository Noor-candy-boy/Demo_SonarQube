package Demo;

import org.testng.Reporter;
import org.testng.annotations.Test;


public class AmazonTest extends BaseClass {
	
	@Test
	public void amazon() {
		Reporter.log("Amazon" , true);
		driver.get("https://www.amazon.in/");
	}
	
}
