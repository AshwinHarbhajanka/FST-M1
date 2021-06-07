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

public class Activity3 {

	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;

	@Test
	public void keep2() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("new_note_button")));
		driver.findElement(By.id("new_note_button")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("editable_title")));
		driver.findElement(By.id("editable_title")).sendKeys("Appium Project");
		driver.findElement(By.id("edit_note_text")).sendKeys("Appium project test notes content");
		driver.findElement(By.id("menu_switch_to_list_view")).click();
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Pick a date & time']")));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Pick a date & time']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='7:00 PM']")));
		driver.findElement(By.xpath("//android.widget.TextView[@text='7:00 PM']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Evening']")));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Evening']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("save")));
		driver.findElement(By.id("save")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']")));
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']")));
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("drawer_navigation_reminders")));
		driver.findElement(By.id("drawer_navigation_reminders")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("index_note_title")));
		String s = driver.findElement(By.id("index_note_title")).getText();
		String s1 = driver.findElement(By.id("reminder_chip_text")).getText();
		System.out.println(s);
		System.out.println(s1);
		Assert.assertEquals(s, "Appium Project");
		Assert.assertEquals(s1, "Today, 6:00 PM");

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
