package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity7_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.get("https://training-support.net/selenium/dynamic-attributes");
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/div[1]/input")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/div[2]/input")).sendKeys("password");
		driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/button")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"action-confirmation\"]")));
		System.out.println(driver.findElement(By.xpath("//*[@id=\"action-confirmation\"]")).getText());
		driver.close();
	}

}
