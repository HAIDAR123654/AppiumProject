package haidaraliappium;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class BaseTest {

    protected ThreadLocal<AndroidDriver> driver = new ThreadLocal<>();
  
    protected WebDriverWait wait;
    
    @Parameters({"udid","appiumPort", "deviceName", "systemPort"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(String udid,String appiumPort, String deviceName, String systemPort) throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(deviceName);
        options.setUdid(udid);
//      options.setSystemPort(Integer.parseInt(systemPort));
        options.setUiautomator2ServerLaunchTimeout(Duration.ofSeconds(30));
        options.setUiautomator2ServerReadTimeout(Duration.ofSeconds(30));
        options.setUiautomator2ServerInstallTimeout(Duration.ofSeconds(30));
        options.setApp("D:\\EclipseSoftware\\appiumnew\\src\\test\\java\\resources\\Android-MyDemoAppRN.1.3.0.build-244.apk");
        URL url = new URL("http://192.168.0.113:" + appiumPort);
        driver.set(new AndroidDriver(url, options));
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        System.out.println("this is appium" + appiumPort);
    }

    public AndroidDriver getDriver() {
        return driver.get();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if(getDriver()!= null){
            getDriver().quit();
            driver.remove();
        }
    }
}

