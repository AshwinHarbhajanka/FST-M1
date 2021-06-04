package testNGTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Activity7 {
	
	@DataProvider(name="Authentication")
    public static Object[][] credentials() {
		return new Object[][] {{"admin","password"}};
    }
	WebDriver driver;
  
	
	WebDriverWait wait;
	
	@AfterMethod
	  public void afterMethod() {
		  driver.close();
	  }
	
  @BeforeMethod
  public void beforeMethod() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 15);
		driver.get("https://www.training-support.net/selenium/login-form");
  }

  @Test(dataProvider = "Authentication")
public void login(String username, String password) {
	  driver.findElement(By.id("username")).sendKeys(username);
	  driver.findElement(By.id("password")).sendKeys(password);
	  driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/button")).click();
	  String message = driver.findElement(By.id("action-confirmation")).getText();
	  System.out.println(message);
	  Assert.assertEquals(message, "Welcome Back, admin");
}

}
