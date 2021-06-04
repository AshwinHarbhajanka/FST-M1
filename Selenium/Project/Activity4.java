package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity4 {

	WebDriver driver;
	WebDriverWait wait;
	
	@Test
	public void fourthTest(){
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
		driver.findElement(By.id("btnLogin")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("PIM")));
		driver.findElement(By.linkText("PIM")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Employee List")));
		driver.findElement(By.linkText("Employee List")).click();
		driver.findElement(By.name("btnAdd")).click();
		driver.findElement(By.id("firstName")).sendKeys("Ash");
		driver.findElement(By.id("lastName")).sendKeys("Test");
		driver.findElement(By.id("btnSave")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Employee List")));
		driver.findElement(By.linkText("Employee List")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("empsearch_employee_name_empName")));
		driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("Ash Test");
		driver.findElement(By.id("searchBtn")).click();
		String name = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr/td[3]/a")).getText();
		System.out.println(name);
		Assert.assertEquals("Ash",name);
		}
	
	@BeforeMethod
	public void beforeMethod() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 15);
		driver.get("http://alchemy.hguy.co/orangehrm");
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
