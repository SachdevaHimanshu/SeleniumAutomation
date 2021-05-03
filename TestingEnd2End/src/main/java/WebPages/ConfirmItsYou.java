package WebPages;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class ConfirmItsYou extends TestBase{
	
	@FindBy(xpath = "//*[@id=\"passwor_email\"]")
	WebElement RadioButtomEmailid;

	
	@FindBy(xpath = "//*[@id=\"mob_no\"]")
	WebElement RadioButtomMObNo;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement NextButton;
	
	public ConfirmItsYou()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ClickPhoneRadioButton(String ButtonToClick) {
		if(ButtonToClick.equals("Phone"))	
		{
			RadioButtomMObNo.click();
		}
		else if (ButtonToClick.equals("Email"))
		{
			RadioButtomEmailid.click();
		}
		
	}
	
	public void ClickNext() 
	{
		NextButton.click();
	}
	
}
