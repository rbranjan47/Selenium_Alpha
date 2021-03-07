package raBi_maven.extent_report;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Test_Extent_Report 
{
	ExtentReports report;
	
	@BeforeTest
	public void config_path()
	{
		//2 types of extent report prepartion way:
		//extent report and extentsparkreport
		
		String path=System.getProperty("user.dir")+"\\reports\\report.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		
		//setting name of report file
		reporter.config().setReportName("automation_reports");
		
		//setting Title of Document
		reporter.config().setDocumentTitle("raBi_automation");
		
		
		//extent report creation
		 report=new ExtentReports();
		report.attachReporter(reporter);
		
		//set teter name 
		report.setSystemInfo("Tester", "raBi ranjan");
		
	}
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void extent_report()
	{
	
		//to get the reort of any testcase, we have to call a method
		report.createTest("extent_report"); 
		System.setProperty("webdriver.chrome.driver", "G:\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://amazon.in");
		driver.getTitle();
		
		//lastly we have to put flush so, that it means test end here
		report.flush();
	}

}
