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

public class browserBaseTest {
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
		option.setChromedriverExecutable("D:\\Eclips workspace\\chromedriver.exe");
		option.setCapability("browserName", "Chrome");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		
	}
	

	
	@AfterClass
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
