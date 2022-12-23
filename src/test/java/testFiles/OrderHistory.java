package testFiles;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderHistory {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Manish\\Documents\\Grid\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		
	//------------------**User Login**---------------------------------------
		driver.get("https://www.boutiqaat.com/en-kw/men/");
		driver.findElement(By.linkText("Log In")).click();
		driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("rastogimanish1312@gmail.com");
		driver.findElement(By.xpath("(//input[@name='password'])[2]")).sendKeys("Aarambh@2022");
		driver.findElement(By.xpath("(//button[@class='btn btn-primary col-12'][normalize-space()='LOGIN'])[2]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("div[class='links register']")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[normalize-space()='My Dashboard']"))));
		driver.findElement(By.xpath("(//span[normalize-space()='MY ORDERS'])[2]")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div p.align-self-center"))));
		System.out.println(driver.findElement(By.cssSelector("div p.align-self-center")).getText());
		List<WebElement> orderId = driver.findElements(By.cssSelector("div.card.card-body.order-history"));
		for(WebElement OrderDetails:orderId)
		{
			System.out.println(driver.findElement(By.cssSelector("div.col-md-9")).getText());
			//System.out.println(OrderDetails.getText());	
		}
		
		driver.findElement(By.xpath("(//div[@class='col-md-3'])[1]")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.col-md-11.text-center"))));
		System.out.println(driver.findElement(By.cssSelector("div.col-md-11.text-center")).getText());
		System.out.println(driver.findElement(By.xpath("(//div[@class='row font-weight-bold'])[1]")).getText());
		System.out.println(driver.findElement(By.xpath("//div[@class='col-md-6 align-self-center']")).getText());
		WebElement track = driver.findElement(By.xpath("//button[@class='btn w-100 goldenBtn toolTipCont mt-2']"));
		WebElement trackInfo = driver.findElement(By.xpath("//button[@class='btn w-100 goldenBtn toolTipCont mt-2']/span"));
		Actions a = new Actions(driver);
		a.click(track).moveToElement(trackInfo).build().perform();
		System.out.println(trackInfo.getText());
	
	}

}
