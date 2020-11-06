package pageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageGmail {

	public LoginPageGmail(WebDriver driver) {

		this.driver = driver;

	}

	WebDriver driver;
	
	By language = By.xpath("//*[@id=\"lang-chooser\"]/div[1]/div[1]/div[2]");
	By english = By.xpath("//*[@id=\"lang-chooser\"]/div[2]/div[11]");
	
	By username = By.xpath("//*[@id=\"identifierId\"]");
	By next = By.xpath("//*[@type=\"button\"]");
	
	By password = By.xpath("//*[@id=\"recoveryIdentifierId\"]");
	By submit = By.xpath("//*[@id=\"queryPhoneNext\"]/div/button/div[2]");
	
	By firstname = By.xpath("//*[@id=\"firstName\"]");
	By lastname = By.id("lastName");
	By nextinfo = By.xpath("//*[@id=\"collectNameNext\"]/div/button/div[2]");
	
	By verification = By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/div[2]");
	
	By verified = By.xpath("//*[@id=\"idvPreregisteredPhoneNext\"]/div/button/div[2]");
	
	By chooseaccount = By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div/div/ul/li[1]/div");
	

	public WebElement Language() {

		return driver.findElement(language);

	}
	
	public WebElement English() {

		return driver.findElement(english);

	}
	
	public WebElement EmailId() {

		return driver.findElement(username);

	}
	
	public WebElement Next() {

		return driver.findElement(next);

	}

	public WebElement Password() {

		return driver.findElement(password);

	}
	
	public WebElement Submit() {

		return driver.findElement(submit);

	}
	
	public WebElement FirstName() {

		return driver.findElement(firstname);

	}
	
	public WebElement LastName() {

		return driver.findElement(lastname);

	}
	
	public WebElement NextInfo() {

		return driver.findElement(nextinfo);

	}
	
	public WebElement Verification() {

		return driver.findElement(verification);

	}
	
	public WebElement Verified() {

		return driver.findElement(verified);

	}
	
	public WebElement ChooseAccount() {

		return driver.findElement(chooseaccount);

	}

}
