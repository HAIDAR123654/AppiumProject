package haidaraliappium;

import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class AddProductIntoCart extends BaseTest{

	@Test(description = "Verify add to cart and place order", groups = {"regression"})
	public void addProductTest() throws InterruptedException {
		
		HashMap<String, Object> args = new HashMap<>();
        args.put("strategy", "-android uiautomator");
        args.put("selector", "new UiSelector().text(\"Test.allTheThings() T-Shirt\")");
        getDriver().executeScript("mobile: scroll", args);
		
		getDriver().findElement(By.xpath("//android.widget.TextView[@content-desc='store item text' and @text='Test.allTheThings() T-Shirt']")).click();
		
		Thread.sleep(3000);
		getDriver().findElement(By.xpath("//android.widget.TextView[@text=\"Add To Cart\"]")).click();
		
		getDriver().findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.ImageView")).click();
		
		Thread.sleep(3000);
		getDriver().findElement(By.xpath("//android.widget.TextView[@text=\"Proceed To Checkout\"]")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText[@content-desc=\"Username input field\"]")));
        getDriver().findElement(By.xpath("//android.widget.EditText[@content-desc=\"Username input field\"]")).sendKeys("bob@example.com");
        getDriver().findElement(AppiumBy.accessibilityId("Password input field")).sendKeys("10203040");
        getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"Login button\")")).click();
        
        Thread.sleep(3000);
        
		getDriver().findElement(AppiumBy.accessibilityId("Full Name* input field")).sendKeys("Haidar");

		getDriver().findElement(AppiumBy.accessibilityId("Address Line 1* input field")).sendKeys("address line 1");
		
		getDriver().findElement(AppiumBy.accessibilityId("Address Line 2 input field")).sendKeys("address line 2");
		
		getDriver().findElement(AppiumBy.accessibilityId("City* input field")).sendKeys("Lucknow");
		
		getDriver().findElement(AppiumBy.accessibilityId("State/Region input field")).sendKeys("UP");
		
		getDriver().findElement(AppiumBy.accessibilityId("Zip Code* input field")).sendKeys("226012");
		
		getDriver().findElement(AppiumBy.accessibilityId("Country* input field")).sendKeys("India");
	
		getDriver().findElement(By.xpath("//android.widget.TextView[@text=\"To Payment\"]")).click();
		
		Thread.sleep(3000);
		
        getDriver().findElement(AppiumBy.accessibilityId("Full Name* input field")).sendKeys("Haidar Ali");
		
		getDriver().findElement(AppiumBy.accessibilityId("Card Number* input field")).sendKeys("3258 1234 5678 345");
		
		getDriver().findElement(AppiumBy.accessibilityId("Expiration Date* input field")).sendKeys("0329");
		
		getDriver().findElement(AppiumBy.accessibilityId("Security Code* input field")).sendKeys("123");
		
		getDriver().findElement(By.xpath("//android.widget.TextView[@text='Review Order']")).click();
		
		Thread.sleep(3000);
		
		getDriver().findElement(AppiumBy.accessibilityId("Place Order button")).click();
		Thread.sleep(3000);
		
		String s = getDriver().findElement(By.xpath("//android.widget.TextView[@text='Thank you for your order']")).getText();
		System.out.println(s);
	}
	
}
