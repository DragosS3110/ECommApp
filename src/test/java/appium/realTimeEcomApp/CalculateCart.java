package appium.realTimeEcomApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;



public class CalculateCart extends Utils{

	public WebElement startBtn; 

	@Test(priority=1)
	public void addProductToCart() {
		
		//go to the second page using activity	
		//Activity activity = new Activity("a95dabc u0 com.androidsample.generalstore", "com.androidsample.generalstore.AllProductsActivity");
		//driver.startActivity(activity);
		
		//Form page fill
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Dragos");
		startBtn = (WebElement) driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop"));
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Australia']")).click();
		startBtn.click();
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Converse All Star\"))"));

		int listNumber = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		int i;
		for (i=0;i<listNumber;i++) {
			driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

	
	    List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
	    int productPriceValues = productPrices.size();
	    
    	double sum = 0;
	    for (i=0;i<productPriceValues;i++) {
	    	String text = productPrices.get(i).getText();
	    	double price = removeDollar(text);

	    	sum = sum + price;
	    }
	    String finalSum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
	    double finalPrice = removeDollar(finalSum);
	    Assert.assertEquals(sum, finalPrice);


	
}
}
