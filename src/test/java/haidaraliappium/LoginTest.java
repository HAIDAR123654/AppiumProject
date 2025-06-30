package haidaraliappium;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class LoginTest extends BaseTest{
	//com.saucelabs.mydemoapp.rn
	@Test(description = "this is login test",groups = {"sanity"})
	public void loginTestCase() {
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().description(\"open menu\")")));
        getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"open menu\")")).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("menu item log in")));
        getDriver().findElement(AppiumBy.accessibilityId("menu item log in")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText[@content-desc=\"Username input field\"]")));
        getDriver().findElement(By.xpath("//android.widget.EditText[@content-desc=\"Username input field\"]")).sendKeys("bob@example.com");
        getDriver().findElement(AppiumBy.accessibilityId("Password input field")).sendKeys("10203040");
        getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"Login button\")")).click();
	}
}
