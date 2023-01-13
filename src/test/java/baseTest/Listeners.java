package baseTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;

public class Listeners extends BaseTests implements ITestListener{
	ExtentTest test ;
	ExtentReports extent = ExtentReporterNG.getReportObject();
	  
	
	 
		@Override  
		public void onTestStart(ITestResult result) {  
		// TODO Auto-generated method stub  
		test =	extent.createTest(result.getMethod().getMethodName());
		
		}  
		  
		@Override  
		public void onTestSuccess(ITestResult result) {  
		// TODO Auto-generated method stub  
		System.out.println("Success of test cases and its details are : "+result.getName());
		test.log(Status.PASS, "Test Passed");
		}  
		  
		@Override  
		public void onTestFailure(ITestResult result) {  
		// TODO Auto-generated method stub  
		System.out.println("Failure of test cases and its details are : "+result.getName());  
		test.log(Status.FAIL, "Test Fail");
		test.fail(result.getThrowable());
		
		//ScreenShot , And Attach to Extent Report 
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		String screenshotPath =null;
		try {
	    screenshotPath =	getScreenShot(result.getMethod().getMethodName(),driver);
		
		}  
		catch(IOException e)
		{
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(screenshotPath, result.getMethod().getMethodName());
		}
		@Override  
		public void onTestSkipped(ITestResult result) {  
		// TODO Auto-generated method stub  
		System.out.println("Skip of test cases and its details are : "+result.getName());  
		}  
		  
		@Override  
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
		// TODO Auto-generated method stub  
		System.out.println("Failure of test cases and its details are : "+result.getName());  
		}  
		  
		@Override  
		public void onStart(ITestContext context) {  
		// TODO Auto-generated method stub  
		}  
		  
		@Override  
		public void onFinish(ITestContext context) {  
		// TODO Auto-generated method stub  
			
			extent.flush();
		}  
		}  	

