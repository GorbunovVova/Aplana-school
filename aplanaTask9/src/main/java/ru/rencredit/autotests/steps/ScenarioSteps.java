package ru.rencredit.autotests.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.ru.Когда;
import ru.rencredit.autotests.pages.CalculatePage;
import ru.rencredit.autotests.pages.MainPage;

public class ScenarioSteps {
    private MainPageSteps mainPageSteps = new MainPageSteps(new MainPage());
    private CalculatePageSteps calculatePageSteps = new CalculatePageSteps((new CalculatePage()));


    @Когда("^выбирается сервис - \"(.+)\"$")
    public void selectMenuItem(String serviceName) {
        mainPageSteps.selectService(serviceName);
    }

    @When("^выбирается валюта - \"(.+)\"$")
    public void selectCurrency(String currencyName) {
        calculatePageSteps.selectCurrency(currencyName);
    }

    @When("^поле \"(.+)\" заполняется значением \"(.+)\"$")
    public void fillField(String fieldName, String fieldValue) throws InterruptedException {
        calculatePageSteps.fillField(fieldName, fieldValue);
    }

    @When("^выбирается срок - \"(.+)\"$")
    public void selectLoanPeriod(String value) throws InterruptedException {
        calculatePageSteps.selectLoanPeriod(value);
    }

    @When("^отмечается чекбокс - \"(.+)\"$")
    public void clickCheckBox(String checkBoxName) throws InterruptedException {
        calculatePageSteps.clickCheckBox(checkBoxName);
    }

    @Then("^значения полей равны:$")
    public void checkFillForm(DataTable fields) {
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> calculatePageSteps.checkFieldValue(field, value));
    }
}
