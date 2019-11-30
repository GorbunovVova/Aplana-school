package ru.ozon.autotests.steps;

import io.qameta.allure.Step;
import ru.ozon.autotests.pages.CartPage;

import static junit.framework.TestCase.assertTrue;

public class CartSteps {
    private CartPage cartPage;

    public CartSteps(CartPage cartPage) {
        this.cartPage = cartPage;
    }

    @Step("все добавленные ранее товары находятся в корзине")
    public void goodsArePresentsInTheCart() {
        assertTrue(cartPage.goodsArePresentsInTheCart());
    }

    @Step("отображается текст 'Ваша корзина - {0}'")
    public void checkTextYourCart(String value) {
        assertTrue(cartPage.checkTextYourCart(value));
    }

    @Step("удаляются все товары из корзины")
    public void removeAllGoods() throws InterruptedException {
        cartPage.removeAllGoods();
    }

    @Step("проверяется что корзина пуста")
    public void cartIsEmpty() {
        assertTrue(cartPage.cartIsEmpty());
    }
}
