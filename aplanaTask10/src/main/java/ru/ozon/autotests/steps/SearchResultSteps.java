package ru.ozon.autotests.steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import ru.ozon.autotests.pages.SearchResultPage;

public class SearchResultSteps {
    private SearchResultPage searchResultPage;

    public SearchResultSteps(SearchResultPage searchResultPage) {
        this.searchResultPage = searchResultPage;
    }

    @Step("цена товара ограничевается до - {0}")
    public void setUnderPrice(String value) throws InterruptedException {
        searchResultPage.setUnderPrice(value);
    }

    @Step("отмечается чекбокс - {0}")
    public void markCheckBox(String value) throws InterruptedException {
        searchResultPage.markCheckBox(value);
    }

    @Step("из результатов поиска добавляются в корзину первые {0} {1} товаров")
    public void selectLimitFoundItems(int limitNumber, String parity) {
        if (parity.equalsIgnoreCase("четных")) {
            searchResultPage.addToCartGoods(0, limitNumber);
        } else if (parity.equalsIgnoreCase("нечетных")) {
            searchResultPage.addToCartGoods(1, limitNumber);
        } else {
            Assert.fail("неправильный аргумент. Введите: 'четных' или 'нечетных'");
        }
    }

    @Step("из результатов поиска добавляются в корзину {0} товары")
    public void selectFoundItems(String parity) {
        if (parity.equalsIgnoreCase("четные")) {
            searchResultPage.addToCartGoods(0, 100);
        } else if (parity.equalsIgnoreCase("нечетные")) {
            searchResultPage.addToCartGoods(1, 100);
        } else {
            Assert.fail("неправильный аргумент. Введите: 'четных' или 'нечетных'");
        }
    }

    @Step("в отчет добавляется файл с информацией о товарах goods.txt")
    public void saveGoodsInformationFile() {
        searchResultPage.saveGoodsInformationFile();
    }

    @Step("переход в корзину")
    public void goToCart() throws InterruptedException {
        searchResultPage.goToCart();
    }

    @Step("выбирается бренд - {0}")
    public void selectBrand(String brand) throws InterruptedException {
        searchResultPage.selectBrand(brand);
    }

}
