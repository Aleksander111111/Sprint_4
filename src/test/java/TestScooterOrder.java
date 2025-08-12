import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.practicum.pages.questions.scooter.*;
import static ru.practicum.constants.questions.scooter.ConstantsOrderScooter.*;

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
                {ORDER_BUTTON_FIRST, FIRST_NAME_FIRST, LAST_NAME_FIRST, ADDRESS_FIRST, METRO_STATION_FIRST, PHONE_FIRST, DATE_PICKER_DAY_FIRST,
                        DURATION_DROPDOWN_OPTION_SUTKI, COLOR_SELECTOR_BLACK, COMMENT_FIRST},
                {ORDER_BUTTON_SECOND, FIRST_NAME_SECOND, LAST_NAME_SECOND, ADDRESS_SECOND, METRO_STATION_SECOND, PHONE_SECOND, DATE_PICKER_DAY_SECOND,
                        DURATION_DROPDOWN_OPTION_DVOE_SUTOKI, COLOR_SELECTOR_GREY, COMMENT_SECOND}
        };
    }

    @Test
    public void testOrder() throws InterruptedException {
        WebDriver driver = factory.getDriver();
        ScooterOrderHomePage page = new ScooterOrderHomePage(driver);
        ScooterRenterInfoPage page1 = new ScooterRenterInfoPage(driver);
        ScooterInfoPage page2 = new ScooterInfoPage(driver);
        WindowOrderYes orderYes = new WindowOrderYes(driver);
        CheckingOrderWindow checkingWindow = new CheckingOrderWindow(driver);
        page.url();
        page.cookies();
        boolean buttonStart = button.equals(ORDER_BUTTON_SECOND);
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







