package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity9_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/selects");
		System.out.println(driver.getTitle());
		Select select = new Select(driver.findElement(By.id("single-select")));
		select.selectByVisibleText("Option 2");
		System.out.println(driver.findElement(By.id("single-value")).getText());
		select.selectByIndex(3);
		System.out.println(driver.findElement(By.id("single-value")).getText());
		select.selectByValue("4");
		System.out.println(driver.findElement(By.id("single-value")).getText());
		List<WebElement> options = select.getOptions();
		for(WebElement option: options) {
			System.out.println("Options : "+option.getText());
			}
		driver.close();
	}

}
