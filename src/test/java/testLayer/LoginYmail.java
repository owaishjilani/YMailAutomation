package testLayer;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.base;
import pageLayer.LoginPageYmail;

public class LoginYmail extends base {
	
	LoginPageYmail lpy = new LoginPageYmail(driver);
	
	@BeforeTest
	public void initialize() throws IOException{
		
		driver = initializeDriver();
		
	}
	
	@Test(dataProvider = "getData")
	public void Login(String Username, String Password, String Text) throws InterruptedException {

		// Logging into the account
		// Login page is implemented using Page Object Factory

		lpy.EmailId().sendKeys("owaishmustafa@ymail.com");
		lpy.Next().click();

		Thread.sleep(3000);

		lpy.Password().sendKeys("BissiFeb2019!");
		lpy.Next().click();

		Thread.sleep(3000);

		lpy.Verification().click();

		Thread.sleep(30000);

		lpy.Verify().click();

		Thread.sleep(10000);
		
		String title = driver.getTitle();

		System.out.println(title); // Validating page title is correct

		String Wanted = "folders";
		String URL = driver.getCurrentUrl();

		System.out.println(URL); // Validating if landed on the correct url

		if (URL.contains(Wanted)) {

			System.out.println("Signed into the account");

		}

		else {

			System.out.println("Sign in failed");

		}

		// Search
		// Mail page is implemented in Page Object Model

		lpy.Search().sendKeys("Check out delicious lunch options");
		lpy.Submit().click();
		
		String searchtext = driver.findElement(By.xpath("//*[@id=\"app\"]/section/div[2]/div[2]/ul/li[1]/a")).getText();
		System.out.println("The text searched for is " + searchtext);

		Thread.sleep(3000);
		
		lpy.Filter().click();
		
		lpy.Accordian().click();
		
		lpy.Dates().click();
		
		lpy.FromDate().click();
		
		lpy.ToDate().click();

		int count = driver.findElements(By.xpath("//*[text()='Oct 25']")).size();
		System.out.println("Number of mails today with this subject: " + count);
		
		DateFormat dateFormat = new SimpleDateFormat("dd");
		Date date = new Date(); // Get current date
		String CurrentDate = dateFormat.format(date);
		System.out.println("Today's date is " + CurrentDate);
		
//		List<WebElement> mails = driver.findElements(By.xpath("//*[@id=\"mail-app-component\"]/div[1]/div/div[3]/div/div[1]/div[3]"));
//		for (WebElement mail : mails){
//			
//			// String mails = driver.findElement(By.xpath("//*[@id=\"mail-app-component\"]/div[1]/div/div[3]/div/div[1]/div[3]/div/div[1]/ul/li["+i+"]")).getText();
//			// System.out.println(mails);
//			
//			if(mail.getText().equalsIgnoreCase("Check out delicious lunch options" + CurrentDate)) {
//				
//				mail.getSize();
//				
//			}
//		   
//		}

	}

}
