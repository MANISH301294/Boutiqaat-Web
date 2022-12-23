package baseTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjectModel.AddressPage;
import pageObjectModel.AddtoCartBlock;
import pageObjectModel.BagTotal;
import pageObjectModel.BrandPage;
import pageObjectModel.CategoryPage;
import pageObjectModel.CheckOutPage;
import pageObjectModel.Country;
import pageObjectModel.LoginPage;
import pageObjectModel.MiniCartPage;
import pageObjectModel.OrderHistoryPage;
import pageObjectModel.PDPPage;
import pageObjectModel.PLPPage;
import pageObjectModel.RegisterPage;
import pageObjectModel.YouMayAlsoLikePage;

public class BaseTests {
	
	public WebDriver driver;
	RegisterPage	register;
	LoginPage login;
	
	
	@BeforeTest
	public WebDriver initializeDriver()
	
	{
		
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	public String SystemDateforRegisterUser()
	{
		DateTimeFormatter dtf =  DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	    LocalDateTime now = LocalDateTime.now();
	    String sysdte = dtf.format(now);
	    System.out.println(sysdte);
	    return sysdte;
	}
	

	public RegisterPage LaunchApplication()
	{
		//driver = initializeDriver();
		register  = new RegisterPage(driver);
		register.goTo();
		return register;
	}
	
	public void LogOut()
	{
		register.LogOut();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	public LoginPage Login() throws InterruptedException
	{
		LoginPage login =new LoginPage(driver);
		
		return login;
	}
	
//	public void Wish_List()
//	{
//		login.WishList();
//	}
//	
//	public void cart_size()
//	{
//		login.cart_Size();
//	}
//	
//	public void Back_to_Top()
//	{
//		login.Back_to_Top();
//	}
		
	public PLPPage PLPpage()
	{
		PLPPage plp = new PLPPage(driver);
		return plp;	
	}
	
	public BrandPage Brandpage()
	{
		BrandPage brands = new BrandPage(driver);
		return brands;
	}
	
	public AddtoCartBlock  Add_Cart()
	{	
		AddtoCartBlock addtoCart = new AddtoCartBlock(driver);
		return addtoCart;
	}
	
	public CategoryPage Cat_Page()
	{
		CategoryPage catPage = new CategoryPage(driver);
		return catPage;
	}
	
	public PDPPage pdp_page()
	{
		PDPPage pdp = new PDPPage(driver);
		return pdp;
	}
	
	public YouMayAlsoLikePage Youmay_Like()
	{
		YouMayAlsoLikePage like = new YouMayAlsoLikePage(driver);
		return like;
	}
	
	public Country Country_change()
	{
		Country cn = new Country(driver);
		return cn;
	}
	
	public MiniCartPage MiniCart_Model() throws InterruptedException
	{
		MiniCartPage CP =new MiniCartPage(driver);
		return CP;
	}
	
	public BagTotal my_Bag()
	{
		BagTotal Bg= new BagTotal(driver);
		return Bg;
	}
	
	public AddressPage Address()
	{
		AddressPage ad = new AddressPage(driver);
		return ad;
	}
	
	public CheckOutPage Check_Out()
	{
		CheckOutPage ChckOut = new CheckOutPage(driver);
		return ChckOut;
	}
	
	public OrderHistoryPage Order_History()
	{
		OrderHistoryPage order = new OrderHistoryPage(driver);
		return order;
	}
}
