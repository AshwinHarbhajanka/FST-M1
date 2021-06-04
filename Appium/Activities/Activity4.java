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

public class Activity4 {

	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;

	@Test
	public void contacts() {
		driver.findElement(By.id("floating_action_button")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@text='First name']")).sendKeys("Aditya");
		driver.findElement(By.xpath("//android.widget.EditText[@text='Last name']")).sendKeys("Test2");
		driver.findElement(By.xpath("//android.widget.EditText[@text='Phone']")).sendKeys("2222222222");
		driver.findElement(By.id("editor_menu_save_button")).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc='Aditya Test2']")));
		String s = driver.findElement(By.xpath("//android.view.View[@content-desc='Aditya Test2']"))
				.getAttribute("content-desc");
		System.out.println(s);
		Assert.assertEquals(s, "Aditya Test2");
	}

	@BeforeMethod
	public void beforeMethod() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceId", "emulator-5554");
		caps.setCapability("deviceName", "Pixel 4 API 28");
		caps.setCapability("platformName", "android");
		caps.setCapability("appPackage", "com.android.contacts");
		caps.setCapability("appActivity", "com.android.contacts.activities.PeopleActivity");
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
