package activities;

import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Activity5 {

	AppiumDriver<MobileElement> driver = null;

	@Test
	public void message() {
		driver.findElement(MobileBy.AndroidUIAutomator(
				"resourceId(\"com.google.android.apps.messaging:id/start_new_conversation_button\")")).click();
		driver.findElement(
				MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/recipient_text_view\")"))
				.sendKeys("8817620052");
		((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElement(MobileBy
				.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/compose_message_text\")"))
				.sendKeys("Hello from Appium");
		driver.findElement(MobileBy
				.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/send_message_button_icon\")"))
				.click();
		String s = driver
				.findElement(MobileBy
						.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/message_text\")"))
				.getText();
		System.out.println(s);
		Assert.assertEquals(s, "Hello from Appium");

	}

	@BeforeMethod
	public void beforeMethod() throws MalformedURLException {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel 4 API 28");
		caps.setCapability("platformName", "android");
		caps.setCapability("appPackage", "com.google.android.apps.messaging");
		caps.setCapability("appActivity", ".ui.conversationlist.ConversationListActivity");
		caps.setCapability("noReset", true);

		URL appServer = new URL("http://localhost:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, caps);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
