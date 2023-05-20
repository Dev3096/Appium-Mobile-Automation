package MobileAutomation.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;



public class longPress extends baseTest{
	
	@Test 
	public void doLongPress() throws MalformedURLException, InterruptedException {
		
		// click on views
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		// click on expamdable list
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		
		// click on custom adapter
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
		// long click on "People Names"
		WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		longPressActon(ele);
		//Thread.sleep(2000);
		
		// check if Sample menu is displayed after long press
		String id = driver.findElement(By.id("android:id/title")).getText();
		String myid = "Sample menu";
		
		//2 methods to assert 
		Assert.assertEquals(id, myid);
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
		

	}

}
