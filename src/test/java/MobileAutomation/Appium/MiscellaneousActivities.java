package MobileAutomation.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;



public class MiscellaneousActivities extends baseTest{
	
	@Test 
	public void doSwipe() throws MalformedURLException, InterruptedException {

		//1. Landscape mode
		//2. Copy from clipboard
		//3. Android keys (ENTER, HOME, BACK)
		//get the locator (xpath, accessibilityId, className, androidUIAutomator
		
		
				//click on Preferences in the app
				driver.findElement(AppiumBy.accessibilityId("Preference")).click();
				
				//tagName[@attribute='value'] - syntax for xpath or //tagName
				driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
				
				// check id
				driver.findElement(By.id("android:id/checkbox")).click();
				
				//landscape mode
				DeviceRotation lasdscape = new DeviceRotation(0,0,90);
				driver.rotate(lasdscape);
				
				// click on wifi
				driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
				
				String wifi = "WiFi settings";
				String getWifi = driver.findElement(By.id("android:id/alertTitle")).getText();
				Assert.assertEquals(wifi, getWifi);
				
				
				// enter wifi name using clipboard
				driver.setClipboardText("Dev");
				driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
				//press ENTER key
				driver.pressKey(new KeyEvent(AndroidKey.ENTER));
				
				// click on ok
				driver.findElement(By.id("android:id/button1")).click();
				
				//press back button
				driver.pressKey(new KeyEvent(AndroidKey.BACK));
				// press home key
				driver.pressKey(new KeyEvent(AndroidKey.HOME));

		

	}

}
