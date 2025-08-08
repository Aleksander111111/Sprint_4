package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static Constants.ConstantsOrderScooter.*;

public class ScooterOrderPage_2 {
    private final WebDriver driver;
    private final By whenDeliverOrder = By.cssSelector(WHEN_DELIVER_ORDER);
    private final By RentalPeriod = By.cssSelector(RENTAL_PERIOD);
    private final By commentCourier = By.cssSelector(COMMENT_COURIER);
    private final By orderScooterButton = By.xpath(ORDER_SCOOTER_BUTTON);

    public ScooterOrderPage_2(WebDriver driver) {
        this.driver = driver;
    }

    public void whenDeliverOrder(String deliveryDate) {
        driver.findElement(whenDeliverOrder).click();
        driver.findElement(By.cssSelector(deliveryDate)).click();
    }

    public void RentalPeriod(String rentalPeriod) {
        driver.findElement(RentalPeriod).click();
        WebElement twoDaysOption =  driver.findElement(By.xpath(rentalPeriod));
        twoDaysOption.click();
    }

    public void colorScooter(String color) {
        driver.findElement(By.cssSelector(color)).click();
    }

    public void commentCourier(String comment) {
        driver.findElement(commentCourier).sendKeys(comment);
    }

    public  void orderScooterButton() {
        driver.findElement(orderScooterButton).click();
    }
}
