package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3 {

	WebDriver driver;
	WebDriverWait wait;
	
	@Test
	public void thirdTest() {
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
		driver.findElement(By.id("btnLogin")).click();
		String homepage = driver.getCurrentUrl();
		System.out.println(homepage);
		Assert.assertEquals(homepage,"http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/dashboard");
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
