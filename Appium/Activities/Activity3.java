package activities;

import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.io.IOException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Activity3 {

	AppiumDriver<MobileElement> driver = null;

	@Test
	public void calculate() {
		driver.findElement(By.id("digit_5")).click();
		driver.findElement(By.id("op_add")).click();
		driver.findElement(By.id("digit_9")).click();
		driver.findElement(By.id("eq")).click();
		String res = driver.findElement(By.id("result")).getText();
		System.out.println(res);
		Assert.assertEquals(res, "14");
		
		driver.findElement(By.id("digit_1")).click();
		driver.findElement(By.id("digit_0")).click();
		driver.findElement(By.id("op_sub")).click();
		driver.findElement(By.id("digit_5")).click();
		driver.findElement(By.id("eq")).click();
		String res1 = driver.findElement(By.id("result")).getText();
		System.out.println(res1);
		Assert.assertEquals(res1, "5");

		driver.findElement(By.id("digit_5")).click();
		driver.findElement(By.id("op_mul")).click();
		driver.findElement(By.id("digit_1")).click();
		driver.findElement(By.id("digit_0")).click();
		driver.findElement(By.id("digit_0")).click();
		driver.findElement(By.id("eq")).click();
		String res2 = driver.findElement(By.id("result")).getText();
		System.out.println(res2);
		Assert.assertEquals(res2, "500");
		
		driver.findElement(By.id("digit_5")).click();
		driver.findElement(By.id("digit_0")).click();
		driver.findElement(By.id("op_div")).click();
		driver.findElement(By.id("digit_2")).click();
		driver.findElement(By.id("eq")).click();
		String res3 = driver.findElement(By.id("result")).getText();
		System.out.println(res3);
		Assert.assertEquals(res3, "25");
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceId", "emulator-5554");
		caps.setCapability("deviceName", "Pixel 4 API 28");
		caps.setCapability("platformName", "android");
		caps.setCapability("appPackage", "com.android.calculator2");
		caps.setCapability("appActivity", "com.android.calculator2.Calculator");

		URL appServer = new URL("http://localhost:4723/wd/hub");

		driver = new AndroidDriver<MobileElement>(appServer, caps);

	}

}
