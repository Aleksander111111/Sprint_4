package ru.practicum.pages.questions.scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class ScooterRenterInfoPage {
    private final WebDriver driver;
    private final By name = By.cssSelector("input[placeholder='* Имя']");
    private final By laName = By.cssSelector("input[placeholder='* Фамилия']");
    private final By address = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");
    private final By selectionMetroStation = By.className("select-search__input");
    private final By selectionMetroStationClick = By.className("select-search__select");
    private final By phone = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButton = By.xpath("//button[text()='Далее']");

    public ScooterRenterInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void name(String firstName) {
        WebElement nameInput = driver.findElement(name);
        nameInput.sendKeys(firstName);
    }

    public void laName(String lastName) {
        WebElement lastNameInput = driver.findElement(laName);
        lastNameInput.sendKeys(lastName);
    }

    public void address(String shippingAddress) {
        WebElement addressInput = driver.findElement(address);
        addressInput.sendKeys(shippingAddress);
    }

    public void selectionMetroStation(String metroStation) {
        driver.findElement(selectionMetroStation).sendKeys(metroStation);
    }

    public void selectionMetroStationClick() {
        driver.findElement(selectionMetroStationClick).click();
    }

    public void phone(String phoneNumber) {
        WebElement phoneInput = driver.findElement(phone);
        phoneInput.click();
        phoneInput.sendKeys(phoneNumber);
    }

    public void nextButton() {
        driver.findElement(nextButton).click();
    }
}
