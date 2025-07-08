package haidaraliappium;

import java.io.File;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class StartAppiumServer {
	
	public AppiumDriverLocalService service1;
	public AppiumDriverLocalService service2;
	
	@BeforeSuite(alwaysRun = true)
	public void startServer() {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		service1 = new AppiumServiceBuilder()
				.withAppiumJS(new File("C:\\Users\\Asus\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("192.168.0.113").usingPort(4723).build();
		service2 = new AppiumServiceBuilder()
				.withAppiumJS(new File("C:\\Users\\Asus\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4725).build();
		service1.start();
		service2.start();
	}
	
	@AfterSuite(alwaysRun = true)
	public void stopServer() {
		service1.stop();
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		service2.stop();
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
}
