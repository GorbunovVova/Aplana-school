package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(id = "aa-search-input")
    private WebElement input;
    @FindBy(id = "serch-button")
    private WebElement button;
    @FindBy(xpath = "//*[contains(@href, 'muhn2da')]/mark[text()='MacBook']")
    private WebElement selectedNoteBook;
    @FindBy(xpath = "//div[contains(@class,'product-price price')]")
    private WebElement price;
    @FindBy(xpath = "//div[@class='add-to-cart-panel']/input[@value='В корзину']")
    private WebElement addToCartButton;
    @FindBy(className = "topcartlink")
    private WebElement topCartButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void search(String string) {
        fillField(input, string);
        button.click();
    }

    public void selectMacBook() {
        selectedNoteBook.click();
    }

    public double getPrice() {
        return parsePrice(price);
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public void goToCart() {
        topCartButton.click();
    }
}