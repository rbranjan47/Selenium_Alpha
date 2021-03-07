package raBi_maven.extent_report;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class location_page 
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
		
		driver.get("https://freecrm.com/");
		WebElement logo=driver.findElement(By.xpath("//h1[contains(text(),'Free CRM')]"));
		System.out.println("Height "+logo.getRect().height);
		System.out.println("Height "+logo.getRect().getDimension().getHeight());
		System.out.println("width "+logo.getRect().width);
		System.out.println("Width by dimension is "+logo.getRect().getDimension().getWidth());
		
		System.out.println("X cooridinate "+logo.getRect().x);
		System.out.println("X "+logo.getRect().getX());
		System.out.println("Y cooridinate "+logo.getRect().y);
		System.out.println("Y "+logo.getRect().getY());
		
		driver.quit();
	}
}
