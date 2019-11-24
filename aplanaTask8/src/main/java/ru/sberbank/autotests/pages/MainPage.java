package ru.sberbank.autotests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    @FindBy(xpath = "//span[text()='Ипотека']")
    private WebElement mortgageMenu;
    @FindBy(xpath = "//li[@class='lg-menu__sub-item']/a[text()='Ипотека на готовое жильё']")
    private WebElement mortgageOnReadyMenu;

    public void selectMainMenuItem(String mainMenu) {
        mortgageMenu.click();
    }

    public void selectSubMenuItem(String subMenu) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(mortgageOnReadyMenu));
        mortgageOnReadyMenu.click();
        Thread.sleep(2000);
    }
}
