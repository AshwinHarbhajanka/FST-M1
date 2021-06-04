package testNGTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;

public class Activity2 {
	
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
	driver.get("https://www.training-support.net/selenium/target-practice");
  }
  
  @Test
  public void secondTest1() {
	  String title = driver.getTitle();
	  System.out.println(title);
	  Assert.assertEquals(title, "Target Practice");
  }
  
  @Test
  public void secondTest2() {
	  String button = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[3]")).getText();
	  System.out.println(button);
	  Assert.assertEquals(button, "Blue");
  }
  
  @Test (enabled = false)
  public void secondTest3() {
	  System.out.println("This is the 3rd test");
  }

  @Test
  public void secondTest4() throws SkipException {
	  throw new SkipException("The method #4 is skipped");
  }

}
