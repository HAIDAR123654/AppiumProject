package haidaraliappium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test(description = "this is log out test", groups = {"sanity", "smoke"})
    public void logoutTestCase() {
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().description(\"open menu\")")));
        getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"open menu\")")).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("menu item log out")));
        getDriver().findElement(AppiumBy.accessibilityId("menu item log out")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/button1")));
        getDriver().findElement(By.id("android:id/button1")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/button1")));
        getDriver().findElement(By.id("android:id/button1")).click();
    }
}

