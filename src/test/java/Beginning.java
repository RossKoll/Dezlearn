import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static java.lang.Thread.sleep;

public class Beginning {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("incognito");
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver();

        //driver.get("https://www.amazon.com/");
        driver.get("https://www.google.com/");
        WebElement search = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
                search.sendKeys("hello");
                search.submit();
        WebElement playButton = driver.findElement(By.xpath("//div[@class='twQ0Be']//a"));
                playButton.click();
                driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();

                sleep(10000);
                driver.close();
    }
}
