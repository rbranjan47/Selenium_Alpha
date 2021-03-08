package raBi_maven.extent_report;

//import static org.testng.Assert.assertEquals;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
//import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.DevTools;
//import org.openqa.selenium.devtools.Event;
import org.openqa.selenium.devtools.v84.network.Network;
//import org.openqa.selenium.devtools.v84.network.model.ConnectionType;
//import org.openqa.selenium.devtools.v84.network.model.LoadingFailed;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDevToolsDemo
{
	public WebDriver driver;
	 
	@Test(priority = 1, description = "We are making netwrok offline")
	public void enablenetworkoffline()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		DevTools devTools = ((ChromiumDriver) driver).getDevTools();
		//creating sessions i.e. enabling network
		devTools.createSession();
		
		//activating the network 
		devTools.send(Network.enable(Optional.of(1000000),Optional.empty()	, Optional.empty()));
		//emulate/passing the network conditions
		//devTools.send(emulateNetworkConditions(true, 100, 1000, 2000, Optional.of(ConnectionType.WIFI)));
		
		//devTools.addListener(loadingFailed(), loadingFailed -> assertEquals(loadingFailed.getErrorText(), "net :: ERR_INTERNET_DISCONNECTED") );
		
		
		driver.get("https://demo.nopcommerce.com/");
	
	}
}
