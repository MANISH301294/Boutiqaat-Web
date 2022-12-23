package TestScenario;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import baseTest.BaseTests;
import pageObjectModel.Celebritypage;
import pageObjectModel.RegisterPage;

public class FinalTest extends BaseTests {

	RegisterPage regstr;

	@Test
	public void AllScenario() throws InterruptedException {

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
		Login().Global_Search("SHIRT");
		Login().Country_Name();
		Login().WishList();
		Login().cart_Size();
		Login().ScrollDown();
		Login().Boutiqaat_Picks();
		Login().Refresh();
		Login().Back_to_Top();
		Login().cart_Size();
		Login().Refresh();

//	Celebrity Pages 
		Celebritypage Celeb_page = new Celebritypage(driver);
		Celeb_page.Nav();
		Celeb_page.Clebrity();
		Celeb_page.Alphano();
		Celeb_page.SearchCeleb("YOUSEF AL MOHAMMED");
//Celebrity PLP Page 
		PLPpage().ScrollPlp();
		PLPpage().Sorting("Price: High to Low");
		PLPpage().Filter("Category", "Accessories");

// add To Cart 		
		Add_Cart().ItemInfo("Test", "Test121@tester.com", "5878767895");
		Login().cart_Size();

// Brand Page 
		Brandpage().Brand();
// Brand PLP Page 
		PLPpage().ScrollPlp();
		PLPpage().Sorting("Latest");
		PLPpage().Filter("Category", "Accessories");

		Add_Cart().ItemInfo("Test", "Test121@tester.com", "5878767895");
		Login().cart_Size();

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
			Login().cart_Size();
		} catch (NoSuchElementException e) {
			Login().cart_Size();
		}
		
		Youmay_Like().YouMayLike();
		
		try {
			pdp_page().Pdp_Page();
			pdp_page().Ratings("Good", "Good Quality");
			pdp_page().SizeOfProduct();
			pdp_page().Wishlist();
			pdp_page().Scrolling();
			Login().cart_Size();
		} catch (NoSuchElementException e) {
			Login().cart_Size();
		}	
			//Country_change().country("Iraq");
			MiniCart_Model().MiniCart();
			my_Bag().Bag();
			Address().Add_Address();
			Check_Out().CheckOut("KNet");
			//Order_History().Order();
			tearDown();
}}
