import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.practicum.pages.questions.scooter.ImportantQuestionsPage;
import static ru.practicum.constants.questions.scooter.ConstantsImportantQuestions.*;

@RunWith(Parameterized.class)
public class ImportantQuestionsTest {
    @Rule
    public DriverFactory factory = new DriverFactory();

    private final int questionIndex;
    private final String expectedText;

    public ImportantQuestionsTest(int questionIndex, String expectedText) {
        this.questionIndex = questionIndex;
        this.expectedText = expectedText;
    }
    @Parameterized.Parameters public static Object[][] getTest() {
        return new Object[][]{
                {0, DELIVERY_COST_INFO},
                {1, SINGLE_ORDER_LIMITATION},
                {2, RENT_DURATION_EXPLANATION},
                {3, FUTURE_AVAILABILITY_NOTICE},
                {4, SUPPORT_CONTACT_INFO},
                {5, BATTERY_CHARGE_DURATION},
                {6, NO_PENALTY_BEFORE_DELIVERY},
                {7, MANDATORY_HELMET_WEARING}
        };
    }

    @Test
    public void testImportantQuestions() {
        WebDriver driver = factory.getDriver();
        ImportantQuestionsPage page = new ImportantQuestionsPage(driver);
        page.startUrl();
        page.acceptCookies();
        page.scrollToAndClickHeading(questionIndex);
        WebElement panel = page.waitForPanel(questionIndex);
        String actualText = panel.getText();
        Assert.assertEquals(expectedText, actualText);
    }

}
