package testFiles;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class register {
	WebDriver driver ;
  // @Test
	public void registerFail() throws InterruptedException
	{
	   
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Manish\\Documents\\Grid\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.boutiqaat.com/en-kw/");
		driver.findElement(By.xpath("//span[normalize-space()='WOMEN']")).click();
		//----------------------------- *** Registration form ***----------------------------------------------
		driver.findElement(By.cssSelector("div[class='links register'] a")).click();
		driver.findElement(By.xpath("//div[@class='login-container register col-md-4 pl-0 pr-0']//input[@placeholder='Email']")).sendKeys("testautomation1@test.com");
		driver.findElement(By.xpath("//input[@class='ReactPasswordStrength-input form-control']")).sendKeys("Tester@123");
		driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys("Automation Tester");
		driver.findElement(By.xpath("//input[@name='mobile_number']")).sendKeys("9854854545");
		driver.findElement(By.xpath("//label[@for='customControl1']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Register']")).click();	
		Thread.sleep(2000L);
	   String message = driver.findElement(By.cssSelector("div[role='alert']")).getText();
	   System.out.println(message);
	   AssertJUnit.assertEquals(message, "There is already an account with this email address.");
	   driver.close();
	}
	
	@Test 
	public void registerSuccess() throws InterruptedException
	{   
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Manish\\Documents\\Grid\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.boutiqaat.com/en-kw/");
		driver.findElement(By.xpath("//span[normalize-space()='MEN']")).click();
		driver.findElement(By.cssSelector("div[class='links register'] a")).click();
		
		// -------------------------------** SysDate**----------------------------------------
		
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
		   LocalDateTime now = LocalDateTime.now();  
		   System.out.println(dtf.format(now));  
		
		//----------------------------- *** Registration form ***----------------------------------------------
		
		driver.findElement(By.xpath("//div[@class='login-container register col-md-4 pl-0 pr-0']//input[@placeholder='Email']")).sendKeys("Test"+dtf.format(now)+"@Boutiqaat.com");
		driver.findElement(By.xpath("//input[@class='ReactPasswordStrength-input form-control']")).sendKeys("Tester@123");
		driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys("Automation Test");
		driver.findElement(By.xpath("//input[@name='mobile_number']")).sendKeys("9854854535");
		driver.findElement(By.xpath("//label[@for='customControl1']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Register']")).click();
		Thread.sleep(4000L);
	   String message1 = driver.findElement(By.cssSelector("div[role='alert']")).getText();
	   System.out.println(message1);
	   AssertJUnit.assertEquals(message1, "Customer successfully registered.");
	    //------------- ** verify user name of registered user **----------------------
	   Thread.sleep(3000L);

	   String username = driver.findElement(By.xpath("//div[@class='links welcome seperator']")).getText();
	   System.out.println(username.length());
	   
	   String check = username.substring(4);
	   System.out.println(check);
	   AssertJUnit.assertEquals(check,"Automation Test" );
	   
	   // ------------------------------**Get The Registered Email**-----------------
	   driver.findElement(By.xpath("//div[@class='links register']/a")).click();
	   Thread.sleep(2000);
	 WebElement useremail =   driver.findElement(By.xpath("(//div[@class='col-md-9 right-pane']/div/ul/div/div/li/address/div)[2]"));
	   System.out.println(useremail);
	   
	   
	   //---------------------------------** logout **----------------------
	   
	   
	   driver.findElement(By.cssSelector(".singOut")).click();
	   
	
}}