package Cucumber_Demo.Cucumber_Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MYtours {
	WebDriver driver;
	
	@Given("mercury application is launched")
	public void mercury_application_is_launched() {
		System.setProperty("webdriver.chrome.driver", "C:\\mydrivers\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
	}

	@Then("User enters username {string}")
	public void user_enters_username(String string1) {
	    driver.findElement(By.name("userName")).sendKeys(string1);
	}

	@Then("User enters password {string}")
	public void user_enters_password(String string2) {
		driver.findElement(By.name("password")).sendKeys(string2);
	}

	@When("User clicks on submit button")
	public void user_clicks_on_submit_button() {
		driver.findElement(By.name("login")).click();
	    
	}

	@When("Verifies the login success")
	public void verifies_the_login_success() {
		Assert.assertEquals("Find a Flight: Mercury Tours", driver.getTitle());
	  System.out.println("login successful");
	 
	}
}
