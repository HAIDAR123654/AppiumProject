package haidaraliappium;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
public class GetGeoLocationTest extends BaseTest{

	@Test(description = "this is get geo location test", groups = {"smoke", "regression"})
	public void getGeoLocationTest() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().description(\"open menu\")")));
        getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"open menu\")")).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("menu item geo location")));
        getDriver().findElement(AppiumBy.accessibilityId("menu item geo location")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")));
        getDriver().findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
        Thread.sleep(5000);
        String latitude = getDriver().findElement(AppiumBy.accessibilityId("latitude data")).getText();
        System.out.println("Latitude is : " + latitude);
        String longitude = getDriver().findElement(AppiumBy.accessibilityId("longitude data")).getText();
        System.out.println("Longitude is : " + longitude);
	}
}
