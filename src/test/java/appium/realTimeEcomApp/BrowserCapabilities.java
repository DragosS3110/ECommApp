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

public class BrowserCapabilities {
	
	public AndroidDriver driver;

	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {
		
		
		AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		
		//service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("ThirdPhone");
		options.setChromedriverExecutable("//Users//dragossomlea//Downloads//chromedriver91");
		options.setCapability("browserName", "Chrome");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
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
