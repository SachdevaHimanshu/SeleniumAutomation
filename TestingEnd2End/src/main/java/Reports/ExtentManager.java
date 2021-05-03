package Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager 
{

	private static ExtentReports extent;
	private static String reportFileName = "Test-Automaton-Report"+".html";
	private static String fileSeperator = System.getProperty("file.separator");
	private static String reportFilepath = System.getProperty("user.dir") +fileSeperator+ "TestReport";
	private static String reportFileLocation =  reportFilepath +fileSeperator+ reportFileName;
	
	
	public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }
	
	public static ExtentReports  createInstance() {
		// initialize the HtmlReporter
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportFileLocation);
		
		//Configuring the HTML report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(reportFileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(reportFileName);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
      //Set environment details
      		extent.setSystemInfo("OS", "Windows");
      		extent.setSystemInfo("AUT", "QA");
		
      		 return extent;
	}
	
	
}
