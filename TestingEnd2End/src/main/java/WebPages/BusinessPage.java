package WebPages;

import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class BusinessPage extends TestBase {
	
	public BusinessPage()
	{
		PageFactory.initElements(driver, this);
		System.out.println("BusinessPage constructor");
	}
	

}
