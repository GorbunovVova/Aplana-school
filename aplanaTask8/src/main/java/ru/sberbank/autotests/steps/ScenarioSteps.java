package ru.sberbank.autotests.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ru.sberbank.autotests.pages.DataEntryPage;
import ru.sberbank.autotests.pages.MainPage;

public class ScenarioSteps {
    private MainPageSteps mainPageSteps = new MainPageSteps(new MainPage());
    private DataEntrySteps dataEntrySteps = new DataEntrySteps(new DataEntryPage());

    @When("^выбран пункт меню \"(.+)\"$")
    public void selectMenuItem(String mainMenu) {
        mainPageSteps.selectMenuItem(mainMenu);
    }

    @When("^выбран пункт подменю \"(.+)\"$")
    public void selectSubMenuItem(String subMenu) throws InterruptedException {
        mainPageSteps.selectSubMenuItem(subMenu);
    }

    @Then("^переход к калькулятору ипотеки$")
    public void goToCalculateFrame() throws InterruptedException {
        dataEntrySteps.goToCalculateFrame();
    }

    @When("^заполняются поля:$")
    public void fillForm(DataTable fields) {
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> {
                    try {
                        dataEntrySteps.fillField(field, value);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });

    }

    @When("^снимается галочка - есть зарплатная карта Сбербанка$")
    public void switchSberbankClient() throws InterruptedException {
        dataEntrySteps.switchSberbankClient();
    }

    @Then("^ожидается появление - есть возможность подтвердить доход справкой$")
    public void waitForProofOfIncome() throws InterruptedException {
        dataEntrySteps.waitForProofOfIncome();
    }

    @When("^ставится галочка - молодая семья$")
    public void switchYoungFamily() throws InterruptedException {
        dataEntrySteps.switchYoungFamily();
    }

    @Then("^значения полей равны:$")
    public void checkFieldsValues(DataTable fields) throws InterruptedException {
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> dataEntrySteps.checkFieldValue(field, value));
        Thread.sleep(5000);
    }
}
