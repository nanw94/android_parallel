package guru99demo;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;

public class guru99script {

	// @Parameters({ "deviceName_", "UDID_", "platformVersion_", "URL_" })
	// @BeforeTest
	// public void landing(String deviceName_,String UDID_,String
	// platformVersion_,String URL_) throws MalformedURLException,
	// InterruptedException {
	//
	// System.setProperty("webdriver.chrome.driver",
	// "./browser_drivers/chromedriver.exe");
	//
	// DesiredCapabilities capabilities = DesiredCapabilities.android();
	//
	// capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,
	// BrowserType.CHROME);
	//
	// capabilities.setCapability(MobileCapabilityType.PLATFORM,
	// Platform.ANDROID);
	//
	// capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,
	// "Android");
	//
	// capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
	// deviceName_);
	//
	// capabilities.setCapability(MobileCapabilityType.UDID, UDID_);
	//
	// capabilities.setCapability(MobileCapabilityType.VERSION,
	// platformVersion_);
	//
	// capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,
	// "0");
	//
	// driver = new AndroidDriver<MobileElement>(new URL("http://"+URL_),
	// capabilities);
	// driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	//
	// }

	
		private static AndroidDriver<MobileElement> driver;

		
		@Parameters({ "deviceName_", "UDID_","platformVersion_", "URL_" })	
		@BeforeClass
		public void beforeclass(String deviceName_,String UDID_,String platformVersion_, String URL_) throws MalformedURLException, InterruptedException {
			
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
		
	}

	@Test
	public void login() throws Throwable {
		driver.get("http://live.guru99.com/index.php/customer/account/login/");
		driver.findElement(By.id("email")).sendKeys("nathanw@xbosoft.com");
		driver.findElement(By.id("pass")).sendKeys("password");
		driver.findElement(By.id("send2")).click();
		Thread.sleep(10000);
	}

	@AfterTest
	public void aftertest() {
		driver.quit();
	}

}
