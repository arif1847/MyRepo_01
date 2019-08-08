package selen_case1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver999 {
	
	WebDriver driver;
	public static WebDriver getDriver(String browser)
	{
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\mydrivers\\chromedriver_win32\\chromedriver.exe");
			return new ChromeDriver();
				}
		else if (browser.equals("ie")) {
			
			System.setProperty("webdriver.ie.driver","C:\\mydrivers\\IEDriverServer_Win32_3.14.0\\IEDriverServer.exe" );
			return new InternetExplorerDriver();
		}
		else if (browser.equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "C:\\mydrivers\\geckodriver-v0.24.0-win32\\geckodriver.exe");
			return new FirefoxDriver();
		
		}
		else {
			return null;
		}
			
	}

}
