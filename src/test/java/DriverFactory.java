import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory extends ExternalResource {
    public WebDriver getDriver(){
        return driver;
    }
    private WebDriver driver;
    public void initDriver(){
        if ("firefox".equals(System.getProperty("browser"))){
            startFirefox();
        }else {
            startChrome();
        }
    }

    private void startChrome() {
        driver = new ChromeDriver();
    }

    private void startFirefox() {
        driver = new FirefoxDriver();
    }
    @Override
    protected void before(){
        initDriver();
    }
    @Override
    protected void after(){
        driver.quit();
    }

}
