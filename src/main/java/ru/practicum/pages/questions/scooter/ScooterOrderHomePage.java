package ru.practicum.pages.questions.scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static ru.practicum.constants.questions.scooter.ConstantsUrlCookies.BASE_URL;

public class ScooterOrderHomePage {
    private final WebDriver driver;
    private final By cookies = By.id("rcc-confirm-button");
    public ScooterOrderHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void url() {
        driver.get(BASE_URL);
    }

    public void cookies() {
        driver.findElement(cookies).click();
    }

    public void buttonTwo(String button) throws InterruptedException {
        WebElement element = driver.findElement(By.cssSelector(button));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.cssSelector(button)).click();
    }

    public void buttonOne(String button) {
        driver.findElement(By.xpath(button)).click();
    }
}