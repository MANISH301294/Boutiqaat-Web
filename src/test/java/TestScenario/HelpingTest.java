package TestScenario;

import java.time.Duration;

import org.testng.annotations.Test;

import baseTest.BaseTests;

public class HelpingTest extends BaseTests {
	
	@Test
	public void Link()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LaunchApplication();
		footer_page().windowHandleBySection();
	}

}
