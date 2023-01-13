package pageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
		WaitforElementDisappear(1000);
		for(WebElement countries:country)
		{
			WaitforElementDisappear(500);
			
			if(countries.getText().equalsIgnoreCase(CountryName))
			{
	         countries.click();
	         
	         break;
	         }
			
		}
		
		WaitforElementDisappear(3000);
	}
	
	public void SelectCountry(String CountryName) throws InterruptedException
	{
		Select dropdown = new Select(flag);
		dropdown.selectByVisibleText(CountryName);
		WaitforElementDisappear(3000);
		System.out.println("Selected country = "+ dropdown.getFirstSelectedOption().getText());
	}
	
}
