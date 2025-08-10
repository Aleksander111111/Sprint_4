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
    private final By acceptCookies = By.id("rcc-confirm-button");

    public ImportantQuestionsPage(WebDriver driver) {
        this.driver = driver;
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

    public String getHeadingId(int questionIndex) {
        return "accordion__heading-" + questionIndex;
    }

    public String getPanelXpath(int questionIndex) {
        return "//*[@id='accordion__panel-" + questionIndex + "']/p";
    }

    public void scrollToAndClickHeading(int questionIndex) {
        String headingId = getHeadingId(questionIndex);
        WebElement heading = driver.findElement(By.id(headingId));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", heading);
        heading.click();
    }

    public WebElement waitForPanel(int questionIndex) {
        String panelXpath = getPanelXpath(questionIndex);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(panelXpath)));
    }
    }


