package stepDefinitions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base.base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageLayer.LoginPageYmail;

public class stepDefinitionLogin extends base {
	
	@Before
	public void setUP() {
		
		System.out.println("Launch Chrome");
		System.out.println("Enter URL for Yahoo Mail!");
		
	}
	
	@Given("^user navigates to \"([^\"]*)\" site$")
    public void user_navigates_to_something_site(String string1) throws Throwable {
        
		// code to login url		
		driver = initializeDriver();
		driver.get(string1);
		
    }

    @When("^user enters email address as \"([^\"]*)\"$")
    public void user_enters_email_address_as_something(String string2) throws Throwable {
       
    	// code to enter username
    	LoginPageYmail lpy = new LoginPageYmail(driver);
		lpy.EmailId().sendKeys(string2);
    	
    }
    
    @Then("^user clicks on the next button$")
    public void user_clicks_on_the_next_button() throws Throwable {
        
    	// code to click next button
    	LoginPageYmail lpy = new LoginPageYmail(driver);
    	lpy.Next().click();
    	
    	Thread.sleep(3000);
    }

    @When("^user enters password as \"([^\"]*)\"$")
    public void user_enters_password_as_something(String string3) throws Throwable {
        
    	// code to enter password
    	LoginPageYmail lpy = new LoginPageYmail(driver);
    	lpy.Password().sendKeys("BissiFeb2019!");
    }

    @Then("^user clicks on login button$")
    public void user_clicks_on_login_button() throws Throwable {
        
    	// code to click on login button
    	LoginPageYmail lpy = new LoginPageYmail(driver);
    	lpy.Next().click();

		Thread.sleep(10000);
    	
    }

    @And("^user logged in successfully$")
    public void user_logged_in_successfully() throws Throwable {
        
    	// code to validate login
    	LoginPageYmail lpy = new LoginPageYmail(driver);
    	Assert.assertTrue(lpy.Search().isDisplayed());
    	
    	System.out.println(driver.getTitle()); // Validating page title is correct

    	String Wanted = "folders";
		String URL = driver.getCurrentUrl();

		System.out.println(URL); // Validating if landed on the correct url

		if (URL.contains(Wanted)) {

			System.out.println("Signed into the account");

		}

		else {

			System.out.println("Sign in failed");

		}
    	
    }
    
    // Search
    
    @Then("^user searches for \"([^\"]*)\" on the search box$")
    public void user_searches_for_something_on_the_search_box(String string4) throws Throwable {

    	LoginPageYmail lpy = new LoginPageYmail(driver);
    	lpy.Search().sendKeys(string4);
    	
    	Thread.sleep(2000);
        
    }

    @Then("^user clicks on search$")
    public void user_clicks_on_search() throws Throwable {

    	LoginPageYmail lpy = new LoginPageYmail(driver);
    	lpy.Submit().click();
    	
    	Thread.sleep(3000);
        
    }

    @And("^user receives search results$")
    public void user_receives_search_results() throws Throwable {
    	
    	String searchtext = driver.findElement(By.xpath("//*[@id=\"app\"]/section/div[2]/div[2]/ul/li[1]/a")).getText();
		System.out.println("The text searched for is " + searchtext);
		
		Thread.sleep(3000);
        
    }

    @Then("^user fetches email received on \"([^\"]*)\"$")
    public void user_fetches_email_received_on_something(String string5) throws Throwable {
    	
    	LoginPageYmail lpy = new LoginPageYmail(driver);
    	lpy.Filter().click();
		lpy.Accordian().click();
		
		lpy.Dates().click();
//		lpy.FromDate().click();
//		lpy.ToDate().click();		
    	
    	DateFormat dateFormat = new SimpleDateFormat("MMM dd");
		Date date = new Date(); // Get current date
		String CurrentDate = dateFormat.format(date); // Formating current date
		System.out.println("Today's date is " + CurrentDate);
    	
    	int count = driver.findElements(By.xpath("//*[text()='"+CurrentDate+"']")).size();
    	System.out.println("Number of mails today with this subject: " + count);
        
    }

    @Then("^user fetches email received last \"([^\"]*)\"$")
    public void user_fetches_email_received_last_something(String string6) throws Throwable {
    	
    	System.out.println("Number of mails received in the last 10 days with this subject: ");
        
    }
    
//    @After
//    public void tearDown() {
//    	
//    	System.out.println("Close Browser");
//    	driver.quit();
//    	
//    }

}
