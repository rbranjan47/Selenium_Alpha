package raBi_maven.extent_report;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alpha_locaters  //we can also call it as Relative locaters
{

	public  WebDriver driver;
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
	
	@Test(description =  "We have to Locate the 5th Book which is down of Book 1 and left of Book 6")
	public void locatersTest()
	{
		driver.get("https://automationbookstore.dev/");
		WebElement book6=driver.findElement(By.xpath("//h2[contains(text(),'Advanced Selenium in Java')]"));
		WebElement book1=driver.findElement(By.xpath("//h2[contains(text(),'Test Automation in the Real World')]"));
		
		WebElement book5 = driver.findElement(RelativeLocator.withTagName("li").toLeftOf(book6).below(book1));
		String id=book5.getAttribute("id");
		String name=book5.getText();
		System.out.println("Id : "+id+" & Book Name : "+name);
	}
	
	@AfterClass
	public void lacters()
	{
		driver.quit();
	}
}
