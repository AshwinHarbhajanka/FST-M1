package activities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity13_2b {

	public List<List<String>> readExcel(String filepath) throws IOException {
		List<List<String>> data = new ArrayList<List<String>>();
		try {
			FileInputStream file = new FileInputStream(filepath);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			while(rowIterator.hasNext()) {
				List<String> rowData = new ArrayList<String>();
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while(cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if(row.getLastCellNum()==5) {
						rowData.add(cell.getStringCellValue());
					}
				}
				data.add(rowData);
			}
			file.close();
			workbook.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public static void main(String[] args) throws IOException {
		String filepath = "sample.xlsx";
		Activity13_2b obj = new Activity13_2b();
		List<List<String>> row = obj.readExcel(filepath);
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/simple-form");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("firstName")).sendKeys(row.get(1).get(1));
		driver.findElement(By.id("lastName")).sendKeys(row.get(1).get(2));
		driver.findElement(By.id("email")).sendKeys(row.get(1).get(3));
		driver.findElement(By.id("number")).sendKeys(row.get(1).get(4));
		driver.findElement(By.cssSelector("input.ui.green.button")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.close();
	}

}
