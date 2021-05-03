package StepDefinitions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Base.TestBase;
import WebPages.HomePage;
import WebPages.SignInPage;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class StepDefinition extends TestBase {

	SignInPage SignInPage;
	HomePage HomePage;

//	public  StepDefinition()
//	{
//		super();
//	}

	@BeforeMethod
	public void Initialize() throws IOException {
		InitializeDriver();
		SignInPage = new SignInPage();
	}

	@Given("^User is on SignIn Page$")
	public void user_is_on_SignIn_Page() throws Throwable {

		SignInPage.GetPageTitle();
		AssertJUnit.assertEquals(SignInPage.GetPageTitle(), SignInPage.GetPageTitle());
	}

	@When("^user enters username and password$")
	public void user_enters_username_and_password() throws Throwable {

		SignInPage.EnterUsername("SachdevaHimanshu21@rediff.com");
		SignInPage.EnterPassword("#21Rediff");

	}

	@When("^clicks on Submit button$")
	public void clicks_on_Submit_button() throws Throwable {

		SignInPage.ClickSumbit();
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("^user is navigated to Home Page$")
	public void user_is_navigated_to_Home_Page() throws Throwable {
		HomePage = new HomePage();
		// Write code here that turns the phrase above into concrete actions
	}

	@When("^user enters wrong username and password$")
	public void user_enters_wrong_credentials() throws Throwable {

		SignInPage.EnterUsername("erfe");
		SignInPage.EnterPassword("erfer");

	}

	@Then("^Error message should be displayed$")
	public void Error_message_displayed() throws Throwable {

		AssertJUnit.assertFalse(SignInPage.errorMessageISDisplayed());
	}

	@AfterMethod
	public void tearDown(Scenario scenario){
	    if (scenario.isFailed()) 
	    {
	        // Take a screenshot...
	        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	     // embed it in the report.
	        scenario.embed(screenshot, "image/png"); 
	    }
	    driver.quit();
	  }
	

}
