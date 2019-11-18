package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductCartPage extends BasePage {
    @FindBy(xpath = "//div[@class='clearfix']//span[@class='current-price-value']")
    private WebElement price;
    @FindBy(xpath = "//select[@class='form-control select']")
    private WebElement selectElement;
    @FindBy(xpath = "//button[@class='btn btn-cart btn-lg']")
    private WebElement addToCartButton;
    @FindBy(xpath = "//div[@class='buttons']//span[@data-of='totalPrice']")
    private WebElement totalPrice;
    @FindBy(xpath = "//div[@class='buttons']/a[@class='btn-cart-link']")
    private WebElement goToCartButton;

    public ProductCartPage(WebDriver driver) {
        super(driver);
    }

    public double getPrice() {
        return parsePrice(price);
    }

    public void select(int i) throws InterruptedException {
        Select select = new Select(selectElement);
        select.selectByIndex(i);
        Thread.sleep(2000);
    }

    public void addToCart() throws InterruptedException {
        addToCartButton.click();
        Thread.sleep(2000);
    }

    public double getTotalPrice() {
        return parsePrice(totalPrice);
    }

    public void goToCart() {
        goToCartButton.click();
    }
}
