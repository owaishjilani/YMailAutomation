package pageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPageYmail {


	WebDriver driver;
	
	public LoginPageYmail(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	// Login
	
	@FindBy(id="login-username")
	WebElement username;
	
	@FindBy(xpath="//*[@id=\"login-signin\"]")
	WebElement next;
	
	@FindBy(id="login-passwd")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"challenge-selector-challenge\"]/form/ul/li[1]/button")
	WebElement verification;
	
	@FindBy(id="verify-code-button")
	WebElement verify;
	
	public WebElement EmailId() {

		return username;

	}
	
	public WebElement Next() {

		return next;

	}

	public WebElement Password() {

		return password;

	}
	
	public WebElement Verification() {

		return verification;

	}
	
	public WebElement Verify() {

		return verify;

	}
	
	// Search
	
	By search = By.xpath("//*[@id=\"mail-search\"]/div/div/div[1]/ul/li/div/div/input[1]");
	By submit = By.xpath("//*[@id=\"mail-search\"]/div/button");
	
	public WebElement Search() {

		return driver.findElement(search);

	}
	
	public WebElement Submit() {

		return driver.findElement(submit);

	}
	
	// Fetch email count for different scenarios
	
	@FindBy(xpath = "//*[@id=\"mail-search\"]/div/div/div[2]/button/span")
	WebElement filter;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[7]/div/div/div/div[6]/div/div/div[1]/div/span")
	WebElement arrow;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[7]/div/div/div/div[6]/div/div/div[2]/ul/li[4]/a")
	WebElement custom;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[8]/div/div[1]/div/div/div[2]/div[2]/div[1]/div[2]/span")
	WebElement from;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[8]/div/div[1]/div/div/div[2]/div[2]/div[1]/div[4]/span")
	WebElement to;
	
	public WebElement Filter() {
		
		return filter;
		
	}
	
	public WebElement Accordian() {
		
		return arrow;
		
	}
	
	public WebElement Dates() {
		
		return custom;
		
	}
	
	public WebElement FromDate() {
		
		return from;
		
	}
	
	public WebElement ToDate() {
		
		return to;
		
	}

}
