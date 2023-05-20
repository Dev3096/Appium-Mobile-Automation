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



public class openActivity extends baseTest{
	
	@Test 
	public void openAct() throws MalformedURLException, InterruptedException {
		
		// directly open a particular activity
		Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
		driver.startActivity(activity);
		
		// check id
		driver.findElement(By.id("android:id/checkbox")).click();
		
		
		// click on wifi
		driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		String wifi = "WiFi settings";
		String getWifi = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(wifi, getWifi);
		
		
		// enter wifi name using clipboard
		driver.setClipboardText("Dev");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		
		// click on ok
		driver.findElement(By.id("android:id/button1")).click();



	}

}
