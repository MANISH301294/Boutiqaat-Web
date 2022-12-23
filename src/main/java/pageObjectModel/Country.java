package pageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponent;

public class Country extends AbstractComponent{
	WebDriver driver;
	public  Country(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="span[class='country-label']")
	WebElement flag;
	
	@FindBy(xpath="//div[@class='flag-options']/div")
	List<WebElement> country;
	public void country(String CountryName) throws InterruptedException
	{
		
		System.out.println(flag.getText());
		flag.click();
		for(WebElement countries:country)
		{
			System.out.println(countries.getText());
			if(countries.getText().equalsIgnoreCase(CountryName))
			{
              countries.click();
              
			}
		}
		
		WaitforElementDisappear(3000);
	}
	
	

}
