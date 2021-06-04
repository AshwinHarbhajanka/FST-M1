package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity8_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/tables");
		System.out.println(driver.getTitle());
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\'sortableTable\']/tbody/tr"));
		List<WebElement> columns = driver.findElements(By.xpath("//*[@id=\'sortableTable\']/thead/tr/th"));
		System.out.println("No. of Rows: "+rows.size()+"\n"+"No. of Columns: "+ columns.size());
		System.out.println(driver.findElement(By.xpath("//*[@id=\'sortableTable\']/tbody/tr[2]/td[2]")).getText());
		driver.findElement(By.xpath("//*[@id=\"sortableTable\"]/thead/tr/th[1]")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id=\'sortableTable\']/tbody/tr[2]/td[2]")).getText());
		System.out.println(driver.findElement(By.xpath("//*[@id=\'sortableTable\']/tfoot/tr")).getText());
		driver.close();
	}

}
