package baseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjectModel.AddressPage;
import pageObjectModel.AddtoCartBlock;
import pageObjectModel.BagTotal;
import pageObjectModel.BrandPage;
import pageObjectModel.CategoryPage;
import pageObjectModel.Celebritypage;
import pageObjectModel.CheckOutPage;
import pageObjectModel.Country;
import pageObjectModel.HomePage;
import pageObjectModel.LoginPage;
import pageObjectModel.MiniCartPage;
import pageObjectModel.OrderHistoryPage;
import pageObjectModel.PDPPage;
import pageObjectModel.PLPPage;
import pageObjectModel.RegisterPage;
import pageObjectModel.YouMayAlsoLikePage;

public class BaseTests {

	public WebDriver driver;
	RegisterPage register;
	LoginPage login;

	@BeforeTest
	public WebDriver initializeDriver() throws IOException
	{
	Properties prop = new Properties();
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//resources//GlobalData.properties");
	prop.load(fis);
	
	String browserName =  prop.getProperty("browser");

	
		if(browserName.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		
		driver = new ChromeDriver(options);
		}
		if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("incognito");
			driver = new FirefoxDriver(options);
			
		}
		
		if(browserName.equalsIgnoreCase("edgeDriver"))
		{
			WebDriverManager.edgedriver().setup();
			EdgeOptions option = new EdgeOptions();
			option.addArguments("incognito");
			driver = new EdgeDriver(option);
		}
		driver.manage().window().maximize();
		return driver;
	}

	public String SystemDateforRegisterUser() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		LocalDateTime now = LocalDateTime.now();
		String sysdte = dtf.format(now);
		System.out.println(sysdte);
		return sysdte;
	}

	public HomePage Home_Page() {
		HomePage home = new HomePage(driver);
		return home;
	}

	public RegisterPage LaunchApplication() {
		// driver = initializeDriver();
		register = new RegisterPage(driver);
		register.goTo();
		return register;
	}

	public void LogOut() {
		register.LogOut();
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

	public LoginPage Login() throws InterruptedException {
		LoginPage login = new LoginPage(driver);

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
	
	

	public PLPPage PLPpage() {
		PLPPage plp = new PLPPage(driver);
		return plp;
	}

	public BrandPage Brandpage() {
		BrandPage brands = new BrandPage(driver);
		return brands;
	}

	public AddtoCartBlock Add_Cart() {
		AddtoCartBlock addtoCart = new AddtoCartBlock(driver);
		return addtoCart;
	}

	public Celebritypage cel_Pages() {

		Celebritypage cel = new Celebritypage(driver);
		return cel;
	}

	public CategoryPage Cat_Page() {
		CategoryPage catPage = new CategoryPage(driver);
		return catPage;
	}

	public PDPPage pdp_page() {
		PDPPage pdp = new PDPPage(driver);
		return pdp;
	}

	public YouMayAlsoLikePage Youmay_Like() {
		YouMayAlsoLikePage like = new YouMayAlsoLikePage(driver);
		return like;
	}

	public Country Country_change() {
		Country cn = new Country(driver);
		return cn;
	}

	public MiniCartPage MiniCart_Model() throws InterruptedException {
		MiniCartPage CP = new MiniCartPage(driver);
		return CP;
	}

	public BagTotal my_Bag() {
		BagTotal Bg = new BagTotal(driver);
		return Bg;
	}

	public AddressPage Address() {
		AddressPage ad = new AddressPage(driver);
		return ad;
	}

	public CheckOutPage Check_Out() {
		CheckOutPage ChckOut = new CheckOutPage(driver);
		return ChckOut;
	}

	public OrderHistoryPage Order_History() {
		OrderHistoryPage order = new OrderHistoryPage(driver);
		return order;
	}

	// DataReader code - from JSON to HASHMAP
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		// user.dir - project path
		// path where we store the JSON
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

		// CONVERT STRING TO HASHMAP
		// For this we need a dependency JacksonDatabind

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});

		return data;
	}

	// ScreenShot

	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";

	}
}
