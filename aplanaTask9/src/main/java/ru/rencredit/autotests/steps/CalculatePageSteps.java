package ru.rencredit.autotests.steps;

import ru.rencredit.autotests.pages.CalculatePage;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertEquals;

public class CalculatePageSteps {
    private CalculatePage calculatePage;

    public CalculatePageSteps(CalculatePage calculatePage) {
        this.calculatePage = calculatePage;
    }

    @Step("выбирается валюта - {0}")
    public void selectCurrency(String currencyName) {
        calculatePage.selectCurrency(currencyName);
    }

    @Step("поле {0} заполняется значением {1}")
    public void fillField(String fieldName, String fieldValue) throws InterruptedException {
        calculatePage.setFieldValue(fieldName, fieldValue);
    }

    @Step("выбирается срок - {0}")
    public void selectLoanPeriod(String value) throws InterruptedException {
        calculatePage.selectLoanPeriod(value);
    }

    @Step("отмечается чекбокс - {0}")
    public void clickCheckBox(String checkBoxName) throws InterruptedException {
        calculatePage.clickCheckBox(checkBoxName);
    }

    @Step("расчетное значение - {0} равно - {1}")
    public void checkFieldValue(String calculation, String value) {
        String actual = calculatePage.getCalculatedValue(calculation);
        assertEquals(String.format("расчетное значение [%s] равно [%s]. Ожидалось - [%s]", calculation, actual, value), value, actual);
    }
}
