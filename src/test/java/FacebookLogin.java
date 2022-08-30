import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FacebookLogin {

    @Test
    @DisplayName("Facebook login page URL")
    public void LoginPage(){

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        String URL = "https://www.facebook.com/";


        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get(URL);
        wait.until(ExpectedConditions.urlToBe(URL));

        WebElement CreateNewAccountButton = driver.findElement(By.xpath("//input[@id='email']"));
        CreateNewAccountButton.sendKeys("Ross");
        driver.findElement(By.xpath("//input[@aria-label='Password']")).sendKeys("ross@gmail.com");
        Assertions.assertEquals(URL, driver.getCurrentUrl());

        driver.findElement(By.xpath("//button[@name='login']")).click();
        WebElement errorLabel = driver.findElement(By.xpath("//img[@class='_9ay6 img']"));

        Assertions.assertNotNull(errorLabel, "Error label not found");

        driver.quit();
    }
}
