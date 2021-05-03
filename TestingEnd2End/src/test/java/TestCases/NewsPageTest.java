package TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;
import WebPages.HomePage;
import WebPages.NewsPage;
import WebPages.SignInPage;

public class NewsPageTest extends TestBase{
	SignInPage signInPage;
	HomePage Homepage;
	NewsPage NewsPage;
	
	
	@BeforeMethod
	public void Setup() throws IOException
	{
		InitializeDriver();
		Homepage=new HomePage();
		signInPage=new SignInPage();
		NewsPage=new NewsPage();
		Homepage=signInPage.SignIn(prop.getProperty("Username"), prop.getProperty("Password"));
		driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
		NewsPage=Homepage.ClickNewsPage();
		
	}
	
	@Test(dataProvider = "GetEmailIdList")
	public void SubmitCorrectEmailTest(String email)
	{
		System.out.println("passing email" + email);
		NewsPage.EnterEmailAddress(email);
		NewsPage.ClickSubmit();
		String ActualMessage=NewsPage.GetSubscribeMessageText();
		AssertJUnit.assertEquals(ActualMessage, "Thank you for subscribing !");
	}
	
	@Test(enabled = false)
	public void SubmitInCorrectEmailTest()
	{
		NewsPage.EnterEmailAddress("Sachdeva@yahoo.efwfwedwedwed");
		NewsPage.ClickSubmit();
		Alert alert = driver.switchTo().alert();
		String PopUpMessage=alert.getText();
		alert.accept();
		AssertJUnit.assertEquals(PopUpMessage, "Please enter a valid email");
	}
	@DataProvider
	public Object[][] GetEmailIdList() throws IOException
	{
		
		Object[][] data=GetDataFromExcel();
		return data;
		
	}
	
	
	@AfterMethod(enabled = true)
	public void TearDown()
	{
		driver.quit();
	}

}
