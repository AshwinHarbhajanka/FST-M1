package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity6 {

	WebDriver driver;
	WebDriverWait wait;

	@Test
	public void sixthTest() {
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
		driver.findElement(By.id("btnLogin")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"menu_directory_viewDirectory\"]")));
		driver.findElement(By.xpath("//*[@id=\"menu_directory_viewDirectory\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"menu_directory_viewDirectory\"]/b")).click();
		String heading = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[1]/h1")).getText();
		System.out.println(heading);
		Assert.assertEquals(heading, "Search Directory");
	}

	@BeforeMethod
	public void beforeMethod() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 15);
		driver.get("http://alchemy.hguy.co/orangehrm");
	}

	  @AfterMethod 
	  public void afterMethod(){ 
		  driver.quit(); 
		  }
}
