package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import jdk.internal.org.jline.utils.Log;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public void InitializeDriver() throws IOException {

		FileInputStream fis= new FileInputStream ("C:\\Users\\Himanshu\\eclipse-workspace\\TestingEnd2End\\src\\main\\java\\Config\\Config.properties");
		prop=new Properties();
		prop.load(fis);
		String browserName=prop.getProperty("Browser");
		
//		Log.info(browserName + " is selected");
		
		if(browserName.equals("Chrome"))
		{
			
			System.out.println("Chrome browser is selected");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Himanshu\\Documents\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if (browserName.equals("Firefox"))
		{

			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Himanshu\\Documents\\Selenium\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
		}

		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--disable-gpu");
		driver.get(prop.getProperty("Url"));
//		Log.info("Application launched with URL " + prop.getProperty("Url"));

	
	}
	
	
	public String getScreenshotPath(String testCaseName) throws IOException
	{
		//Convert web driver object to TakeScreenshot
		TakesScreenshot ts=(TakesScreenshot) driver;
		
		//Call getScreenshotAs method to create image file
		File sourceFile=ts.getScreenshotAs(OutputType.FILE);
		
		//In Java, we can use System.getProperty("user.dir") to get the current working directory
		String destinationPath=System.getProperty("user.dir")+"\\Reports\\Screenshots\\"+testCaseName+".png";
		File destFile=new File(destinationPath);
		FileHandler.copy(sourceFile, destFile);
		
		return destinationPath;
		
	}
	
	public Object[][] GetDataFromExcel() throws IOException
	{
		
		FileInputStream fis=new FileInputStream("C:\\Users\\Himanshu\\Desktop\\Email Address list.xlsx");
		Workbook wb=new XSSFWorkbook(fis);
		Sheet emailSheet=wb.getSheet("Email address");
		
		int rowCount=emailSheet.getLastRowNum()-emailSheet.getFirstRowNum();
		System.out.println();
		Object[][] data=new Object[emailSheet.getLastRowNum()][1];
		System.out.println(rowCount + " is row count");
		for (int i = 0; i < emailSheet.getLastRowNum(); i++) {
			System.out.println("entering data un object data" + i);
			data[i][0]= emailSheet.getRow(i+1).getCell(1).getStringCellValue();
			
		}
		wb.close();
		return data;
		
	}
	

}
