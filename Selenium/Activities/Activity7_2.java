package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity7_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.get("https://training-support.net/selenium/dynamic-attributes");
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//input[contains(@class,'-username')]")).sendKeys("abc");
		driver.findElement(By.xpath("//input[contains(@class,'-password')]")).sendKeys("def");
		driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/div[3]/input")).sendKeys("def");
		driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/div[4]/input")).sendKeys("a@a.com");
		driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"action-confirmation\"]")));
		System.out.println(driver.findElement(By.xpath("//*[@id=\"action-confirmation\"]")).getText());
		driver.close();
	}

}