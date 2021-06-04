package testNGTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity6 {
	
	WebDriver driver;
	WebDriverWait wait;
	
  @AfterClass
  public void afterClass() {
	  driver.close();
  }
  
  @BeforeClass
  public void beforeClass() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 15);
		driver.get("https://www.training-support.net/selenium/login-form");
  }

  @Test
  @Parameters({"username", "password"})
  public void login(String username, String password) {
	  driver.findElement(By.id("username")).sendKeys(username);
	  driver.findElement(By.id("password")).sendKeys(password);
	  driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/button")).click();
	  String message = driver.findElement(By.id("action-confirmation")).getText();
	  System.out.println(message);
	  Assert.assertEquals(message, "Welcome Back, admin");
	  
	  
  }

}
