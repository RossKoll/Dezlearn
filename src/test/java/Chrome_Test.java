import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Chrome_Test {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-maximized");

        options.setHeadless(false);


        WebDriver driver = new ChromeDriver(options);
        //driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500L));
        printTitleAndUrl(driver);

        driver.navigate().to("https://facebook.com");
        printTitleAndUrl(driver);

        driver.navigate().back();
        printTitleAndUrl(driver);


        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Hello");
        element.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul")));
        printTitleAndUrl(driver);
        driver.quit();




    }

    private static void printTitleAndUrl(WebDriver driver) {
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
    }
}
