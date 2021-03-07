package raBi_maven.extent_report;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Yahoo_Login 
{
	
	WebDriver driver;
	ExtentReports  report;
	
	@BeforeTest
	public void extent_report()
	{
		String file=System.getProperty("user.dir")+"\\reports_1\\final.html";
		ExtentSparkReporter spark=new ExtentSparkReporter(file);
		
		
		//setting name
		spark.config().setReportName("Yahoo automation report");
		
		//setting title
		spark.config().setDocumentTitle("Yaho automation");
		
		//extent reports 
		report=new ExtentReports();
		report.attachReporter(spark); 
		
		
	}
		
	@SuppressWarnings("deprecation")
	@Test
	public void login() throws InterruptedException
	{
		
		report.createTest("login");
		
		
		ExtentTest test=report.createTest("login");
		//screen shot of extent report
		test.addScreenCaptureFromBase64String("Screen_Shot_extent");
		
		
		
		System.setProperty("webdriver.chrome.driver", "G:\\chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		
		driver.get("https://www.google.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Yahoo");
		driver.findElement(By.xpath("//li[1][@class='sbct']")).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'Yahoo India | News, Finance, Cricket, Lifestyle and ...')]")).click();
	
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Sign in')]")).click();
		
		driver.findElement(By.id("login-username")).sendKeys("qatestrabi@yahoo.com");
		driver.findElement(By.id("login-signin")).click();
		
		driver.findElement(By.id("password-container")).sendKeys("testmakeperfect");
		driver.findElement(By.id("login-signin")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Mail')]")).click();
		
		driver.findElement(By.xpath("//a[@data-test-id='compose-button']")).click();
		
		driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys("rbranjan47@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys("Message by automation");
		
		driver.findElement(By.xpath("//div[@aria-label='Message body']")).sendKeys("This is machine generated mail. Please Do not reply to him");
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//button[@data-test-id='emoji-picker-button']")).click();
		driver.findElement(By.xpath("//img[@data-test-id='emoji-image']/../../../../li[2]/ul/li[3]")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Send')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'QA')]")).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'Sign out')]")).click();
		
		driver.close();
		
		
		report.flush();
	}
	
}
