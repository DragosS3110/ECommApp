package appium.realTimeEcomApp;

import org.openqa.selenium.By;
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

	public WebElement startBtn; 
	@Test(priority=1)
	public void toastError()
	{

		//Clicking directly on the Lets go button and triggering the toast error message
		startBtn = (WebElement) driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop"));

		driver.hideKeyboard();
		startBtn.click();
		
		WebElement toast = (WebElement) driver.findElement(By.xpath("//android.widget.Toast"));
		Assert.assertEquals(toast.getText(), "Please enter your name");
		
}
	@Test(priority=2)
	public void fillForm() {
		
		
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Dragos");
		startBtn = (WebElement) driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop"));
		
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();

		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		
		//Scrolling to a certain country
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))"));
        //scrollToText("Australia");
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Australia']")).click();

		
		startBtn.click();
	}

	
}
