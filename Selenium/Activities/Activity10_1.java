package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/input-events");
		System.out.println(driver.getTitle());
		Actions builder = new Actions(driver); 
		WebElement element = driver.findElement(By.id("wrapD3Cube"));
		builder.click(element);
		System.out.println(driver.findElement(By.className("active")).getText());
		builder.doubleClick(element).perform();
		System.out.println(driver.findElement(By.className("active")).getText());
		builder.contextClick(element).perform();
		System.out.println(driver.findElement(By.className("active")).getText());
		driver.close();
	}

}
