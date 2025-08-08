package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Constants.ConstantsOrderScooter.ORDER_PLACED;

public class CheckingOrderWindow {
    private final WebDriver driver;
    private final By checkingOrderPlacedWindow = By.xpath(ORDER_PLACED);

    public CheckingOrderWindow(WebDriver driver){
        this.driver = driver;
    }

    public void checkingOrderPlacedWindow() {
        By order = checkingOrderPlacedWindow;
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(order));
        Assert.assertTrue(driver.findElement(order).isDisplayed());
    }
}
