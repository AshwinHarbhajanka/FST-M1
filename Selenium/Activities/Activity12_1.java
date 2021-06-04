package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity12_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/iframes");
		System.out.println(driver.getTitle());
		driver.switchTo().frame(0);
		System.out.println(driver.findElement(By.cssSelector("div.content")).getText());
		WebElement button = driver.findElement(By.id("actionButton"));
		System.out.println(button.getText()+"\n"+button.getCssValue("color"));
		button.click();
		System.out.println(button.getText()+"\n"+button.getCssValue("color"));
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		System.out.println(driver.findElement(By.cssSelector("div.content")).getText());
		WebElement button1 = driver.findElement(By.id("actionButton"));
		System.out.println(button1.getText()+"\n"+button1.getCssValue("color"));
		button1.click();
		System.out.println(button1.getText()+"\n"+button1.getCssValue("color"));
		driver.switchTo().defaultContent();
		driver.close();
	}

}