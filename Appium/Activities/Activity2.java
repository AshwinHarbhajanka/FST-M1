package activities;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Activity2 {

	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;

	@Test
	public void setup() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://training-support.net/");
		String title1 = driver.findElement(By.xpath("//android.view.View[@text='Training Support']")).getText();
		System.out.println(title1);
		driver.findElement(By.xpath("//android.view.View[@text='About Us']")).click();
		String title2 = driver.findElement(By.xpath("//android.view.View[@text='About Us']")).getText();
		System.out.println(title2);
		Assert.assertEquals(title1, "Training Support");
		Assert.assertEquals(title2, "About Us");

	}

	@BeforeMethod
	public void beforeMethod() throws IOException {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceId", "emulator-5554");
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
