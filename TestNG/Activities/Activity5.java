package testNGTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Activity5 {

	WebDriver driver;
	WebDriverWait wait;
	
  @AfterTest(alwaysRun = true)
  public void afterTest() {
	  driver.close();
  }
  
  @BeforeTest(alwaysRun = true)
  public void beforeTest() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 15);
		driver.get("https://www.training-support.net/selenium/target-practice");
  }
  
  @Test (groups = {"button"})
  public void buttonTest1() {
	  String buttonText = driver.findElement(By.cssSelector("button.ui.olive.button")).getText();
	  System.out.println(buttonText);
	  Assert.assertEquals(buttonText, "Olive");
  }
  
  @Test (groups = {"button"})
  public void buttonTest2() {
	  String buttonColor = driver.findElement(By.cssSelector("button.ui.teal.button")).getCssValue("color");
	  System.out.println(buttonColor);
	  Assert.assertEquals(buttonColor, "rgb(255, 255, 255)");
  }
  
  @Test (groups = {"header"})
  public void headerTest1() {
	  String h3 = driver.findElement(By.id("third-header")).getText();
	  System.out.println(h3);
	  Assert.assertEquals(h3, "Third header");
  }
  
  @Test (groups = {"header"})
  public void headerTest2() {
	  String h5color = driver.findElement(By.cssSelector("h5.ui.green.header")).getCssValue("color");
	  System.out.println(h5color);
	  Assert.assertEquals(h5color, "rgb(33, 186, 69)");
  }

  @Test (groups = {"header","button"})
  public void titleTest() {
	  String title = driver.getTitle();
	  System.out.println(title);
	  Assert.assertEquals(title, "Target Practice");
  }

}
