package stepDefinitions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AlertTestSteps {

	WebDriver driver;
	WebDriverWait wait;
	Alert alert;
	
	@Given("^User is on the page$")
	public void userIsOnThePage() {
		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/javascript-alerts");
		System.out.println(driver.getTitle());
	}
	
	@When("^User clicks the simple alert button$")
	public void userClicksSimpleAlert(){
		driver.findElement(By.id("simple")).click();
	}
	
	@When("^User clicks the confirm alert button$")
	public void userClicksConfirmAlert(){
		driver.findElement(By.id("confirm")).click();
	}
	
	@When("^User clicks the prompt alert button$")
	public void userClicksPromptAlert(){
		driver.findElement(By.id("prompt")).click();
	}
	
	@Then("^Alert opens$")
	public void alertOpens() {
	alert = driver.switchTo().alert();
	}
	
	@And("^Read the text from the alert and print it$")
	public void readTheAlert() {
		System.out.println(alert.getText());
	}
	
	@And("^Close the alert$")
	public void closeTheAlert() {
		alert.accept();
	}
	
	@And("^Close the browser$")
	public void closeTheBrowser() {
		driver.close();
	}
	
	@And("^Close the alert with cancel$")
	public void closeTheAlertWithCancel() {
		alert.dismiss();
	}
	
	@And("^Write a \"([^\"]*)\" in it$")
	public void writeInPromptAlert(String message) {
		System.out.println(message);
		alert.sendKeys(message);
	}
	
}