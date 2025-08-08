package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Constants.ConstantsOrderScooter.BUTTON_YES;

public class WindowOrderYes {
    private final WebDriver driver;
    private final By buttonYes = By.xpath(BUTTON_YES);

    public WindowOrderYes(WebDriver driver){
        this.driver = driver;
    }

    public void buttonYes() {
        driver.findElement(buttonYes).click();
    }
}
