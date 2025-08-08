package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static Constants.ConstantsOrderScooter.*;

public class ScooterOrderPage_1 {
    private final WebDriver driver;
    private final By name = By.cssSelector( FIRST_NAME_INPUT);
    private final By laName = By.cssSelector(LAST_NAME_INPUT);
    private final By Address = By.cssSelector( ADDRESS_INPUT);
    private final By selectionMetroStation = By.className(METRO_STATION_SELECTION);
    private final By selectionMetroStationClick = By.className(METRO_STATION_CLICK);
    private final By phone = By.cssSelector(PHONE_INPUT);
    private final By nextButton = By.xpath(NEXT_BUTTON);

    public ScooterOrderPage_1(WebDriver driver) {
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

    public void Address(String address) {
        WebElement addressInput = driver.findElement(Address);
        addressInput.sendKeys(address);
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
