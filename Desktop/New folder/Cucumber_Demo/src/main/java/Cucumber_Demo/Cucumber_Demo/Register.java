package Cucumber_Demo.Cucumber_Demo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register {
	WebDriver driver;
	@Given("Application is up andlaunched")
	public void application_is_up_andlaunched() {
		System.setProperty("webdriver.chrome.driver", "C:\\mydrivers\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		driver.manage().window().maximize();
	}

	@When("User click on register button")
	public void user_click_on_register_button() {
		driver.findElement(By.linkText("SignUp")).click();
	    
	}

	@Then("Application is opened")
	public void application_is_opened() {
		driver.findElement(By.id("userName")).sendKeys("abc123");
	      driver.findElement(By.id("firstName")).sendKeys("ARIF");
	      driver.findElement(By.id("lastName")).sendKeys("KHAN");
	      driver.findElement(By.id("password")).sendKeys("qwerty1");
	      driver.findElement(By.name("confirmPassword")).sendKeys("qwerty1");
	      
	      driver.findElement(By.xpath("//input[@value='Male']")).click();
	     
	      
	      driver.findElement(By.id("emailAddress")).sendKeys("chatur@gmail.com");
	      driver.findElement(By.id("mobileNumber")).sendKeys("99999925202");
	      driver.findElement(By.name("dob")).sendKeys("12/02/2000");
	    
	      driver.findElement(By.id("address")).sendKeys("Wz-13456 abcd");
	      Select cell = new Select(driver.findElement(By.name("securityQuestion")));
	      cell.selectByIndex(1);
	      driver.findElement(By.id("answer")).sendKeys("Black");
	      driver.findElement(By.name("Submit")).click();
	    
	}

	@Then("Login Success")
	public void login_Success() {
		 Assert.assertEquals("Login", driver.getTitle());
	      System.out.println("Login Successfully");
	   
}}