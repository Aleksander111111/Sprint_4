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
                {BUTTON_ORDER_ONE, FIRST_NAME_ONE, LAST_NAME_ONE, ADDRESS_ONE, METRO_STATION_ONE, PHONE_ONE, DATE_PICKER_DAY_ONE,
                        DURATION_DROPDOWN_OPTION_ONE, COLOR_SELECTOR_ONE, COMMENT_ONE},
                {BUTTON_ORDER_TWO, FIRST_NAME_TWO, LAST_NAME_TWO, ADDRESS_TWO, METRO_STATION_TWO, PHONE_TWO, DATE_PICKER_DAY_TWO,
                        DURATION_DROPDOWN_OPTION_TWO, COLOR_SELECTOR_TWO, COMMENT_TWO}
        };
    }

    @Test
    public void testOrder() throws InterruptedException {
        WebDriver driver = factory.getDriver();
        ScooterOrderHomePage page = new ScooterOrderHomePage(driver);
        ScooterOrderPageOne page1 = new ScooterOrderPageOne(driver);
        ScooterOrderPageTwo page2 = new ScooterOrderPageTwo(driver);
        WindowOrderYes orderYes = new WindowOrderYes(driver);
        CheckingOrderWindow checkingWindow = new CheckingOrderWindow(driver);
        page.url();
        page.cookies();
        boolean buttonStart = button.equals(BUTTON_ORDER_TWO);
        if (buttonStart){
            page.buttonTwo(button);
        }else {
            page.buttonOne(button);
        }
        page1.name(firstName);
        page1.laName(lastName);
        page1.address(address);
        page1.selectionMetroStation(metroStation);
        page1.selectionMetroStationClick();
        page1.phone(phoneNumber);
        page1.nextButton();
        page2.whenDeliverOrder(deliveryDate);
        page2.rentalPeriod(rentalPeriod);
        page2.colorScooter(color);
        page2.commentCourier(comment);
        page2.orderScooterButton();
        orderYes.buttonYes();
        checkingWindow.checkingOrderPlacedWindow();

    }

}







