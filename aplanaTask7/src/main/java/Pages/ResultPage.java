package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultPage extends BasePage {

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public void selectProduct(String s) {
        driver.findElement(By.xpath("//a[contains(text(), '" + s + "')]")).click();
    }
}
