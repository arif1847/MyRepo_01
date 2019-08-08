package Cucumber_Demo.Cucumber_Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class testme {
	WebDriver driver;
	@Given("Application is launched")
	public void application_is_launched() {
		System.setProperty("webdriver.chrome.driver", "C:\\mydrivers\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		driver.manage().window().maximize();
	}

	@When("User provide valid data")
	public void user_provide_valid_data() {
		driver.findElement(By.linkText("SignIn")).click();
		  driver.findElement(By.id("userName")).sendKeys("lalitha");
		  driver.findElement(By.name("password")).sendKeys("password123");
	  driver.findElement(By.name("Login")).click();
	 
	    
	}

	@Then("Login success")
	public void login_success() {
		 Assert.assertEquals("Home", driver.getTitle());
		  System.out.println("login successful");
	   
	}
}
