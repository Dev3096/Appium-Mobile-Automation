package MobileAutomation.Appium;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class eCommerceTc1_Hybrid extends baseTest{
	
	@Test
	public void fillFormHybrid() throws InterruptedException {
		
		Thread.sleep(3000);
		
		// enter name
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Dev");
		
		//hiding the keypad
		driver.hideKeyboard();
		
		//selecting gender
		driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
		
		//select US from the dropdown
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Algeria\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Algeria']")).click();
		
		// click on lets shop button
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		
		// selecting Air Jordan 4 Retro by scrolling
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Air Jordan 4 Retro\"));"));
		
		//click on add to cart
		List<WebElement> products1 = driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
		
		for (int i = 0; i < products1.size(); i++) {
			if (products1.get(i).getText().equalsIgnoreCase("Air Jordan 4 Retro")) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				break;
			}
		}
		
		// click on cart
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		//wait until the cart page is loaded Explicit wait
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.attributeContains(
//				driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		Thread.sleep(3000);
		
		
		//get the price of the items in the cart
		List<WebElement> prices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		float pricetotal = 0;
		for (int i = 0; i< prices.size(); i++) {
			//System.out.println(prices.get(i).getText());
			String str = prices.get(i).getText();
			float val = Float.parseFloat(str.substring(1));
			pricetotal += val;
			
		}
		
		System.out.println(pricetotal);
		
		//total price in the UI
		String total = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getAttribute("text");
		//System.out.println(total);
		float totalval = Float.parseFloat(total.substring(1));
		Assert.assertEquals(pricetotal, totalval);
		
		
		// long press 
		longPressActon(driver.findElement(By.id("com.androidsample.generalstore:id/termsButton")));
		
		//click on close
		driver.findElement(By.id("android:id/button1")).click();
		
		// click on checkbox
		Thread.sleep(2000);
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		
		// click on visit website 
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		Thread.sleep(3000);
		
		//get contexts to switch
		Set<String> contexts = driver.getContextHandles(); // 2 context are present (android and web)
		for (String context : contexts) {
			System.out.println(context);
		}
		driver.context("WEBVIEW_com.androidsample.generalstore"); 
		
		//hybrid app (leads to a web browser)
		// Google page
		// need to create a seperate driver. Present driver is for android 
		driver.findElement(By.name("q")).sendKeys("dev3096portfolio.com");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
		
	}
}
