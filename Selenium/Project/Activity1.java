package activities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
	WebDriver driver;
	WebDriverWait wait;
	
	@Test
	public void firstTest() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "OrangeHRM");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 15);
		driver.get("http://alchemy.hguy.co/orangehrm");
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
