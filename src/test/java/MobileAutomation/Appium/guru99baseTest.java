package MobileAutomation.Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class guru99baseTest {
	public AndroidDriver driver;
	@BeforeClass
	public void configureAppium() throws MalformedURLException {
		// android driver
				//Appium Code is sent to appium server then to mobile device
		
		// start the appium server
//		AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS( new File("C:\\Users\\Avenger\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//				.withIPAddress("127.0.0.1").usingPort(4723).build();
//		service.start();
		UiAutomator2Options option = new UiAutomator2Options();
		option.setDeviceName("Nexus 5 API 29");
		option.setChromedriverExecutable("D:\\Eclips workspace\\Appium\\chromedriver.exe");
		//option.setApp("C:\\Users\\Avenger\\OneDrive\\Desktop\\Imp Folder\\Appium Material\\resources\\ApiDemos-debug.apk");
		option.setApp("C:\\Users\\Avenger\\OneDrive\\Desktop\\Imp Folder\\Appium Material\\resources\\Guru99App.apk");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		
	}
	
	public void longPressActon(WebElement ele) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
						"duration", 2000));
	}
	
	public void swipeAction(WebElement firstImage, String dir) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId",((RemoteWebElement)firstImage).getId(),
			    "direction", dir,
			    "percent", 0.75
			));
	}
	
	public void dragNdropAction(WebElement source, int x, int y) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) source).getId(),
			    "endX", x,
			    "endY", y
			));
	}
	
	public void scrollToEndAction() {
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				    "left", 100, "top", 100, "width", 200, "height", 200,
				    "direction", "down",
				    "percent", 3.0
				));
		} while (canScrollMore);
	}
	
	
//	@AfterClass
//	public void teardown() throws InterruptedException {
//		Thread.sleep(2000);
//		driver.quit();
//	}

}
