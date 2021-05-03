package WebPages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Base.TestBase;

public class SignInPage extends TestBase {
	
	
	@FindBy(xpath = "//*[@id=\"txtlogin\"]")
	WebElement usernameTextBox;
	
	@FindBy(id = "pass_box")
	WebElement passwordTextBox;
	
	//Syntax = //tagname[@attribute=’Value‘]
	@FindBy(xpath = "//input[@type='submit']")
	WebElement submitButton;
	
	@FindBy(linkText = "Forgot password?")
	WebElement forgotPasswordHyperlink;
	
	@FindBy(xpath = "//b[contains(text(),'rname and/or passw')]")
	WebElement ErrorMessage;
	
//	@FindBy(xpath =  "//a/u[contains(text(),'Forgot Password?')]")
//	WebElement forgotPasswordHyperlink;
	
//	@FindBy(partialLinkText = "orgot Passwo")
//	WebElement forgotPasswordHyperlink;
	
//	@FindBy(tagName = "a")
//	List allTagnameElements;
	
	@FindBy(xpath = "//*[@id=\"remember\"]")
	WebElement KeepMeSignInCheckBox;

	public SignInPage() {

		PageFactory.initElements(driver, this); // 'this' means current Page class as object. 

		//or
//		PageFactory.initElements(driver, SignInPage.class); this is not working
	}
	
	
	public void EnterUsername(String username) {
		usernameTextBox.sendKeys(username);
	}
	
	public void EnterPassword(String password) {
		passwordTextBox.sendKeys(password);
	}
	
	public void ClickSumbit() {
		submitButton.click();
	}

	public HomePage SignIn(String username, String password)
	{
		EnterUsername(username);
		EnterPassword(password);
		UncheckKeepMeSignInCheckBox();
		ClickSumbit();
		HomePage HomePage=new HomePage();
		return HomePage;
		//or
//		return new HomePage;
	}
	
	public String GetPageTitle()
	{
		String SignInPageTitle=driver.getTitle();
		System.out.println("SignInPageTitle is " + SignInPageTitle);
		return SignInPageTitle;
	}
	
	public void UncheckKeepMeSignInCheckBox()
	{
		if(KeepMeSignInCheckBox.isSelected());
		{

			KeepMeSignInCheckBox.click();
			
		}
	}
	public void checkKeepMeSignInCheckBox()
	{
		if(!KeepMeSignInCheckBox.isSelected());
		{

			KeepMeSignInCheckBox.click();
		}
	}
	
	public ForgotPasswordPage ClickForgotPasswordLink() {
		 forgotPasswordHyperlink.click();
		 ForgotPasswordPage PasswordForgotPage=new ForgotPasswordPage();
		 return PasswordForgotPage;
	}
	
	public boolean errorMessageISDisplayed () {
		 return ErrorMessage.isDisplayed();
		
		 
	}
	

	public Boolean IsCheckboxDisplayed()
	{

		return KeepMeSignInCheckBox.isDisplayed();
	}

}
