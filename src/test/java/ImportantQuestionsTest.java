import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.ImportantQuestionsPage;
import static Constants.ConstantsImportantQuestions.*;

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
                {0, ANSWER_ZERO},
                {1, ANSWER_ONE},
                {2, ANSWER_TWO},
                {3, ANSWER_THREE},
                {4, ANSWER_FOUR},
                {5, ANSWER_FIVE},
                {6, ANSWER_SIX},
                {7, ANSWER_SEVEN}
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
