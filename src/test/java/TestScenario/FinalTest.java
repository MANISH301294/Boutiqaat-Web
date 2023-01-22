package TestScenario;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseTest.BaseTests;
import pageObjectModel.RegisterPage;

public class FinalTest extends BaseTests {

	RegisterPage regstr;

	@Test(dataProvider ="getData")
	public void AllScenario(HashMap<String,String> input) throws InterruptedException {

		// Implicit_Wait();
//----------Launching the Application----------
		LaunchApplication();
//---------Register with Registered email--------	
		RegisterPage regstr = new RegisterPage(driver);
		regstr.registerApplication("rastogimanish1312@gmail.com", "Tester@123", "Test", "8938478923");
		regstr.alert_Register_Faiure_Message();
//-----------Register with Valid Credential----------
		regstr.registerApplication("Test" + SystemDateforRegisterUser() + "@Boutiqaat.com", "Tester@123",
				"Test_Boutiqaat", "7896587567");
		regstr.alert_Register_Success_Message();
		regstr.verifyRegisterUserName();

//-----------Get The RegisterUser Email--------------		
		String eml = regstr.get_User_Name();
//----------Logout------------------		
		LogOut();
//----------LogIN with Invalid Credential------------------
		Login().LoginUser(eml, "Teste");
		Login().alert_Login_Faiure_Message();
//  -----------Login With Valid Credentials--------		
		Login().LoginUser(eml, "Tester@123");
// ------------Global Search/Country Name/Wish list count/Add to cart --------------	
		Home_Page().Global_Search("SHIRT");
		Home_Page().Country_Name();
		Home_Page().WishList();
		Home_Page().cart_Size();
		Login().ScrollDown();
		Login().Boutiqaat_Picks();
		Login().Refresh();
		Home_Page().Back_to_Top();
		Home_Page().cart_Size();
		Login().Refresh();

//	Celebrity Pages 
		//Celebritypage Celeb_page = new Celebritypage(driver);
		Home_Page().Nav();
		cel_Pages().Clebrity();
		cel_Pages().Alphano();
		cel_Pages().SearchCeleb("YOUSEF AL MOHAMMED");
//Celebrity PLP Page 
		PLPpage().ScrollPlp();
		PLPpage().Sorting("Price: High to Low");
		PLPpage().Filter("Category", "Grooming & Personal Care");
// add To Cart 		
		Add_Cart().ItemInfo("Test", "Test121@tester.com", "5878767895");
		Home_Page().cart_Size();
//		try {
//			pdp_page().Pdp_Page();
//			pdp_page().Ratings("Good", "Good Quality");
//			pdp_page().SizeOfProduct();
//			pdp_page().Wishlist();
//			pdp_page().Scrolling();
//			Login().cart_Size();
//		} catch (NoSuchElementException e) {
//			Login().cart_Size();
//		}
// Brand Page 
		Brandpage().Brand();
// Brand PLP Page 
		PLPpage().ScrollPlp();
		PLPpage().Sorting("Latest");
		PLPpage().Filter("Category", "Accessories");
		Add_Cart().ItemInfo("Test", "Test121@tester.com", "5878767895");
		
		try {
			pdp_page().Pdp_Page();
			pdp_page().Ratings("Good", "Good Quality");
			pdp_page().SizeOfProduct();
			pdp_page().Wishlist();
			pdp_page().Scrolling();
			Home_Page().cart_Size();
		} catch (NoSuchElementException e) {
			Home_Page().cart_Size();
		}

// Category page 

		Cat_Page().Category("SHORTS");
// Category PLP Page 
		PLPpage().ScrollPlp();
		PLPpage().Sorting("Price: Low to High");
		PLPpage().Filter("Brand", "adidas");
		Add_Cart().ItemInfo("Test", "Test121@tester.com", "5878767895");
		try {
			pdp_page().Pdp_Page();
			pdp_page().Ratings("Good", "Good Quality");
			pdp_page().SizeOfProduct();
			pdp_page().Wishlist();
			pdp_page().Scrolling();
			Home_Page().cart_Size();
		} catch (NoSuchElementException e) {
			Home_Page().cart_Size();
		}

		Youmay_Like().YouMayLike();

		try {
			pdp_page().Pdp_Page();
			pdp_page().Ratings("Good", "Good Quality");
			pdp_page().SizeOfProduct();
			pdp_page().Wishlist();
			pdp_page().Scrolling();
			Home_Page().cart_Size();
		} catch (NoSuchElementException e) {
			Home_Page().cart_Size();
		}
		// Country_change().country("Iraq");
		MiniCart_Model().MiniCart();
		my_Bag().Bag();
		Address().Add_Address(input.get("Name"), input.get("Area"), input.get("Block"), input.get("Street"), input.get("Villa"), input.get("Mobile"), input.get("Address"), input.get("City"), input.get("Civil"));
		Check_Out().CheckOut("KNet");
		Order_History().OrderPage();
		//tearDown();

	}

//	@Test
//	public void ErrorValidationTest() throws InterruptedException
//	{
//		//----------Launching the Application----------
//				LaunchApplication();
//				
//    	//  -----------Login With Valid Credentials--------		
//				Login().LoginUser("Test-Manish@Boutiqaat.com", "Tester");
//				Login().alert_Success_Message();
				
				
	//}
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//projectData//ContryAddress.json");

		return new Object[][] { { data.get(0)} };
	}

}
