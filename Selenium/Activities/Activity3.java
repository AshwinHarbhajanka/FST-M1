package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/simple-form");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("firstName")).sendKeys("xx");
		driver.findElement(By.id("lastName")).sendKeys("xx");
		driver.findElement(By.id("email")).sendKeys("xx@x.com");
		driver.findElement(By.id("number")).sendKeys("9999999999");
		driver.findElement(By.cssSelector("input.ui.green.button")).click();
		driver.close();

	}

}
