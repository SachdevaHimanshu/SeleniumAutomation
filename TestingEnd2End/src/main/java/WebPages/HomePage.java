package WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//a[contains(text(),'NEWS')]")
	WebElement NewsPageHyperlink;
	
	@FindBy(xpath="//a[contains(text(),'BUSINESS')]")
	WebElement BusinessPageHyperlink;
	
	@FindBy(linkText = "MOVIES")
	WebElement MoviesPageHyperlink;
	
	@FindBy(linkText = "CRICKET")
	WebElement CricketPageHyperlink;
	
	@FindBy(linkText = "SPORTS")
	WebElement SportsPageHyperlink;
	
	@FindBy(linkText = "REALTIME NEWS")
	WebElement RealtimeNewsPageHyperlink;
	
	@FindBy(linkText = "Elections 2021")
	WebElement Election2021PageHyperlink;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public NewsPage ClickNewsPage()
	{
//		NewsPageHyperlink.sendKeys("Keys.ESCAPE");
		NewsPageHyperlink.click();
		return new NewsPage();
	}
	
	public BusinessPage ClickBusinessPage()
	{
		BusinessPageHyperlink.click();
		return new BusinessPage();
	}
	


}
