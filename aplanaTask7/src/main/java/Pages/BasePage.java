package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;
    Wait<WebDriver> wait;

    BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 5, 1000);
    }

    void fillField(WebElement webElement, String value) {
        webElement.clear();
        webElement.sendKeys(value);
    }

    double parsePrice(WebElement price) {
        return Double.parseDouble(price.getText()
                .replaceAll(" ", "")
                .trim());
    }
}
