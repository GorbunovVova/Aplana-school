package ru.sberbank.autotests.steps;

import ru.sberbank.autotests.pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainPageSteps {
    private MainPage mainPage;

    MainPageSteps(MainPage mainPage) {
        this.mainPage = mainPage;
    }

    @Step("выбран пункт меню {0}")
    void selectMenuItem(String mainMenu) {
        mainPage.selectMainMenuItem(mainMenu);
    }

    @Step("выбран пункт подменю {0}")
    void selectSubMenuItem(String subMenu) throws InterruptedException {
        mainPage.selectSubMenuItem(subMenu);
    }
}
