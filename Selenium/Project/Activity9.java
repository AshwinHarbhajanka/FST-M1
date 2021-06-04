package activities;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity9 {

	WebDriver driver;
	WebDriverWait wait;

	@Test
	public void ninthTest() {
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
		driver.findElement(By.id("btnLogin")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]")));
		driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]/b")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"sidenav\"]/li[3]/a")));
		driver.findElement(By.xpath("//*[@id=\"sidenav\"]/li[3]/a")).click();
		List<WebElement> cols = driver.findElements(By.xpath("//*[@id=\"emgcontact_list\"]/thead/tr/th"));
		System.out.println("No.of columns: "+cols.size());
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"emgcontact_list\"]/tbody/tr"));
		System.out.println("No. of rows: "+rows.size());
		System.out.println("# "+driver.findElement(By.xpath("//*[@id=\"emgcontact_list\"]/thead/tr")).getText());
		for(int i =1;i<=rows.size();i++) {
			WebElement element = driver.findElement(By.xpath("//*[@id=\"emgcontact_list\"]/tbody/tr["+i+"]"));
			System.out.println(i+" "+element.getText());
		}
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
