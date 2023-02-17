package TestScenario;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseTest.BaseTests;

public class brandTest extends BaseTests {

	@Test(dataProvider = "getData")
	public void CheckOutScenario(HashMap<String, String> input) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LaunchApplication();
		Login().LoginUser("Boutiqaattestorders21@boutiqaat.com", "qwertY");
		Home_Page().Country_Name();
		Country_change().country("Iraq");
		Home_Page().WishList();
		Home_Page().cart_Size();

		Home_Page().Nav();

		// Brand Page
		Brandpage().Brand();
		// Brand PLP Page
		PLPpage().ScrollPlp();
		PLPpage().Sorting("Latest");
		PLPpage().Filter("Category", "Footwear");
		Add_Cart().ItemInfo("Test", "Test121@tester.com", "5878767895");

		try {
			pdp_page().Pdp_Page();
			pdp_page().Ratings("Test", "Test");
			pdp_page().SizeOfProduct();
			pdp_page().Wishlist();
			pdp_page().Scrolling();
			Home_Page().cart_Size();
		} catch (NoSuchElementException e) {
			Home_Page().cart_Size();
		}

		// You may like

		Youmay_Like().YouMayLike();

		try {
			pdp_page().Pdp_Page();
			pdp_page().Ratings("Test", "Test");
			pdp_page().SizeOfProduct();
			pdp_page().Wishlist();
			pdp_page().Scrolling();
			Home_Page().cart_Size();
		} catch (NoSuchElementException e) {
			Home_Page().cart_Size();
		}

		// cel_Pages().HomePage();

		MiniCart_Model().MiniCart();
		my_Bag().Bag();
		Address().Add_Address(input.get("Name"), input.get("Area"), input.get("Block"), input.get("Street"),
				input.get("Villa"), input.get("Mobile"), input.get("Address"), input.get("City"), input.get("Civil"));
		Check_Out().CheckOut("Cash on delivery");
		Check_Out().CashOnDelivery();
		Order_History().OrderHistory();
		
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//projectData//ContryAddress.json");

		return new Object[][] { { data.get(0) } };
	}
	
	
	@Test
public void ErrorValidationTest() throws InterruptedException
{
	//----------Launching the Application----------
			LaunchApplication();
			
	//  -----------Login With Valid Credentials--------		
			Login().LoginUser("Test-Manish@Boutiqaat.com", "Tester");
			Login().alert_Success_Message();
		

}}
