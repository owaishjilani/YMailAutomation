package base;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

//import com.relevantcodes.extentreports.LogStatus;

public class base {
	
	public WebDriver driver;
	public Properties prop;
	public URL url;
	
	public ExtentReports extent;
	public ExtentTest extentTest;
	
//	@BeforeTest
//	public void setExtent() {
//		
//		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html", true);
//		extent.addSystemInfo("User Name", "Owaish Mustafa");
//	}
//	
//	@AfterTest
//	public void endReport() {
//		
//		extent.flush();
//		extent.close();
//		
//	}
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		
		String dateName = new SimpleDateFormat("ddMMMyyyy@hhmmss").format(new Date()); // Defining date to appear with the screenshot
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// After execution, FailedTestsScreenshots folder can be seen
		// Under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
		
	}
	
	public WebDriver initializeDriver() throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\owamusta\\eclipse-workspace\\Assignment\\src\\main\\java\\data.properties");
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		
		if(browserName.equals("chrome")) {
			
			// execute in chrome driver
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\owamusta\\Downloads\\chromedriver.exe");
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications"); // Block notifications/popup
			
			driver = new ChromeDriver(options);
			url = new URL("https://login.yahoo.com/?.src=ym&.lang=en-US&.intl=us&.done=https%3A%2F%2Fmail.yahoo.com%2Fd");
			
		}
		
		else if(browserName.equals("IE")) {
			
			// execute in IE
			System.setProperty("webdriver.ie.driver", "C:\\Users\\owamusta\\Downloads\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
		
	}
	
//	@AfterMethod
//	public void tearDown(ITestResult result) throws IOException {
//		
//		if(result.getStatus()==TestResult.FAILURE) {
//			
//			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED: " + result.getName()); // to add name in extent report
//			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED: " + result.getThrowable()); // to add error/exception in extent report
//			
//			String screenshotPath = base.getScreenshot(driver, result.getName());
//			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); // to add screenshot in extent report
//			
//		}
//		
//		else if(result.getStatus()==ITestResult.SKIP) {
//			
//			extentTest.log(LogStatus.SKIP, "TEST CASE SKIPPED: " + result.getName());
//			
//		}
//		
//		extent.endTest(extentTest); // ending test
//		
//	}

}
