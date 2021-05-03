package TestCases;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import org.testng.AssertJUnit;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import Base.TestBase;
import Log4j.Log;
import Reports.ExtentTestManager;
import WebPages.SignInPage;

@Listeners(TestNgSupportFeatures.Listeners.class)
public class SignInPageTest extends TestBase
{   
	
	SignInPage SignInPage;
	
//	public SignInPageTest(){		
//		super();//using this it will not throw null pointer exception
//	}
	
	
	@BeforeMethod
	public void Setup() throws IOException
	{
		
		InitializeDriver();
		//imp
		SignInPage=new SignInPage();

	}	

	@Test
	public void SignInPageTitleTest()
	{
		String pageTitle=SignInPage.GetPageTitle();
		AssertJUnit.assertEquals(pageTitle, "Rediff MyPage Login");
		ExtentTestManager.getTest().log(Status.INFO, "inside SignInPageTitleTest");
		
		
	}

	@Test
	public void SignInTest()
	{
		String username=prop.getProperty("Username");
		String Password=prop.getProperty("Password");
		SignInPage.UncheckKeepMeSignInCheckBox();
		SignInPage.SignIn(username, Password);
		
		ExtentTestManager.getTest().log(Status.INFO, "inside SignInTest");
	}
	
	@Test
	public void NegativeSignInTest()
	{
		SignInPage.UncheckKeepMeSignInCheckBox();
		SignInPage.SignIn("vgv", "dfvdf");
		AssertJUnit.assertTrue(SignInPage.errorMessageISDisplayed());
		
		ExtentTestManager.getTest().log(Status.INFO, "inside NegativeSignInTest");
	}
	
	@Test
	public void IsCheckBoxDisplayesdTest()
	{
		Boolean value=SignInPage.IsCheckboxDisplayed();
		Assert.assertFalse(value);
		
		ExtentTestManager.getTest().log(Status.INFO, "inside IsCheckBoxDisplayesdTest");
	}
	

	@AfterMethod(enabled=true)
	public void tearDown(){
		driver.quit();
	}
	
	
}
