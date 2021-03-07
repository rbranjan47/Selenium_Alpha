package raBi_maven.extent_report;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class New_Tab 
{
	public long timeout=20;
	public long pageout=20;
	@SuppressWarnings("deprecation")
	@Test
	public void newTab() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(pageout, TimeUnit.SECONDS);
		
		
		
		driver.get("https://www.orangehrm.com/");
		//after opening one Browser in one Tab, we will open it in Another Tab
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://freecrm.com/");
		Thread.sleep(5000);
		driver.quit();
		
	}
}
