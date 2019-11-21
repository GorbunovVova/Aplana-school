package ru.sberbank.autotests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    @FindBy(xpath = "//span[text()='Ипотека']")
    WebElement mortgageMenu;
    @FindBy(xpath = "//li[@class='lg-menu__sub-item']/a[text()='Ипотека на готовое жильё']")
    WebElement mortgageOnReadyMenu;

    MainPage(WebDriver driver) {
        super(driver);
    }

    public void goToMortgageOnReadyHousing() {
        mortgageMenu.click();
        wait.until(ExpectedConditions.visibilityOf(mortgageOnReadyMenu));
        mortgageOnReadyMenu.click();
    }
}
