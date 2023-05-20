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



public class scroll extends baseTest{
	
	@Test 
	public void doscroll() throws MalformedURLException, InterruptedException {
		
		// click on views
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//scroll down until WebView is visible - 2 types
		
		// 1. google engine script (where to scroll is know)
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		
		//2. using javascript (where to scroll is unknown)
		scrollToEndAction();
		
		
		
		

	}

}
