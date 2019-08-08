package selen_case1;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Scenario2 {
	
	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	
  @Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver", "C:\\mydrivers\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://www.google.com/");
	  Assert.assertEquals("Google", driver.getTitle());
  }
  @AfterMethod
  public void getResultAfterMethod(ITestResult result) throws IOException {
	  if(result.getStatus()==ITestResult.FAILURE) {
	   test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED", ExtentColor.RED));
	   TakesScreenshot snap = (TakesScreenshot)driver;
	   File src =snap.getScreenshotAs(OutputType.FILE);
	   String Path = System.getProperty("user.dir") +"/test-output/screens/"+result.getName()+".png";
	   FileUtils.copyFile(src, new File(Path));
	   test.addScreenCaptureFromPath(Path,result.getName());
	   test.fail(result.getThrowable());
	  }
	  else if(result.getStatus() == ITestResult.SUCCESS) {
	   test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED", ExtentColor.GREEN));
	  }
	  else {
	   test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED", ExtentColor.YELLOW));
	   test.skip(result.getThrowable());
	  }
	 }

 
	  @BeforeTest
		public void startReports() {
			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/testReport.html");
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			htmlReporter.config().setDocumentTitle("Extent Report Demo");
			htmlReporter.config().setReportName("Test Report");
			htmlReporter.config().setTheme(Theme.STANDARD);
			htmlReporter.config().setTimeStampFormat("EEEE,MMMM dd,YYYY,hh:mm a'('zzz')'");
  }

  @AfterTest
  public void afterTest() {
  }

}
