package pageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponent;

public class CategoryPage extends AbstractComponent {
	
	WebDriver driver;
	
	public CategoryPage(WebDriver driver)
	{
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul/li[@class='level-2 nav-item ddfull subnav']")
	WebElement navBar;
	
	@FindBy(xpath="//ul/li[@class='level-2 nav-item ddfull subnav']/div/ul/li/a")
	List<WebElement> ScndCtgry;
	
	@FindBy(xpath="//li[@class='level-2 nav-item ddfull subnav']/div/ul/li/div/ul/li")
	List<WebElement> ThrdCtgry;
	
	@FindBy(css="div[class='container pl-2'] ul li:nth-child(5)")
	WebElement CatName;
	
	public void Category(String SubCategory) 
	{
		Actions a = new Actions(driver);
		a.moveToElement(navBar).build().perform();
		System.out.print("Second level Categories = ");
		for(WebElement scndLevel:ScndCtgry)
		{		
			a.moveToElement(scndLevel, 0, ScndCtgry.size()).build().perform();			
			System.out.println(scndLevel.getText()+",");
		}
		System.out.println();
		System.out.print("Third level of Categories = ");
		System.out.println(ThrdCtgry.size());
		for(WebElement ThrdCtgries:ThrdCtgry)
		{
			Actions ac =new Actions(driver);
			ac.moveToElement(navBar, 0,21).build().perform();
			System.out.print(ThrdCtgries.getText()+",");		
		}
		for(WebElement ctgry:ThrdCtgry)
		{
			if(ctgry.getText().equals(SubCategory))
			{
				ctgry.click();
			}
		}
		waitforElementToAppear(CatName);
		
	}
}
