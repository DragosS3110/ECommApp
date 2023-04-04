package appium.realTimeEcomApp;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;



public class AndroidBasics extends Utils{

	@Test(priority=1)
	public void AccessPreferences()
	{

		
		driver.findElement(AppiumBy.accessibilityId("Animation")).click();
		//System.out.println("Hola senor");

		
	}
	@Test(priority=2)
	public void AccessAnimations()
	{	
		driver.findElement(AppiumBy.accessibilityId("Events")).click();
				
		}
	@Test(priority=3)
	public void PlayAction() {
		driver.findElement(AppiumBy.accessibilityId("Play")).click();
	}
	
}
