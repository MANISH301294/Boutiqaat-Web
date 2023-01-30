package pageObjectModel;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponent;

public class FooterPage extends AbstractComponent  {

	WebDriver driver;
	public FooterPage(WebDriver driver) {
		super(driver);
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(tagName="a")
	List<WebElement> FooterTags;
	
	@FindBy(xpath="//footer")
	WebElement Footerdriver;
	
	@FindBy(xpath="(//div[@class='col']/ul)[1]")
	WebElement FooterSection;
	

	
	
	public void windowHandleBySection()
	{
		List<WebElement>  links = FooterSection.findElements(By.tagName("a"));
	    System.out.println(links.size());
	    
	     for(WebElement link:links)
	     {
	    	 String ClickOnTab = Keys.chord(Keys.COMMAND,Keys.ENTER);
	    	 link.sendKeys(ClickOnTab);
	     }
	     
	   Set<String> tab=  driver.getWindowHandles();
	  Iterator<String> it =  tab.iterator();
	  while(it.hasNext())
	  {
		  driver.switchTo().window(it.next());
		  System.out.println(driver.getTitle());
		  driver.close();
	  }
	
	}
	
	public void CompleteFooterLink()
	{
	List<WebElement> links	= Footerdriver.findElements(By.tagName("a"));
	System.out.println(links.size());
	
	for(WebElement link:links)
	{
	String ClickOnTab = Keys.chord(Keys.COMMAND,Keys.ENTER);
	link.sendKeys(ClickOnTab);
	}
	
	      Set<String> tab = driver.getWindowHandles();
	      Iterator<String> it =  tab.iterator();
	      
	      while(it.hasNext())
	      {
	    	 driver.switchTo().window(it.next());
	    	 System.out.println(driver.getTitle());
	    	 driver.close();
	      }
	
	
	}
	
	

}
