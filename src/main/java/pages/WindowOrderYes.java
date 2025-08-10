package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class WindowOrderYes {
    private final WebDriver driver;
    private final By buttonYes = By.xpath("//button[text()='Да']");

    public WindowOrderYes(WebDriver driver){
        this.driver = driver;
    }

    public void buttonYes() {
        driver.findElement(buttonYes).click();
    }
}
