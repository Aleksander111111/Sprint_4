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
    private final String headingId;
    private final String panelXpath;
    private final String expectedText;

    public ImportantQuestionsTest(String headingId, String panelXpath, String expectedText) {
        this.headingId = headingId;
        this.panelXpath = panelXpath;
        this.expectedText = expectedText;
    }
    @Parameterized.Parameters
    public static Object[][] getTest(){
        return new Object[][]{
                {HEADING_0, PANEL_XPATH_0, TEXT_0},
                {HEADING_1, PANEL_XPATH_1, TEXT_1},
                {HEADING_2, PANEL_XPATH_2, TEXT_2},
                {HEADING_3, PANEL_XPATH_3, TEXT_3},
                {HEADING_4, PANEL_XPATH_4, TEXT_4},
                {HEADING_5, PANEL_XPATH_5, TEXT_5},
                {HEADING_6, PANEL_XPATH_6, TEXT_6},
                {HEADING_7, PANEL_XPATH_7, TEXT_7},
        };
    }
    @Test
    public void testImportantQuestions() {
        WebDriver driver = factory.getDriver();
        ImportantQuestionsPage page = new ImportantQuestionsPage(driver);
        page.startUrl();
        page.acceptCookies();
        page.scrollToAndClickHeading(headingId);
        WebElement panel = page.waitForPanel(panelXpath);
        String actualText = panel.getText();
        Assert.assertEquals(expectedText, actualText);

    }

}


