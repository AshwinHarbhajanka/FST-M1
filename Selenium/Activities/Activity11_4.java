package activities;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity11_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/tab-opener");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("launcher")).click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String> handles = driver.getWindowHandles();
		for(String handle: handles) {
			driver.switchTo().window(handle);
		}
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("actionButton")));
		System.out.println(driver.getTitle());
		System.out.println(driver.findElement(By.cssSelector("div.content")).getText());
		driver.findElement(By.id("actionButton")).click();
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		Set<String> handles2 = driver.getWindowHandles();
		for(String handle: handles2) {
			driver.switchTo().window(handle);
		}
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.content")));
		System.out.println(driver.getTitle());
		System.out.println(driver.findElement(By.cssSelector("div.content")).getText());
		Set<String> handles3 = driver.getWindowHandles();
		for(String handle: handles3) {
			System.out.println(handle);
		}
		driver.quit();
}}
