package pageObjectModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import abstractComponent.AbstractComponent;


public class RegisterPage extends AbstractComponent
{
	WebDriver driver;
	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Register link 
	@FindBy(css="div[class='links register'] a")
	WebElement registerLink;
	//Registration form 
	
	@FindBy(xpath="//div[@class='login-container register col-md-4 pl-0 pr-0']//input[@placeholder='Email']")
	WebElement useremail;
	
	@FindBy(xpath="//input[@class='ReactPasswordStrength-input form-control']")
	WebElement userpassword;
	
	@FindBy(xpath="//input[@name='full_name']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='mobile_number']")
	WebElement usermobile;
	
	@FindBy(xpath="//label[@for='customControl1']")
	WebElement usergender;
	
	@FindBy(xpath="//button[normalize-space()='Register']")
    WebElement submit;
	
	@FindBy(css="div[role='alert']")
	WebElement alertMessage;
	
	@FindBy(xpath="//div[@class='links welcome seperator']")
	WebElement registerUserName;
	
	@FindBy(xpath="//div[@class='links register']/a")
	WebElement account;
	
	@FindBy(xpath="(//div[@class='col-md-9 right-pane']/div/ul/div/div/li/address/div)[2]")
	WebElement UserEmail;
	
	@FindBy(css=".singOut")
	WebElement logout;
	
	@FindBy(xpath="//span[normalize-space()='MEN']")
	WebElement Gender;
		
	public void registerApplication(String email,String password,String name,String mobile) throws InterruptedException
	{
		WaitforElementDisappear(2000);
		registerLink.click();
		useremail.sendKeys(email);
		userpassword.sendKeys(password);
		username.sendKeys(name);
		usermobile.sendKeys(mobile);
		usergender.click();
		submit.click();
		waitforElementToAppear(alertMessage);
		
	}	
	
	public void alert_Register_Faiure_Message()
	{
		   String message = alertMessage.getText();
		   System.out.println(message);
		   Assert.assertEquals(message, "There is already an account with this email address.");
	}
	
	public void alert_Register_Success_Message()
	{
		String message = alertMessage.getText();
		System.out.println(message);
		Assert.assertEquals(message,"Customer successfully registered.");
		
	}
	
	public void verifyRegisterUserName()
	{
		waitforElementToAppear(registerUserName);
		   String username = registerUserName.getText();
		   System.out.println(username.length()); 
		   String check = username.substring(4);
		   System.out.println(check);
		   Assert.assertEquals(check,"Test_Boutiqaat");		
	}
	
	public String get_User_Name() throws InterruptedException
	{
		account.click();
		WaitforElementDisappear(2000);
		String  email = UserEmail.getText();
		return email;
		
	}
	
	public void goTo()
	{
		driver.get("https://www.boutiqaat.com/en-kw/men/");
		//Gender.click();
	}
	
	public void LogOut()
	{
		waitforElementToAppear(logout);
		logout.click();
		   
	}

	
}