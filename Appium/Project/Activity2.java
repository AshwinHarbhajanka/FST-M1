package activities;

import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
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

public class Activity2 {

	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;

	@Test
	public void keep() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("new_note_button")));
		driver.findElement(By.id("new_note_button")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("editable_title")));
		driver.findElement(By.id("editable_title")).sendKeys("Appium Project");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("edit_note_text")));
		driver.findElement(By.id("edit_note_text")).sendKeys("Appium project test notes content");
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("index_note_title")));
		String s = driver.findElement(By.id("index_note_title")).getText();
		System.out.println(s);
		Assert.assertEquals(s, "Appium Project");
	}

	@BeforeMethod
	public void beforeMethod() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceId", "emulator-5554");
		caps.setCapability("deviceName", "Pixel 4 API 28");
		caps.setCapability("platformName", "android");
		caps.setCapability("appPackage", "com.google.android.keep");
		caps.setCapability("appActivity", "com.google.android.keep.activities.BrowseActivity");
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
