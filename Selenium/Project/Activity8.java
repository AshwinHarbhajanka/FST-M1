package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity8 {

	WebDriver driver;
	WebDriverWait wait;

	@Test
	public void eighthTest() {
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
		driver.findElement(By.id("btnLogin")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div/div/div/fieldset/div/div/table/tbody/tr/td[4]/div/a")));
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div/div/div/fieldset/div/div/table/tbody/tr/td[4]/div/a")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div/div/div/fieldset/div/div/table/tbody/tr/td[4]/div/a")).click();
		Select country = new Select(driver.findElement(By.id("applyleave_txtLeaveType")));
		country.selectByVisibleText("privilege leaves");
		driver.findElement(By.id("applyleave_txtFromDate")).clear();
		driver.findElement(By.id("applyleave_txtFromDate")).sendKeys("2021-05-18");
		driver.findElement(By.id("applyleave_txtToDate")).clear(); 
		driver.findElement(By.id("applyleave_txtToDate")).sendKeys("2021-05-23"); 
		driver.findElement(By.id("applyleave_txtComment")).sendKeys("vacation");
		driver.findElement(By.id("applyBtn")).click();		
		driver.findElement(By.xpath("//*[@id=\"menu_leave_viewMyLeaveList\"]")).click();
		driver.findElement(By.id("btnSearch")).click();		
		System.out.println(driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[6]/a")).getText());
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
