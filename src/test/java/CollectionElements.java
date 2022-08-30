import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CollectionElements extends BaseTest{

    @Test
    public void findElements(){
        driver.get("https://www.actitime.com/");
        int count = 0;
        List<WebElement> links = driver.findElements(By.cssSelector("li.header__li"));
        for (WebElement link : links){
            String text = link.getText();
            if (!text.trim().isEmpty()){
                System.out.println(link.getText());
                System.out.println(link.getAttribute("href"));
                System.out.println("-------------------");
                count+=1;
            }
        }
        System.out.println( count + " elements were found");
    }
}
