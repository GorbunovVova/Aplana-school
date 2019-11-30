package ru.ozon.autotests.steps;

import io.qameta.allure.Step;
import ru.ozon.autotests.pages.MainPage;

public class MainSteps {
    private MainPage mainPage;

    public MainSteps(MainPage mainPage) {
        this.mainPage = mainPage;
    }

    @Step("ищется - {0}")
    public void search(String value) throws InterruptedException {
        mainPage.search(value);
    }
}
