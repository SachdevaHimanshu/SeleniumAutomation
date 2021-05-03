package WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class NewsPage extends TestBase{
	
	@FindBy(xpath = "//input[@value='Email Address']")
	WebElement EmailAddressTextBox;
	
	@FindBy(xpath = "//input[@type='button']")
	WebElement EmailAddressSubmitButton;
	
	@FindBy(xpath ="//b[contains(text(),'Thank you for subscribing')]")
	WebElement SubscribingMessage;
	
	public NewsPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public void ClickSubmit()
	{
		EmailAddressSubmitButton.click();
	}
	
	public void EnterEmailAddress (String Email)
	{
		EmailAddressTextBox.sendKeys(Email);;
	}
	
	
	public String GetSubscribeMessageText ()
	{
		return SubscribingMessage.getText();
	}
	
	
	
	
	
	

}
