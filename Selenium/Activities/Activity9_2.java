package activities;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity9_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/selects");
		System.out.println(driver.getTitle());
		Select select = new Select(driver.findElement(By.id("multi-select")));
		System.out.println(select.isMultiple());
		select.selectByVisibleText("Javascript");
		select.selectByValue("node");
		select.selectByIndex(3);
		select.selectByIndex(4);
		select.selectByIndex(5);
		select.deselectByValue("node");
		select.deselectByIndex(7);
		System.out.println(select.getFirstSelectedOption().getText());
		List<WebElement> selection = select.getAllSelectedOptions();
		for(WebElement option: selection) {
			System.out.println(option.getText());
		}
		select.deselectAll();
		driver.close();
	}

}
