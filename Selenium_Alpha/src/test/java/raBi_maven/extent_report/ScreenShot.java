package raBi_maven.extent_report;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShot
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
	
	@Test(priority = 1) //taking screenshot of the picture
	public void screenshotTest_logo() throws IOException
	{
		//Screen Shot of the Element
		WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		File logo_file=logo.getScreenshotAs(OutputType.FILE);
		File location=new File("Demo_logo_ScreenShot.png");
		
		//Storing this file
		FileUtils.copyFile(logo_file, location);	
	}
	
	@Test(priority = 2) //taking screen shot of the 
	public void screenshot_Page() throws IOException
	{
		TakesScreenshot scr=(TakesScreenshot) driver;
		File scr_file=scr.getScreenshotAs(OutputType.FILE);
		File scr_outFile=new File("HomePage.png");
		
		//Storing the File
		FileUtils.copyFile(scr_file, scr_outFile);
	}
	
	@Test(priority = 3) //screenshot of the section of the WebPage
	public void ScreenShot_Section() throws IOException
	{
		WebElement section=driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		File section_file=section.getScreenshotAs(OutputType.FILE);
		File section_out=new File("Section.png");
		
		//storing the files
		FileUtils.copyFile(section_file, section_out);
	}
	
	@Test(priority = 4) //screen of the Particular elements
	public void screenshot_element()  throws IOException
	{
		//Screen Shot of the Element
				WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
				File logo_file=logo.getScreenshotAs(OutputType.FILE);
				File location=new File("Demo_logo_ScreenShot.png");
				
				//Storing this file
				FileUtils.copyFile(logo_file, location);	
	}
	@AfterClass
	public void Exiting() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
	}
}
