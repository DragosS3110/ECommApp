package appium.realTimeEcomApp;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Utils {
	
	public AndroidDriver driver;

	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {
		
		
		AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		
		//service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("MainPhone");
		options.setApp("//Users//dragossomlea//eclipse-workspace//EcommApp//realTimeEcomApp//src//test//java//resources//General-Store.apk");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
	}
	//Gestures
	public void longPressAction (WebElement ele) {
		driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement)ele).getId(),
			    "duration", 2000));
	}
	public void scrollToEnd() {
		
		//Scroll in a direction (without knowing exactly when to stop) - not that reliable for multiple scrolling
		//and can crash app
		boolean canScrollMore;
		do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
		    "left", 100, "top", 100, "width", 200, "height", 200,
		    "direction", "down",
		    "percent", 3.0
		));
            }
	while(canScrollMore);
	}
	
	public void swipeOnElement (WebElement ele, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement)ele).getId(),
			    "direction", direction,
			    "percent", 0.75
			));
		}

	public void dragAndDrop (WebElement ele1, int x, int y) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele1).getId(),
			    "endX", x,
			    "endY", y,
			    "speed", 100
			));

	}
	public void toLandscape () {
		DeviceRotation landScape = new DeviceRotation(0, 0, 90);
		driver.rotate(landScape);
	}
	
	public void toPortrait() {
		DeviceRotation portrait = new DeviceRotation(0, 0, 0);
		driver.rotate(portrait);
	}
	public Double removeDollar(String text) {
    	Double price = Double.parseDouble((text).substring(1));
    	return price;

	}
	
	public void tearDown() {
		driver.quit();
	}
	@SuppressWarnings("deprecation")
	@BeforeClass
	public void defaultTimeOut() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
}
