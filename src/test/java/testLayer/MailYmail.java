package testLayer;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.base;
import pageLayer.MailPage;

public class MailYmail {

//	MailPage mp;
//
//	public MailYmail() {
//
//		super();
//
//	}
//
//	@BeforeMethod
//	public void initialize() throws IOException {
//
//		initializeDriver();
//
//		mp = new MailPage();
//
//	}
//
//	@Test
//	public void Search() {
//
//		System.out.println(driver.getTitle()); // Validating page title is correct
//
//		System.out.println(driver.getCurrentUrl()); // Validating if landed on the correct url
//
//		mp.Search();
//		mp.ClickOnSubmit();
//
//		String searchtext = driver.findElement(By.xpath("//*[@id=\"app\"]/section/div[2]/div[2]/ul/li[1]/a")).getText();
//		System.out.println("The text searched for is " + searchtext);
//
//	}
//
//	@Test
//	public void FetchEmail() {
//
//		DateFormat dateFormat = new SimpleDateFormat("dd");
//		Date date = new Date(); // Get current date
//		String CurrentDate = dateFormat.format(date);
//		System.out.println("Today's date is " + CurrentDate);
//
//		int count = driver.findElements(By.xpath("//*[text()='9:45 AM']")).size();
//		System.out.println("Number of mails today with this subject: " + count);
//
//	}

}
