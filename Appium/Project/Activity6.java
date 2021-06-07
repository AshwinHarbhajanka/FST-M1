package activities;

import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Activity6 {

	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;

	@Test
	public void chrome3() {
		driver.get("https://www.training-support.net/selenium");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@text='Selenium']")));
		System.out.println(driver.findElement(By.xpath("//android.view.View[@text='Selenium']")).getText());
		driver.findElement(MobileBy
				.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollTextIntoView(\"Popups\")"))
				.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@text='Popups']")));
		System.out.println(driver.findElement(By.xpath("//android.view.View[@text='Popups']")).getText());
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@text='Sign In']")));
		driver.findElement(By.xpath("//android.widget.Button[@text='Sign In']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("//android.widget.Button[@text='Log in']")).click();
		String s1 = driver.findElement(By.id("action-confirmation")).getText();
		System.out.println(s1);
		Assert.assertEquals(s1, "Welcome Back, admin");
		driver.findElement(By.xpath("//android.widget.Button[@text='Sign In']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
		driver.findElement(By.id("username")).sendKeys("Admin");
		driver.findElement(By.id("password")).sendKeys("Password");
		driver.findElement(By.xpath("//android.widget.Button[@text='Log in']")).click();
		String s2 = driver.findElement(By.id("action-confirmation")).getText();
		System.out.println(s2);
		Assert.assertEquals(s2, "Invalid Credentials");
	}

	@BeforeMethod
	public void beforeMethod() throws MalformedURLException {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel 4 API 28");
		caps.setCapability("platformName", "android");
		caps.setCapability("appPackage", "com.android.chrome");
		caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		caps.setCapability("noReset", true);

		URL appServer = new URL("http://localhost:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, caps);
		wait = new WebDriverWait(driver, 10);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
