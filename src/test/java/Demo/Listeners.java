package Demo;


import java.io.File;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners extends BaseClass implements ITestListener {

	ExtentReports report; // Global variable
	ExtentTest test;  // Global variable
	
	@Override
	public void onTestStart(ITestResult result) { // amazon
		// Step 3 : Create a test Method dusring the Execution 
		test = report.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// Step 4 : i need to declare its Pass the script
		test.log(Status.PASS, result.getMethod().getMethodName()+" - is Passed");  // Amazon - is Passed
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		// step 5 : Create a Screenshot Folder / File & declare where screnshot should sabe
		
		test.log(Status.FAIL, result.getMethod().getMethodName()+" - is Failed");
		test.log(Status.FAIL, result.getThrowable());
		
		String testName = result.getMethod().getMethodName(); // amazon
		
		Random r = new Random();
		int num = r.nextInt(10000);
		
		Date d = new Date();
		// System.out.println(d);		
		String date[] = d.toString().split(" ");
		String month = date[1];
		String date1 = date[2];
		String time = date[3].replace(":", "-");
		String year = date[5];
		String finalDate = date1+" "+month+" "+year+" "+time;
		
		TakesScreenshot tss = (TakesScreenshot) driver;  // type
		File src = tss.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/"+testName+"-"+num+"-"+finalDate+".png");  // screenshot folder -> Amazon.png + random + system
		String path = dest.getAbsolutePath(); // c:/Noor/user/ 
		//     ./screenshot/screen.png
		
		try {
			FileUtils.copyFile(src, dest);
			test.addScreenCaptureFromPath(path);
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		// Step 6 : skip method name
		test.log(Status.SKIP, result.getMethod().getMethodName()+" - is Skipped");
		test.log(Status.SKIP, result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		// step 1 : ExtentReports Configuration
		
		Random r = new Random();
		int num = r.nextInt(10000);
		
		Date d = new Date();
		// System.out.println(d);		
		String date[] = d.toString().split(" ");
		String month = date[1];
		String date1 = date[2];
		String time = date[3].replace(":", "-");
		String year = date[5];
		String finalDate = date1+" "+month+" "+year+" "+time;
		
		ExtentSparkReporter htmlReport = new ExtentSparkReporter( new File("./ExtentReportsFile/ExtentReport-"+num +" "+finalDate+".html"));
		htmlReport.config().setDocumentTitle("ExtentReport - TestNG");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Regression Testing");
		
		// step 2 : Attached HTML / Newly Created File.html
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("OS", "Windows 10 Pro");
		report.setSystemInfo("Environment", "Testing / QA");
		report.setSystemInfo("URL", "Actitime / VTiger.com");
		report.setSystemInfo("Reporter Name", "Veera");
		report.setSystemInfo("Support", "Asma & Yogini");
	}

	@Override
	public void onFinish(ITestContext context) {
		// Step 7 : flush
		report.flush();
	}

	
	
}
