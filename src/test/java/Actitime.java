import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Actitime {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.amazon.com/");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.urlToBe("https://www.actitime.com/free-online-trial"));

        driver.findElement(By.name("field-keywords")).sendKeys("Barbie Dolls");
        wait.withTimeout(Duration.ofSeconds(5));
        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();
        driver.findElement(By.partialLinkText("Baby Doctor")).click();
        System.out.println(driver.findElement(By.id("productTitle")).getText());

        //driver.quit();



    }
}
