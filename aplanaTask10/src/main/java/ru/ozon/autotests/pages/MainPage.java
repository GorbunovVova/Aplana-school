package ru.ozon.autotests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    @FindBy(xpath = "//input[@placeholder='Искать на Ozon']")
    WebElement searchInput;
    @FindBy(xpath = "//button[@type='submit' and @class='m-search button default flat-button']")
    WebElement searchButton;
    @FindBy(xpath = "//button[@class='close']")
    WebElement cookieWindow;

    public void search(String value) throws InterruptedException {
        Thread.sleep(2000);
        try {
            cookieWindow.click();
        } catch (Exception ignored) {
        }
        fillField(searchInput, value);
        searchButton.click();
        Thread.sleep(2000);
    }
}
