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

public class Activity1 {

	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;

	@Test
	public void tasks() {

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tasks_fab")));
		MobileElement newTask = driver.findElement(By.id("tasks_fab"));
		newTask.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add_task_title")));
		MobileElement tasktitle = driver.findElement(By.id("add_task_title"));
		tasktitle.sendKeys("Complete Activity with Google Tasks");
		MobileElement saveButton = driver.findElement(By.id("add_task_done"));
		saveButton.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tasks_fab")));
		newTask.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add_task_title")));
		tasktitle.sendKeys("Complete Activity with Google Keep");
		saveButton.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tasks_fab")));
		newTask.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add_task_title")));
		tasktitle.sendKeys("Complete the second Activity with Google Keep");
		saveButton.click();

		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//android.widget.FrameLayout[@content-desc='Complete Activity with Google Tasks']")));
		String s1 = driver
				.findElement(
						By.xpath("//android.widget.FrameLayout[@content-desc='Complete Activity with Google Tasks']"))
				.getAttribute("content-desc");
		String s2 = driver
				.findElement(
						By.xpath("//android.widget.FrameLayout[@content-desc='Complete Activity with Google Keep']"))
				.getAttribute("content-desc");
		String s3 = driver
				.findElement(By.xpath(
						"//android.widget.FrameLayout[@content-desc='Complete the second Activity with Google Keep']"))
				.getAttribute("content-desc");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		Assert.assertEquals(s1, "Complete Activity with Google Tasks");
		Assert.assertEquals(s2, "Complete Activity with Google Keep");
		Assert.assertEquals(s3, "Complete the second Activity with Google Keep");
	}

	@BeforeMethod
	public void beforeMethod() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceId", "emulator-5554");
		caps.setCapability("deviceName", "Pixel 4 API 28");
		caps.setCapability("platformName", "android");
		caps.setCapability("appPackage", "com.google.android.apps.tasks");
		caps.setCapability("appActivity", "com.google.android.apps.tasks.ui.TaskListsActivity");
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
