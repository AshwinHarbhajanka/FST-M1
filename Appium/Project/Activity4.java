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

public class Activity4 {

	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;

	@Test
	public void chrome() {
		driver.get("https://www.training-support.net/selenium");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@text='Selenium']")));
		System.out.println(driver.findElement(By.xpath("//android.view.View[@text='Selenium']")).getText());
		driver.findElement(MobileBy
				.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollTextIntoView(\"To-Do List\")"))
				.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@text='To-Do List']")));
		System.out.println(driver.findElement(By.xpath("//android.view.View[@text='To-Do List']")).getText());
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("taskInput")));
		MobileElement input = driver.findElement(By.id("taskInput"));
		MobileElement save = driver.findElement(By.xpath("//android.widget.Button[@text='Add Task']"));
		String s1 = "Add tasks to list";
		String s2 = "Get number of tasks";
		String s3 = "Clear the list";
		input.sendKeys(s1);
		save.click();
		input.sendKeys(s2);
		save.click();
		input.sendKeys(s3);
		save.click();
		System.out.println(s1 + "\n" + s2 + "\n" + s3);
		MobileElement one = driver.findElement(By.xpath("//android.view.View[@text='Add tasks to list']"));
		MobileElement two = driver.findElement(By.xpath("//android.view.View[@text='Get number of tasks']"));
		MobileElement three = driver.findElement(By.xpath("//android.view.View[@text='Clear the list']"));
		one.click();
		two.click();
		three.click();
		Assert.assertEquals(one.getText(), s1);
		Assert.assertEquals(two.getText(), s2);
		Assert.assertEquals(three.getText(), s3);
		driver.findElement(By.xpath("android.view.View[@text='Clear List']")).click();

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
