package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity7 {

	WebDriver driver;
	WebDriverWait wait;

	@Test
	public void seventhTest() {
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
		driver.findElement(By.id("btnLogin")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]")));
		driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]/b")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"sidenav\"]/li[9]/a")));
		driver.findElement(By.xpath("//*[@id=\"sidenav\"]/li[9]/a")).click();
		driver.findElement(By.id("addWorkExperience")).click();
		driver.findElement(By.id("experience_employer")).sendKeys("IBM INDIA");
		driver.findElement(By.id("experience_jobtitle")).sendKeys("SDET");
		driver.findElement(By.id("experience_from_date")).clear();
		driver.findElement(By.id("experience_from_date")).sendKeys("2020-01-13");
		driver.findElement(By.id("experience_to_date")).clear(); 
		driver.findElement(By.id("experience_to_date")).sendKeys("2021-05-18"); 
		driver.findElement(By.id("experience_comments")).sendKeys("TESTING");
		driver.findElement(By.id("btnWorkExpSave")).click();
	}

	@BeforeMethod
	public void beforeMethod() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 15);
		driver.get("http://alchemy.hguy.co/orangehrm");
	}
	
	
	 @AfterMethod 
	 public void afterMethod(){ 
		 driver.quit();
		 }

}
