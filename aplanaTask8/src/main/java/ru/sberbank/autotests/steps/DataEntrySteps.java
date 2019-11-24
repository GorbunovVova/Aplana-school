package ru.sberbank.autotests.steps;

import ru.sberbank.autotests.pages.DataEntryPage;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertEquals;

class DataEntrySteps {
    private DataEntryPage dataEntryPage;

    DataEntrySteps(DataEntryPage dataEntryPage) {
        this.dataEntryPage = dataEntryPage;
    }

    @Step("переход к калькулятору ипотеки")
    void goToCalculateFrame() throws InterruptedException {
        dataEntryPage.goToCalculateFrame();
    }

    @Step("поле {0} заполняется значением {1}")
    void fillField(String field, String value) throws InterruptedException {
        dataEntryPage.fillField(field, value);
    }

    @Step("снимается галочка - есть зарплатная карта Сбербанка")
    void switchSberbankClient() throws InterruptedException {
        dataEntryPage.switchSberbankClient();
    }

    @Step("ожидается появление - есть возможность подтвердить доход справкой")
    void waitForProofOfIncome() throws InterruptedException {
        dataEntryPage.waitForProofOfIncome();
    }

    @Step("ставится галочка - молодая семья")
    void switchYoungFamily() throws InterruptedException {
        dataEntryPage.switchYoungFamily();
    }

    @Step("поле {0} заполнено значением {1}")
    void checkFieldValue(String field, String value) {
        String actual = dataEntryPage.getFieldValue(field);
        assertEquals(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value), value, actual);
    }
}
