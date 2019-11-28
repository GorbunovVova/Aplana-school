package ru.rencredit.autotests.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CalculatePage extends BasePage {
    @FindBy(xpath = "//span[@class='calculator__currency-field-text']")
    List<WebElement> currencies;
    @FindBy(xpath = "//input[@class='calculator__slide-input currency-input js-slide-value']")
    List<WebElement> fields;
    @FindBy(xpath = "//select[@id='period']")
    WebElement loanPeriod;
    @FindBy(xpath = "//input[@class='calculator__check']")
    List<WebElement> checkBoxes;
    @FindBy(xpath = "//span[@class='js-calc-rate']")
    WebElement rateCalculation;
    @FindBy(xpath = "//span[@class='js-calc-result']")
    WebElement resultCalculation;
    @FindBy(xpath = "//span[@class='js-calc-replenish']")
    WebElement replenishCalculation;
    @FindBy(xpath = "//span[@class='js-calc-earned']")
    WebElement earnedCalculation;


    public void selectCurrency(String currencyName) {
        for (WebElement currency : currencies) {
            if (currency.getText().equalsIgnoreCase(currencyName)) {
                currency.click();
                return;
            }
        }
        Assert.fail("Не найдена валюта - " + currencyName);
    }

    public void setFieldValue(String fieldName, String fieldValue) throws InterruptedException {
        String fieldNameAttr;
        switch (fieldName) {
            case ("Сумма вклада"):
                fieldNameAttr = "amount";
                break;
            case ("Ежемесячное пополнение"):
                fieldNameAttr = "replenish";
                break;
            default:
                fieldNameAttr = "";
                break;
        }
        for (WebElement field : fields) {
            if (field.getAttribute("name").equalsIgnoreCase(fieldNameAttr)) {
                fillField(field, fieldValue);
                return;
            }
        }
        Assert.fail("Не найдено поле - " + fieldName);
    }

    public void selectLoanPeriod(String value) throws InterruptedException {
        Select select = new Select(loanPeriod);
        select.selectByIndex(1);
        Thread.sleep(1000);
    }

    public void clickCheckBox(String checkBoxName) throws InterruptedException {
        String checkBoxNameAttr;
        switch (checkBoxName) {
            case ("Ежемесячная капитализация"):
                checkBoxNameAttr = "capitalization";
                break;
            case ("Частичное снятие"):
                checkBoxNameAttr = "partial_out";
                break;
            default:
                checkBoxNameAttr = "";
                break;
        }
        for (WebElement checkBox : checkBoxes) {
            if (checkBox.getAttribute("name").equalsIgnoreCase(checkBoxNameAttr)) {
                checkBox.findElement(By.xpath("..")).click();
                Thread.sleep(1000);
                return;
            }
        }
        Assert.fail("Не найден чекбокс - " + checkBoxName);
    }

    public String getCalculatedValue(String calculation) {
        switch (calculation) {
            case "Ставка":
                return rateCalculation.getText();
            case "К снятию через 6 месяцев":
                return resultCalculation.getText().trim();
            case "Пополнение за 6 месяцев":
                return replenishCalculation.getText().trim();
            case "Начислено":
                return earnedCalculation.getText().trim();
            default:
                throw new AssertionError("Расчет '" + calculation + "' не объявлен на странице");
        }
    }
}
