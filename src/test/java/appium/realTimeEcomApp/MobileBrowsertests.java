package appium.realTimeEcomApp;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MobileBrowsertests extends BrowserCapabilities{

	@Test
	public void browserTests() {
		driver.get("https://qrcg-dev-web-app.azurewebsites.net/");
		driver.findElement(By.xpath("//*[contains(text(),'EMAIL')]")).click();

		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,1000)");
		
		
		driver.findElement(By.id("email")).sendKeys("dragos.somlea@wolfpack-digital.com");
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
						
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Check if the QR code has been displayed after tapping on Generate
		
		Assert.assertTrue(driver.findElement(By.id("qrcode")).isDisplayed());



	}
}
