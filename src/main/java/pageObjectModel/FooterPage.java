package pageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
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
	
	
	
	public void windowHandle()
	{
		System.out.println(Footerdriver.findElements(By.tagName("a")).size());
		
		
		
		
	 
		
	}
	
	

}
