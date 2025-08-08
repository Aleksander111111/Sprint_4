import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pages.*;

import static Constants.ConstantsOrderScooter.*;

@RunWith(Parameterized.class)
public class TestScooterOrder {
    @Rule
    public DriverFactory factory = new DriverFactory();
    private final String button;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String metroStation;
    private final String phoneNumber;
    private final String deliveryDate;
    private final String rentalPeriod;
    private final String color;
    private final String comment;

    public TestScooterOrder(String button, String firstName, String lastName, String address, String metroStation,
                            String phoneNumber, String deliveryDate, String rentalPeriod, String color, String comment) {
        this.button = button;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.deliveryDate = deliveryDate;
        this.rentalPeriod = rentalPeriod;
        this.color = color;
        this.comment = comment;

    }

    @Parameterized.Parameters
    public static Object[][] testScooter(){
        return new Object[][]{
                {BUTTON_ORDER_1, FIRST_NAME_1, LAST_NAME_1, ADDRESS_1, METRO_STATION_1, PHONE_1, DATE_PICKER_DAY_1,
                        DURATION_DROPDOWN_OPTION_1, COLOR_SELECTOR_1, COMMENT_1},
                {BUTTON_ORDER_2, FIRST_NAME_2, LAST_NAME_2, ADDRESS_2, METRO_STATION_2, PHONE_2, DATE_PICKER_DAY_2,
                        DURATION_DROPDOWN_OPTION_2, COLOR_SELECTOR_2, COMMENT_2}
        };
    }

    @Test
    public void TestOrder() throws InterruptedException {
        WebDriver driver = factory.getDriver();
        ScooterOrderHomePage page = new ScooterOrderHomePage(driver);
        ScooterOrderPage_1 page_1 = new ScooterOrderPage_1(driver);
        ScooterOrderPage_2 page_2 = new ScooterOrderPage_2(driver);
        WindowOrderYes orderYes = new WindowOrderYes(driver);
        CheckingOrderWindow checkingWindow = new CheckingOrderWindow(driver);
        page.URL();
        page.cookies();
        boolean buttonStart = button.equals(BUTTON_ORDER_2);
        if (buttonStart){
            page.button_2(button);
        }else {
            page.button_1(button);
        }
        page_1.name(firstName);
        page_1.laName(lastName);
        page_1.Address(address);
        page_1.selectionMetroStation(metroStation);
        page_1.selectionMetroStationClick();
        page_1.phone(phoneNumber);
        page_1.nextButton();
        page_2.whenDeliverOrder(deliveryDate);
        page_2.RentalPeriod(rentalPeriod);
        page_2.colorScooter(color);
        page_2.commentCourier(comment);
        page_2.orderScooterButton();
        orderYes.buttonYes();
        checkingWindow.checkingOrderPlacedWindow();

    }

}







