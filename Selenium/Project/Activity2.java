package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {

	WebDriver driver;
	WebDriverWait wait;
	
	@Test
	public void secondTest() {
		System.out.println(driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img")).getAttribute("src"));
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
