package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity10_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/drag-drop");
		System.out.println(driver.getTitle());
		Actions builder = new Actions(driver);
		WebElement ball = driver.findElement(By.id("draggable"));
		builder.moveToElement(ball).dragAndDrop(ball, driver.findElement(By.id("droppable"))).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"droppable\"]/p")));
		System.out.println(driver.findElement(By.xpath("//*[@id=\"droppable\"]/p")).getText());
		builder.moveToElement(ball).dragAndDrop(ball, driver.findElement(By.id("dropzone2"))).build().perform();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"dropzone2\"]/p")));
		System.out.println(driver.findElement(By.xpath("//*[@id=\"dropzone2\"]/p")).getText());
		driver.close();
	}
	
}
