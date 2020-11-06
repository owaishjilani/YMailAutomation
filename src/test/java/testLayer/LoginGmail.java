package testLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pageLayer.LoginPageGmail;

public class LoginGmail {
	
	@Test
	public void Login() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\owamusta\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.manage().window().maximize();

		LoginPageGmail lp = new LoginPageGmail(driver);
		
		lp.Language().click();
		Thread.sleep(2000);
		lp.English().click();
		
		Thread.sleep(3000);
		
		lp.EmailId().sendKeys("owaish.sapient");
		lp.Next().click();
		
		Thread.sleep(3000);
		
		lp.Password().sendKeys("+971502866422");
		lp.Submit().click();
		
		Thread.sleep(3000);
		
		lp.FirstName().sendKeys("Owaish Mustafa");
		lp.LastName().sendKeys("Jilani");
		lp.NextInfo().click();
		
		Thread.sleep(3000);
		
		lp.Verification().click();
		
		Thread.sleep(30000);
		
		lp.Verified().click();
		
		Thread.sleep(3000);
		
		lp.ChooseAccount().click();
		
	}

}
