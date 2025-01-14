package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10_2 {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
	WebDriver driver = new FirefoxDriver();
	driver.get("https://training-support.net/selenium/input-events");
	System.out.println(driver.getTitle());
	Actions builder = new Actions(driver); 
	builder.sendKeys("A").build().perform();
	System.out.println(driver.findElement(By.id("keyPressed")).getText());
	builder.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).build().perform();
	driver.close();
	}}
