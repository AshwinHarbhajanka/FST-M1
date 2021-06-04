package activities;

import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
	public void scroll() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@text='Lazy Loading']")));
		System.out.println(driver.findElement(By.xpath("//android.view.View[@text='Lazy Loading']")).getText());
		List<MobileElement> number = driver.findElements(By.xpath("//android.view.View/android.widget.Image"));
		System.out.println(number.size());
		driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollIntoView(text(\"helen\"))"));
		number.clear();
		number = driver.findElements(By.xpath("//android.view.View/android.widget.Image"));
		System.out.println(number.size());
		Assert.assertEquals(number.size(), 4);
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
		driver.get("https://www.training-support.net/selenium/lazy-loading");
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
