package testNGTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
	WebDriver driver;
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  driver= new ChromeDriver();
	  driver.get("https://www.training-support.net");
  }

  @Test
  public void firstTest() {
	  System.out.println(driver.getTitle());
	  Assert.assertEquals(driver.getTitle(),"Training Support");
	  driver.findElement(By.id("about-link")).click();
	  System.out.println(driver.getTitle());
	  Assert.assertEquals(driver.getTitle(),"About Training Support");
  }

}
