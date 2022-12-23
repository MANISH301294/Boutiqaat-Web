package testFiles;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddtoCart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Manish\\Documents\\Grid\\chromedriver.exe");
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.boutiqaat.com/en-kw/men/");
		
		//----------------------**Product item Block **-------------
		List<WebElement> item = driver.findElements(By.xpath("//div[@class='product-item-details pb-2']"));

		for(WebElement Prodinfo:item)
		{
			System.out.println(Prodinfo.getText());
		}
			
		List<WebElement> addTo = driver.findElements(By.xpath("//div[@class='product-item-actions']/button"));

		 for(WebElement addToCart:addTo)
		 {
			  if(addToCart.getText().equals("Buy Now"))
			  {
				  addToCart.click();
				  Thread.sleep(2000);
				  break;
			  }
			  
			  
			  else if(addToCart.getText().equals("Notify Me"))
			  {
				  Thread.sleep(3000);
				  addToCart.click();
			
				  driver.findElement(By.name("name")).sendKeys("Test");
				 
				  driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("Test107@tester.com");
				 
				  driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("849357358");
				  
				  driver.findElement(By.xpath("(//button[@class='btn btn-primary col-12'])[2]")).click();
				  break;
				  
			  }
			  else if(addToCart.getText().equals("View"))
			  {
				  addToCart.click();
				  break;
			  }
			  break;
		 }
	}

}
