package haidaraliappium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumNewBasics {

	public AppiumDriverLocalService service;
	@Test
	public void loginTest() throws MalformedURLException{

		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("C:\\Users\\Asus\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("192.168.0.113").usingPort(4723).build();
		service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Practice-Emulator");
		options.setApp("D:\\EclipseSoftware\\appiumnew\\src\\test\\java\\resources\\Android-MyDemoAppRN.1.3.0.build-244.apk");
		
		AndroidDriver driver = new AndroidDriver(new URL("http://192.168.0.113:4723/"), options);
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"open menu\")")).click();
		driver.findElement(AppiumBy.accessibilityId("menu item log in")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Username input field\"]")).sendKeys("bob@example.com");
		driver.findElement(AppiumBy.accessibilityId("Password input field")).sendKeys("10203040");
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"Login button\")")).click();
		
		driver.quit();
		service.stop();
		
	}
	
	@Test
	public void geoLocationTest() throws MalformedURLException, InterruptedException {
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("C:\\Users\\Asus\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("192.168.0.113").usingPort(4723).build();
		service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel-9-API-35_ANDDROID-15");
		options.setApp("D:\\EclipseSoftware\\appiumnew\\src\\test\\java\\resources\\Android-MyDemoAppRN.1.3.0.build-244.apk");
		AndroidDriver driver = new AndroidDriver(new URL("http://192.168.0.113:4723/"), options);
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"open menu\")")).click();
		driver.findElement(AppiumBy.accessibilityId("menu item geo location")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
		Thread.sleep(3000);
		String latitude = driver.findElement(AppiumBy.accessibilityId("latitude data")).getText();
		System.out.println("Latitude is : " + latitude);
		
		String longitude = driver.findElement(AppiumBy.accessibilityId("longitude data")).getText();
		System.out.println("Longitude is : " + longitude);
		
		driver.quit();
		service.stop();
	}
	
}
