package raBi_maven.extent_report;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alpha_locaters
{

	public static WebDriver driver;
	public long timeout=20;
	public long pageout=20;
	@SuppressWarnings("deprecation")
	@BeforeClass
	public void predefined() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(pageout, TimeUnit.SECONDS);
	}	
	
	@AfterClass
	public void lacters()
	{
		driver.get("https://automationbookstore.dev/");
		//locating Book 5th 
		
	}
}
