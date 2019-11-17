package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CartPage extends BasePage {
    @FindBy(className = "product-unit-price")
    private WebElement price;
    @FindBy(xpath = "//td[contains(@class,'subtotalprice')]")
    private WebElement totalPrice;
    @FindBy (xpath = "//*[contains(@class,'quantityselect')]")
    private WebElement selectElement;

    public CartPage(WebDriver driver) {
        super(driver);
    }
    public double getPrice() {
        return parsePrice(price);
    }

    public double getTotalPrice() {
        return parsePrice(totalPrice);
    }

    public void select(int i) throws InterruptedException {
        Select select = new Select(selectElement);
        select.selectByValue(String.valueOf(i));
        Thread.sleep(3000);
    }
}
