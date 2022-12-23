package testFiles;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Country_Change {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Manish\\Documents\\Grid\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.boutiqaat.com/en-kw/men/");
		
		driver.findElement(By.linkText("Log In")).click();
		driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("m.rastogi1994@gmail.com");
		driver.findElement(By.xpath("(//input[@name='password'])[2]")).sendKeys("Tester");
		driver.findElement(By.xpath("(//button[@class='btn btn-primary col-12'][normalize-space()='LOGIN'])[2]")).click();
		Thread.sleep(3000);
		
		//**------------------ChangeTheCountry**----------
		System.out.println(driver.findElement(By.cssSelector("span[class='country-label']")).getText());
		driver.findElement(By.cssSelector("span[class='country-label']")).click();
		
		List<WebElement> country = driver.findElements(By.xpath("//div[@class='flag-options']/div"));
		
		
		for(WebElement countries:country)
		{
			System.out.println(countries.getText());
			if(countries.getText().equalsIgnoreCase("Oman"))
			{
              countries.click();
              
			}
		}
		
	}

}
