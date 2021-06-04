package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity6_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.get("https://training-support.net/selenium/dynamic-controls");
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//*[@id=\"toggleCheckbox\"]")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"dynamicCheckbox\"]/input")));
		driver.findElement(By.xpath("//*[@id=\"toggleCheckbox\"]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"dynamicCheckbox\"]/input"))).click();
		driver.close();
	}
}
