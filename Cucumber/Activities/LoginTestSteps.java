package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTestSteps {
	WebDriver driver;
	WebDriverWait wait;

	@Given("^User is on Login Page$")
	public void userIsOnLoginPage() throws Throwable {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 15);
		driver.get("https://www.training-support.net/selenium/login-form");
	}

	@When("^User enters username and password$")
	public void userEntersUsernameAndPassword() throws Throwable {
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/button")).click();
	}
	
	@When("^User enters \"(.*)\" and \"(.*)\"$")
	public void userEntersUsernameAndPasswordDirectly(String arg1, String arg2) throws Throwable {
		driver.findElement(By.id("username")).sendKeys(arg1);
		driver.findElement(By.id("password")).sendKeys(arg2);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/button")).click();
	}

	@Then("^Read the page title and confirmation message$")
	public void readThePageTitleAndConfirmationMessage() throws Throwable {
		System.out.println(driver.getTitle()+"\n"+driver.findElement(By.id("action-confirmation")).getText());
	}

	@And("^Close the browser$")
	public void closeTheBrowser() throws Throwable {
		driver.close();
	}
}
