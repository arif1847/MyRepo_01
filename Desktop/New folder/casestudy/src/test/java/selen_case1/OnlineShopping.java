package selen_case1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OnlineShopping {
	WebDriver driver;
	
	@BeforeMethod
	public void launch() {
		driver = Driver999.getDriver("chrome");
		  driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	      driver.manage().window().maximize();	  
	      driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);      
	}
	
	
  @Test(enabled = false)
  public void testRegistration() {
	  driver.findElement(By.linkText("SignUp")).click();
      driver.findElement(By.id("userName")).sendKeys("abcd1234");
      driver.findElement(By.id("firstName")).sendKeys("ARIF");
      driver.findElement(By.id("lastName")).sendKeys("KHAN");
      driver.findElement(By.id("password")).sendKeys("abcdefgh");
      driver.findElement(By.name("confirmPassword")).sendKeys("abcdefgh");
      
      driver.findElement(By.xpath("//input[@value='Male']")).click();
     // driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
      
      driver.findElement(By.id("emailAddress")).sendKeys("chatur@gmail.com");
      driver.findElement(By.id("mobileNumber")).sendKeys("99999925202");
      driver.findElement(By.name("dob")).sendKeys("12/02/2000");
      //driver.findElement(By("userName")).sendKeys("ARIF KHAN");
      driver.findElement(By.id("address")).sendKeys("Wz-13456 abcd");
      Select cell = new Select(driver.findElement(By.name("securityQuestion")));
      cell.selectByIndex(1);
      driver.findElement(By.id("answer")).sendKeys("Black");
      driver.findElement(By.name("Submit")).click();
      
      Assert.assertEquals("Login", driver.getTitle());
      System.out.println("Login Successfully");
      
  }
  @Test
  public void testlogin()  {
	  driver.findElement(By.linkText("SignIn")).click();
	  driver.findElement(By.id("userName")).sendKeys("abcd123");
	  driver.findElement(By.name("password")).sendKeys("abcdefg");
  driver.findElement(By.name("Login")).click();
  Assert.assertEquals("Home", driver.getTitle());
  System.out.println("login successful");
  
  }
@Test(enabled = false)
public void testCart() throws IOException{
File src = new File("C:\\Users\\training_d5.01.02\\Desktop\\login.xlsx");
FileInputStream fis = new FileInputStream (src);
XSSFWorkbook wb = new XSSFWorkbook(fis);
XSSFSheet sheet1= wb.getSheetAt(0);


 String Data=sheet1.getRow(0).getCell(0).getStringCellValue();  
 String Data1=sheet1.getRow(0).getCell(1).getStringCellValue();
 driver.findElement(By.linkText("SignIn")).click();
driver.findElement(By.id("userName")).sendKeys(Data);
driver.findElement(By.name("password")).sendKeys(Data1);
driver.findElement(By.name("Login")).click();

Actions act = new Actions(driver);
act.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[2]/a"))).build().perform();
driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[2]/ul/li[1]/a")).click();
driver.findElement(By.xpath("//*[@id=\"submenuul11290\"]/li[1]/a")).click();

driver.findElement(By.linkText("Add to cart")).click();

driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click(); 

Assert.assertEquals("View Cart", driver.getTitle());
System.out.println("product added to cart");

}
@Test(enabled = false)
public void testPayment() throws IOException{
	File src = new File("C:\\Users\\training_d5.01.02\\Desktop\\login.xlsx");
	FileInputStream fis = new FileInputStream (src);
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	XSSFSheet sheet1= wb.getSheetAt(0);

	 String Data=sheet1.getRow(0).getCell(0).getStringCellValue();  
	 String Data1=sheet1.getRow(0).getCell(1).getStringCellValue();
	 driver.findElement(By.linkText("SignIn")).click();
	driver.findElement(By.id("userName")).sendKeys(Data);
	driver.findElement(By.name("password")).sendKeys(Data1);
	driver.findElement(By.name("Login")).click();

	Actions act = new Actions(driver);
	act.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[2]/a"))).build().perform();
	driver.findElement(By.xpath("//*[@id=\'menu3\']/li[2]/ul/li[1]/a")).click();
	driver.findElement(By.xpath("//*[@id=\'submenuul11290\']/li[1]/a")).click();

	driver.findElement(By.linkText("Add to cart")).click();

	driver.findElement(By.xpath("//*[@id=\'header\']/div[1]/div/div/div[2]/div/a[2]")).click(); 
	 driver.findElement(By.xpath("//*[@id=\'cart\']/tfoot/tr[2]/td[5]/a")).click();
	 driver.findElement(By.xpath("/html/body/b/div/div/div[1]/div/div[2]/div[3]/div/form[2]/input")).click();
	 driver.findElement(By.xpath("//*[contains(text(),'HDFC Bank')]")).click(); 
	 driver.findElement(By.xpath("//*[@id=\"btn\"]")).click();	 driver.findElement(By.name("username")).sendKeys("123457");
	 driver.findElement(By.name("password")).sendKeys("Pass@457");	 
	 driver.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/div/div[3]/input")).click();	  
	 driver.findElement(By.name("transpwd")).sendKeys("Trans@457");
	 driver.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/div/div[2]/input")).click(); 
	 
	 Assert.assertEquals("Order Details", driver.getTitle());
	 System.out.println("order done successfully");
}

}


