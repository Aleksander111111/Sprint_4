package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Constants.ConstantsUrlCookies.*;

public class ImportantQuestionsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By acceptCookies = By.id(COOKIES);

    public ImportantQuestionsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void startUrl() {
        driver.get(BASE_URL);
    }

    public void acceptCookies() {
        WebElement cookieButton = driver.findElement(acceptCookies);
        if (cookieButton.isDisplayed()) {
            cookieButton.click();
        }
    }

    public void scrollToAndClickHeading(String headingId) {
        WebElement heading = driver.findElement(By.id(headingId));
        ((JavascriptExecutor) driver).executeScript(SCROLL, heading);
        heading.click();
    }

    public WebElement waitForPanel(String panelXpath) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(panelXpath)));
    }
}