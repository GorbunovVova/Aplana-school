package ru.ozon.autotests.pages;

import io.qameta.allure.Attachment;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.ozon.autotests.steps.BaseSteps;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import static ru.ozon.autotests.steps.BaseSteps.takeTextAttach;

public class SearchResultPage extends BasePage {
    @FindBy(xpath = "//div[contains(text(), 'Цена')]/..//label[text()='до']/../input")
    WebElement underPriceField;
    @FindBy(xpath = "//label[@class='checkbox-label']//span[2]")
    List<WebElement> checkBoxes;
    @FindBy(xpath = "//div[@class='z2']//div[@class='tile m-list m-border']")
    List<WebElement> goods;
    @FindBy(xpath = "//a[@href='/cart']")
    WebElement cartButton;
    @FindBy(xpath = "//span[@data-test-id='filter-block-brand-show-all']")
    WebElement openAllBrandsButton;
    @FindBy(xpath = "//div[@class='input-wrap b3o5']/input")
    WebElement inputBrandSearch;
    @FindBy(xpath = "//div[@class='b3o3']/label")
    WebElement foundBrandCheckBox;

    public void setUnderPrice(String value) throws InterruptedException {
        fillField(underPriceField, value);
    }

    public void markCheckBox(String value) throws InterruptedException {
        for (WebElement checkBox : checkBoxes) {
            if (checkBox.getText().equalsIgnoreCase(value)) {
                checkBox.findElement(By.xpath("../..")).click();
                Thread.sleep(1000);
                return;
            }
        }
        Assert.fail("Чекбокс не найден - " + value);
    }

    public void addToCartGoods(int parity, int limit) {
        int i = 1;
        Map<String, String> selectedGoods = BaseSteps.getSelectedGoods();
        for (WebElement good : goods) {
            if ((i + parity) % 2 == 0 && i <= limit * 2) {
                String name = good.findElement(By.xpath(".//span[@data-test-id='tile-name']")).getText();
                String price = good.findElement(By.xpath(".//span[@data-test-id='tile-price']")).getText();
                selectedGoods.put(name, price);
                good.findElement(By.xpath(".//button[@data-test-id='tile-buy-button']")).click();
            }
            i++;
        }
    }

    public void goToCart() throws InterruptedException {
        Thread.sleep(1000);
        cartButton.click();
    }

    public void saveGoodsInformationFile() {
        Map<String, String> selectedGoods = BaseSteps.getSelectedGoods();
        File file = new File("goods.txt");
        for (int i = 1; file.exists(); i++) {
            file = new File(String.format("goods%d.txt", i));
        }
        try (FileWriter writer = new FileWriter(file)) {
            for (Map.Entry<String, String> entry : selectedGoods.entrySet()) {
                writer.write(entry.getKey() + " : " + entry.getValue().replaceAll("\\D", "") + " руб" + System.lineSeparator());
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        takeTextAttach(file.getName());
    }

    public void selectBrand(String brand) throws InterruptedException {
        try {
            openAllBrandsButton.click();
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        fillField(inputBrandSearch, brand);
        foundBrandCheckBox.click();
        Thread.sleep(1000);
    }
}
