package testNGTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class Activity9 {
	
	WebDriver driver;
	WebDriverWait wait;
	
  @AfterTest
  public void afterTest() {
	  Reporter.log("Ending Test");
	  driver.close();
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  Reporter.log("Testcase setup started");
	  driver.switchTo().defaultContent();
  }
  
  @BeforeTest
  public void beforeTest() {
		driver = new FirefoxDriver();
		Reporter.log("Starting Test");
		wait = new WebDriverWait(driver, 15);
		driver.get("https://www.training-support.net/selenium/javascript-alerts");
		Reporter.log("Opened Browser");
		String title = driver.getTitle();
		System.out.println(title);
		Reporter.log("Page title is: "+title);
  }
  
  @Test
  public void confirmAlertTestcase() {
	  driver.findElement(By.id("confirm")).click();
	  Reporter.log("confirm alert opened");
	  Alert confirm = driver.switchTo().alert();
	  Reporter.log("confirm alert in focus");
	  String ct = confirm.getText();
	  Reporter.log("alert text is: "+ct);
	  confirm.accept();
	  Reporter.log("confirm alert closed");
	  System.out.println(ct);
	  Assert.assertEquals(ct, "This is a JavaScript Confirmation!");
	  Reporter.log("testcase ended");
  }

  @Test
  public void promptAlertTestcase() {
	  driver.findElement(By.id("prompt")).click();
	  Reporter.log("prompt alert opened");
	  Alert prompt = driver.switchTo().alert();
	  Reporter.log("prompt alert in focus");
	  prompt.sendKeys("Wonderful");
	  Reporter.log("text entered in prompt alert");
	  String pt = prompt.getText();
	  Reporter.log("alert text is: "+pt);
	  prompt.accept();
	  Reporter.log("prompt alert closed");
	  System.out.println(pt);
	  Assert.assertEquals(pt, "This is a JavaScript Prompt!");
	  Reporter.log("testcase ended");
  }

  @Test
  public void simpleAlertTestcase() {
	  driver.findElement(By.id("simple")).click();
	  Reporter.log("simple alert opened");
	  Alert simple = driver.switchTo().alert();
	  Reporter.log("simple alert in focus");
	  String st = simple.getText();
	  Reporter.log("alert text is: "+st);
	  simple.dismiss();
	  Reporter.log("simple alert closed");
	  System.out.println(st);
	  Assert.assertEquals(st, "This is a JavaScript Alert!");
	  Reporter.log("testcase ended");
  }

}
