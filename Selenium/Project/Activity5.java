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

public class Activity5 {

	WebDriver driver;
	WebDriverWait wait;
	
	@Test
	public void fifthTest(){
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
		driver.findElement(By.id("btnLogin")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]")));
		driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]/b")).click();
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("personal_txtEmpFirstName")).clear();
		driver.findElement(By.id("personal_txtEmpLastName")).clear(); 
		driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("Ashwin");
		driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("Harbhajanka"); 
		driver.findElement(By.id("personal_optGender_1")).click(); 
		Select country = new Select(driver.findElement(By.id("personal_cmbNation")));
		country.selectByVisibleText("Indian");
		driver.findElement(By.id("personal_DOB")).clear();
		driver.findElement(By.id("personal_DOB")).sendKeys("1997-05-03");
		driver.findElement(By.id("btnSave")).click();		
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
