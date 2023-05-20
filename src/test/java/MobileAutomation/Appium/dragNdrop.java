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



public class dragNdrop extends baseTest{
	
	@Test 
	public void dragNdrop() throws MalformedURLException, InterruptedException {
		
		// click on views
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//click on dragNdrop
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		
		// create source webelement
		WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		
		//dragNdrop
		dragNdropAction(source, 830, 755);
		
		// check if dropped
		Assert.assertEquals(driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText(), "Dropped!");

	}

}
