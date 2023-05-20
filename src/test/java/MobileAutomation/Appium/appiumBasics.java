package MobileAutomation.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;



public class appiumBasics extends baseTest{
	
	@Test 
	public void wifiSettingsName() throws MalformedURLException {
		//get the locator (xpath, accessibilityId, className, androidUIAutomator
		//click on Preferences in the app
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		
		//tagName[@attribute='value'] - syntax for xpath or //tagName
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
		
		// check id
		driver.findElement(By.id("android:id/checkbox")).click();
		
		// click on wifi
		driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		String wifi = "WiFi settings";
		String getWifi = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(wifi, getWifi);
		
		// enter wifi name
		driver.findElement(By.id("android:id/edit")).sendKeys("Dev");
		
		// click on ok
		driver.findElement(By.id("android:id/button1")).click();


	}

}
