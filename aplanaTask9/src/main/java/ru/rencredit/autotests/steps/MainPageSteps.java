package ru.rencredit.autotests.steps;

import ru.rencredit.autotests.pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainPageSteps {
    private MainPage mainPage;

    MainPageSteps(MainPage mainPage) {
        this.mainPage = mainPage;
    }

    @Step("выбирается сервис - {0}")
    public void selectService(String serviceName) {
        mainPage.selectService(serviceName);
    }
}
