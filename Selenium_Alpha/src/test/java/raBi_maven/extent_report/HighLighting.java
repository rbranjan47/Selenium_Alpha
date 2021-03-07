package raBi_maven.extent_report;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HighLighting 
{
	public  WebDriver driver;
	public long timeout=20;
	public long pageout=20;
	@SuppressWarnings("deprecation")
	@BeforeClass
	public void setup() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(pageout, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}	
	
	@Test (priority = 1)//javascript executor
	public void highlightning()
	{
		WebElement element=driver.findElement(By.xpath("//img[@title='Show details for HTC One M8 Android L 5.0 Lollipop']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		js.executeScript("arguments[0].style.border='2px solid red'", element);
		
	}
	
	@Test(priority = 2)
	public void screenShot() throws IOException
	{
		//Screen Shot of the Element
				WebElement highlighted=driver.findElement(By.xpath("//img[@title='Show details for HTC One M8 Android L 5.0 Lollipop']"));
				File logo_file=highlighted.getScreenshotAs(OutputType.FILE);
				File location=new File("highlighted.png");
				
				//Storing this file
				FileUtils.copyFile(logo_file, location);
	}
	
	@AfterClass
	public void Exiting() throws InterruptedException
	{
		Thread.sleep(10000);
		driver.quit();
	}

}
