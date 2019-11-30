package ru.ozon.autotests.steps;


import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ru.ozon.autotests.pages.CartPage;
import ru.ozon.autotests.pages.MainPage;
import ru.ozon.autotests.pages.SearchResultPage;

public class ScenarioSteps {
    private MainSteps mainSteps = new MainSteps(new MainPage());
    private SearchResultSteps searchResultSteps = new SearchResultSteps(new SearchResultPage());
    private CartSteps cartSteps = new CartSteps(new CartPage());


    @When("^ищется - \"(.+)\"$")
    public void selectMenuItem(String value) throws InterruptedException {
        mainSteps.search(value);
    }

    @When("^цена товара ограничевается до - \"(.+)\"$")
    public void setUnderPrice(String value) throws InterruptedException {
        searchResultSteps.setUnderPrice(value);
    }

    @When("^отмечается чекбокс - \"(.+)\"$")
    public void markCheckBox(String value) throws InterruptedException {
        searchResultSteps.markCheckBox(value);
    }

    @When("^из результатов поиска добавляются в корзину первые \"(.+)\" \"(.+)\" товаров$")
    public void selectLimitFoundItems(String number, String parity) {
        searchResultSteps.selectLimitFoundItems(Integer.parseInt(number), parity);
    }

    @When("^из результатов поиска добавляются в корзину \"(.+)\" товары$")
    public void selectFoundItems(String parity) {
        searchResultSteps.selectFoundItems(parity);
    }
    @When("^создается файл с информацией о товарах$")
    public void saveGoodsInformationFile() {
        searchResultSteps.saveGoodsInformationFile();
    }

    @When("^переход в корзину$")
    public void goToCart() throws InterruptedException {
        searchResultSteps.goToCart();
    }

    @Then("^все добавленные ранее товары находятся в корзине$")
    public void goodsArePresentsInTheCart() {
        cartSteps.goodsArePresentsInTheCart();
    }

    @Then("^отображается текст 'Ваша корзина - \"(.+)\"'$")
    public void checkTextYourCart(String value) {
        cartSteps.checkTextYourCart(value);
    }

    @When("^удаляются все товары из корзины$")
    public void removeAllGoods() throws InterruptedException {
        cartSteps.removeAllGoods();
    }

    @Then("^проверяется что корзина пуста$")
    public void cartIsEmpty() {
        cartSteps.cartIsEmpty();
    }

    @When("^выбирается бренд - \"(.+)\"$")
    public void selectBrand(String brand) throws InterruptedException {
        searchResultSteps.selectBrand(brand);
    }
}
