package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static Constants.ConstantsUrlCookies.*;

public class ScooterOrderHomePage {
    private final WebDriver driver;
    private final By cookies = By.id(COOKIES);
    public ScooterOrderHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void URL() {
        driver.get(BASE_URL);
    }

    public void cookies() {
        driver.findElement(cookies).click();
    }

    public void button_2(String button) throws InterruptedException {
        WebElement element = driver.findElement(By.cssSelector(button));
        ((JavascriptExecutor) driver).executeScript(SCROLL, element);
        driver.findElement(By.cssSelector(button)).click();
    }

    public void button_1(String button) {
        driver.findElement(By.xpath(button)).click();
    }
}