package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    private WebDriver driver;

    BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    void fillField(WebElement webElement, String value) {
        webElement.clear();
        webElement.sendKeys(value);
    }

    double parsePrice(WebElement price) {
        return Double.parseDouble(price.getText()
                .replaceAll(",", "")
                .replaceAll("-", "")
                .replaceAll("€", "")
                .trim());
    }
}
