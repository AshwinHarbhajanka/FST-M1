package testNGTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Activity3 {
	
	WebDriver driver;
	WebDriverWait wait;
	
  @AfterTest
  public void afterClass() {
	  driver.close();
  }
  
  @BeforeTest
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  wait = new WebDriverWait(driver, 15);
	  driver.get("https://www.training-support.net/selenium/login-form");
  }

  @Test
  public void thirdTest() {
	  driver.findElement(By.id("username")).sendKeys("admin");
	  driver.findElement(By.id("password")).sendKeys("password");
	  driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/button")).click(); 
	  String message = driver.findElement(By.id("action-confirmation")).getText();
	  System.out.println(message);
	  Assert.assertEquals(message, "Welcome Back, admin");
	  }

}
