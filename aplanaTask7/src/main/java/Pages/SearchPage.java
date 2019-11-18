package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends BasePage {
    @FindBy(xpath = "//input[@class='ui-input-search__input main-search-form__input ui-autocomplete-input']")
    private WebElement input;
    @FindBy(xpath = "//input[@class='ui-input-search__input main-search-form__input ui-autocomplete-input']/../span[@class='ui-input-search__icon ui-input-search__icon_search']")
    private WebElement inputButton;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void search(String string) {
        fillField(input, string);
        inputButton.click();
    }
}