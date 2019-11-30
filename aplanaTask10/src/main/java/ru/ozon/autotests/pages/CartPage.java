package ru.ozon.autotests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.ozon.autotests.steps.BaseSteps;

import java.util.List;
import java.util.Map;

public class CartPage extends BasePage {
    @FindBy(xpath = "//a[@class='a5c8']/span")
    List<WebElement> goods;
    @FindBy(xpath = "//div[@class='ap0']")
    WebElement yourCart;
    @FindBy(xpath = "//span[contains(text(), 'Удалить выбранные')]")
    WebElement removeAllGoodsButton;
    @FindBy(xpath = "//button[@data-test-id='checkcart-confirm-modal-confirm-button']")
    WebElement confirmButton;
    @FindBy(xpath = "//h1[@class='a3s6']")
    WebElement titleEmptyCart;


    public boolean goodsArePresentsInTheCart() {
        Map<String, String> selectedGoods = BaseSteps.getSelectedGoods();
        for (WebElement good : goods) {
            if (!selectedGoods.containsKey(good.getText())) {
                return false;
            }
        }
        return true;
    }

    public boolean checkTextYourCart(String value) {
        return yourCart.findElement(By.xpath("./span[1]")).getText().contains("Ваша корзина")
                && yourCart.findElement(By.xpath("./span[2]")).getText().contains(value);

    }

    public void removeAllGoods() throws InterruptedException {
        removeAllGoodsButton.click();
        Thread.sleep(1000);
        confirmButton.click();
        Thread.sleep(1000);
    }

    public boolean cartIsEmpty() {
        return titleEmptyCart.getText().contains("Корзина пуста");
    }
}