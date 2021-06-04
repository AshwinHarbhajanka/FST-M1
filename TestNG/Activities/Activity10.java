package testNGTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class Activity10 {
	
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	
	  @Test
	  public void minValue() {
	  WebElement slider = driver.findElement(By.id("slider"));
	  builder.clickAndHold(slider).moveByOffset(-80,0).release().build().perform();
	  String min = driver.findElement(By.id("value")).getText(); 
	  System.out.println(min); 
	  Assert.assertEquals(min, "0");
	  Reporter.log("Minimum Value is: " + min);
	 } 
	
	  @Test 
	  public void maxValue() { 
	  WebElement slider = driver.findElement(By.id("slider"));
	  builder.clickAndHold(slider).moveByOffset(80, 0).release().build().perform();
	  String max = driver.findElement(By.id("value")).getText();
	  System.out.println(max); 
	  Assert.assertEquals(max, "100");
	  Reporter.log("Maximum Value is: " + max);
	  }
	 
	  @Test
	  public void middleValue() {
		  WebElement slider = driver.findElement(By.id("slider"));
		  slider.click(); 
		  String mid = driver.findElement(By.id("value")).getText(); 
		  System.out.println(mid); 
		  Assert.assertEquals(mid, "50");
		  Reporter.log("Middle Value is: " + mid);
		  }
	 
	  @Test
	  public void valueThirty() {
		  WebElement slider = driver.findElement(By.id("slider"));
		  builder.clickAndHold(slider).moveByOffset(-32,0).release().build().perform();
		  String value = driver.findElement(By.id("value")).getText(); 
		  System.out.println(value);
		  Assert.assertEquals(value, "30");
		  Reporter.log("Value: " + value);
	  }
	  
	  @Test
	  public void valueEighty() {
		  WebElement slider = driver.findElement(By.id("slider"));
		  builder.clickAndHold(slider).moveByOffset(48,0).release().build().perform();
		  String value = driver.findElement(By.id("value")).getText(); 
		  System.out.println(value);
		  Assert.assertEquals(value, "80");
	      Reporter.log("Value: " + value);
	  }
	 
  
  @BeforeClass
  public void beforeClass() {
		driver = new FirefoxDriver();
		Reporter.log("Starting Test");
		wait = new WebDriverWait(driver, 15);
		builder = new Actions(driver);
		driver.get("https://www.training-support.net/selenium/sliders");
		Reporter.log("Opened Browser");
		String title = driver.getTitle();
		System.out.println(title);
		Reporter.log("Page title is: "+title);
  }
	
	 @AfterClass 
	 public void afterClass() {
	 Reporter.log("Ending Test");
	 driver.close(); 
	 }

}
