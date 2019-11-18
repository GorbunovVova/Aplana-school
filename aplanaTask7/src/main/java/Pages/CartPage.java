package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends BasePage {
    @FindBy(xpath = "//div[@class='total-amount__info-block']/div[@class='item-price']/span")
    WebElement totalPrice;
    @FindBy(xpath = "//a[@class='restore-last-removed']")
    WebElement restoreButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkGuarantee(int guarantee) {
        return driver.findElement(By.xpath("//div[3]/div[@class='radio radio_checked'] ")).isDisplayed();
    }

    public double getPrice(int i) {
        WebElement priceElement = driver.findElement(By.xpath("//div[@class='cart-list__products']/div[" + i + "]//div[@class='item-price']/span"));
        return parsePrice(priceElement);
    }

    public double getTotalPrice() {
        return parsePrice(totalPrice);
    }

    public void removeItem(int i) throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='cart-list__products']/div[" + i + "]//button[@class='remove-button']")).click();
        Thread.sleep(2000);
    }

    public boolean checkExistingItem(int i) {
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='cart-list__product']/div"));
        return elements.size() >= i;
    }

    public void addSameItems(int i) throws InterruptedException {
        WebElement addButton = driver.findElement(By.xpath("//div[@class='cart-list__products']/div[1]//button[contains(@class, 'plus')]"));
        for (int j = 0; j < i; j++) {
            addButton.click();
            Thread.sleep(2000);
        }
    }

    public void restoreLastRemoved() throws InterruptedException {
        restoreButton.click();
        Thread.sleep(2000);
    }
}
