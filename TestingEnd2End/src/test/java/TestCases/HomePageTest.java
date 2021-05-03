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

public class HomePageTest extends TestBase
{
	HomePage homePage;
	SignInPage SignInPage;
	BusinessPage BusinessPage;
	NewsPage newsPage;
	
//	public HomePageTest(){
//		
//		super();//using this it will not throw null pointer exception
//		System.out.println("HomePageTest constructor");
//		
//	}
	
	@BeforeMethod
	public void Initialize() throws IOException
	{
		System.out.println("Inside before method of homepagetest");
		InitializeDriver();
		SignInPage =new SignInPage();
		homePage=SignInPage.SignIn(prop.getProperty("Username"), prop.getProperty("Password"));
		BusinessPage=new BusinessPage();
		newsPage=new NewsPage();
		driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
		System.out.println("Inside before method of homepagetest-- ENd");
	}
	@Test
	public void NewsPageNavigationTest() {
		System.out.println("inside NewsPageNavigationTest ");
//		driver.switchTo().parentFrame();
		newsPage=homePage.ClickNewsPage();
	}
	
	@Test
	public void BusinessPageNavigationTest() {
		System.out.println("inside BusinessPageNavigationTest ");
//		driver.switchTo().parentFrame();
		BusinessPage=homePage.ClickBusinessPage();

	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
