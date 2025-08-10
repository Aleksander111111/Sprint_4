package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class ScooterOrderPageTwo {
    private final WebDriver driver;
    private final By whenDeliverOrder = By.cssSelector("input[placeholder='* Когда привезти самокат']");
    private final By rentalPeriod = By.cssSelector("div.Dropdown-control[aria-haspopup='listbox']");
    private final By commentCourier = By.cssSelector("input[placeholder='Комментарий для курьера']");
    private final By orderScooterButton = By.xpath("//div[contains(@class, 'Order_Buttons__1xGrp')]//button[text()='Заказать']");

    public ScooterOrderPageTwo(WebDriver driver) {
        this.driver = driver;
    }

    public void whenDeliverOrder(String deliveryDate) {
        driver.findElement(whenDeliverOrder).click();
        driver.findElement(By.cssSelector(deliveryDate)).click();
    }

    public void rentalPeriod(String period) {
        driver.findElement(rentalPeriod).click();
        WebElement twoDaysOption =  driver.findElement(By.xpath(period));
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
