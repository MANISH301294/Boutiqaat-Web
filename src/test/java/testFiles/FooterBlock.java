package testFiles;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FooterBlock {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
	
//		ChromeOptions  option = new ChromeOptions();
//		option.addArguments("incognito");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.boutiqaat.com/en-kw/men/");
	   WebElement footer = 	driver.findElement(By.tagName("footer"));
	   System.out.println(footer.findElements(By.tagName("a")).size());
	   
	   WebElement ColumnDriver = footer.findElement(By.xpath("//footer/div/div/div/div/ul"));
	   List<WebElement> links = ColumnDriver.findElements(By.tagName("a"));
	   	System.out.println(links.size());
	 
	 // click on each link on the column 
	 
	 for(int i=0;i<links.size();i++)
	 {
		 String ClickonLinkTab = Keys.chord(Keys.COMMAND,Keys.ENTER);
		 ColumnDriver.findElements(By.tagName("a")).get(i).sendKeys(ClickonLinkTab);
		 Thread.sleep(5000);
		
	 }
	 
	 // open all the tabs
	 
	Set<String> tab = driver.getWindowHandles();
	
    Iterator<String>it =	tab.iterator();
    
    while(it.hasNext())
    {
    	driver.switchTo().window(it.next());
    	System.out.println(driver.getTitle());
    }
	}

}
