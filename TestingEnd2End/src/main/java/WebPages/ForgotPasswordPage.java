package WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class ForgotPasswordPage extends TestBase{
	
	@FindBy(xpath = "//input[@id='txtlogin']")
	WebElement EmailTextBox;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement submitButton;
	
	public ForgotPasswordPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void EnterEmail(String Email)
	{
		EmailTextBox.sendKeys(Email);
	}
	
	public ConfirmItsYou clickSubmit()
	{
		submitButton.click();
		return new ConfirmItsYou(); 
	}
}
