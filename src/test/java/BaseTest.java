import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;
    Logger log = Logger.getLogger(getClass());

    @BeforeEach
    public void setUp(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            log.info("Browser is opened");
//            loginPage = new LoginPage(driver);
//            homePage = new HomePage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        log.info("Browser is closed");
    }

}
