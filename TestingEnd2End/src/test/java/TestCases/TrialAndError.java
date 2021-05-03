package TestCases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import Base.TestBase;
import WebPages.BusinessPage;
import WebPages.HomePage;
import WebPages.NewsPage;
import WebPages.SignInPage;

public class TrialAndError extends TestBase
{
	HomePage homePage;
	SignInPage SignInPage;
	
	@BeforeMethod
	public void Initialize() throws IOException
	{
		InitializeDriver();
		SignInPage =new SignInPage();
		homePage=SignInPage.SignIn(prop.getProperty("Username"), prop.getProperty("Password"));
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	@Test
	public void NewsPageNavigationTest() {
		homePage.ClickNewsPage();
	}
	
	@Test
	public void BusinessPageNavigationTest() {
		homePage.ClickBusinessPage();

	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
