package pageObjectModel;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import abstractComponent.AbstractComponent;

public class PLPPage  extends AbstractComponent {

	WebDriver driver;
	public PLPPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	   }
	@FindBy(xpath="//div[@class='product-item-details pb-2']")
	List<WebElement> plpItem;
	
	@FindBy(id="sorter")
	WebElement sort;
	
	@FindBy(tagName="dt")
	List<WebElement> filters;
	
	@FindBy(xpath="//div/div[@style='display: flex;']")
	List<WebElement> catfltr;
	
	@FindBy(xpath="(//div[@class='filter-summary'])[1]")
	WebElement VrfyCat;
	
	@FindBy(xpath="//input[@data-facet='true']")
	WebElement Checkbox;
	
	@FindBy(css=".clearall")
	WebElement ClearFltr;
	
	public void ScrollPlp() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		  js.executeScript("window.scrollBy(0,500)");
		  WaitforElementDisappear(2000);
		  js.executeScript("window.scrollBy(0,1500)");
		  WaitforElementDisappear(2000);
		  System.out.println("No. of product in plp = "+plpItem.size());
		  WaitforElementDisappear(2000);
		  LoginPage login =new LoginPage(driver);
		  login.BackToTop.click();
		  WaitforElementDisappear(2000);
		  
	}
		public void Sorting(String SortMethod) throws InterruptedException
		{
			Select dropdown = new Select(sort);
			dropdown.selectByVisibleText(SortMethod);
			WaitforElementDisappear(2000);
			System.out.println("sort = " + dropdown.getFirstSelectedOption().getText());	  
	}
		
		public void Filter(String FilterName,String subCat) throws InterruptedException
		{
			// ----------------** Filter By Category **----------------------------------
			WaitforElementDisappear(2000);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,700)");
			WaitforElementDisappear(2000);
			for (WebElement filter : filters) {
				if (filter.getText().equals(FilterName)) {
					System.out.println("SubCategories are = " + catfltr.size());
					for (WebElement catsfltrs : catfltr) {						
						if (catsfltrs.getText().contains(subCat)) {
							Checkbox.click();
							Thread.sleep(3000);	
							break;
						}
						break;

					}
					break;
				}
				break;
			}

		
		}

	
}
