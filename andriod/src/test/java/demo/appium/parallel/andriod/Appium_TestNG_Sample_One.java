package demo.appium.parallel.andriod;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.Parameters;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Appium_TestNG_Sample_One {
	private static AndroidDriver<MobileElement> driver;

	
	@Parameters({ "deviceName_", "UDID_", "platformVersion_", "URL_" })	
	@Test
	public void landing(String deviceName_,String UDID_,String platformVersion_,String URL_) throws MalformedURLException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./browser_drivers/chromedriver.exe");
		
		DesiredCapabilities capabilities = DesiredCapabilities.android();
		
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);

		capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);

		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName_);
		
		capabilities.setCapability(MobileCapabilityType.UDID, UDID_);

		capabilities.setCapability(MobileCapabilityType.VERSION, platformVersion_);

		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "0");
		
		driver = new AndroidDriver<MobileElement>(new URL("http://"+URL_), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		
		driver.get("https://68.66.0.106");
		
		Thread.sleep(10000);
		
		driver.quit();
	}

}