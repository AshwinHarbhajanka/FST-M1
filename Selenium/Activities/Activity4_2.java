package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/simple-form");
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("x");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("x");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("x@x.com");
		driver.findElement(By.xpath("//input[@id='number']")).sendKeys("9999999999");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/form/div/div[6]/div[1]/input")).click();
		driver.close();
	}
}
