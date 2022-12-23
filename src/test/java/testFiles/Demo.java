package testFiles;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Manish\\Documents\\Grid\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.boutiqaat.com/en-kw/");
		driver.findElement(By.xpath("//span[normalize-space()='MEN']")).click();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1400)");
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//button[@class='action tocart primary'])[3]")).click();
		Thread.sleep(4000);

		System.out.println(
				driver.findElement(By.xpath("//div[@class='col-md-7']/div[@class='product-info']/h1")).getText());

		// ------------------------------**PRICE**------------------------------------	
		
		 try {
		   WebElement rglrPrice =   driver.findElement(By.xpath("//div[@class='product-info-price']/span[@class='regular-price price']"));
		        System.out.println("Regular Price = "+rglrPrice.getText());
		        
		    } catch (NoSuchElementException e) {
		        System.out.println("Special Price = "+driver.findElement(By.xpath("//span[@class='special-price price']")).getText());
		        System.out.println("Regular Price = "+driver.findElement(By.xpath("//div[@class='product-info-price discount']/span[@class='regular-price price']")).getText());
		        System.out.println("Discount = "+driver.findElement(By.xpath("//span[@class='discountpercent tag']")).getText());
		    }
		 
		
		 
	}}
		
	