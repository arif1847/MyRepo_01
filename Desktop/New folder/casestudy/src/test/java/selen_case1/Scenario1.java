package selen_case1;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Scenario1 {
	WebDriver driver;
  @Test
  public void f() {
	  driver = Driver999.getDriver("chrome");
	  driver.get("https://www.google.com");
      driver.manage().window().maximize();	  
  }
}
