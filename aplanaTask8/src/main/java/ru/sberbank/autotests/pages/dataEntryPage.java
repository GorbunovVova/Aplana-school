package ru.sberbank.autotests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class dataEntryPage extends BasePage {
    @FindBy(id = "estateCost")
    private WebElement estateCostField;
    @FindBy(id = "initialFee")
    private WebElement initialFeeField;
    @FindBy(id = "creditTerm")
    private WebElement creditTermField;
    @FindBy(xpath = "//input[@type='checkbox' and @data-test-id='paidToCard']")
    WebElement sberbankClientCheckbox;
    @FindBy(xpath = "//div[text()='Есть возможность подтвердить доход справкой']")
    WebElement proofOfIncomeCheckbox;
    @FindBy(xpath = "//input[@type='checkbox' and @data-test-id='youngFamilyDiscount']")
    WebElement youngFamilyCheckbox;
    @FindBy(xpath = "//span[@data-test-id='amountOfCredit']")
    WebElement amountOfCredit;
    @FindBy(xpath = "//span[@data-test-id='monthlyPayment']")
    WebElement monthlyPayment;
    @FindBy(xpath = "//span[@data-test-id='requiredIncome']")
    WebElement requiredIncome;
    @FindBy(xpath = "//span[@data-test-id='rate']")
    WebElement rate;

    dataEntryPage(WebDriver driver) {
        super(driver);
    }

    public void fillField(String fieldName, String fieldValue) {
        switch (fieldName) {
            case "Стоимость недвижимости":
                fillField(estateCostField, fieldValue);
                break;
            case "Первоначальный взнос":
                fillField(initialFeeField, fieldValue);
                break;
            case "Срок кредита":
                fillField(creditTermField, fieldValue);
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }

    public void switchToSberbankClient() {
        sberbankClientCheckbox.click();
        wait.until(ExpectedConditions.visibilityOf(proofOfIncomeCheckbox));
    }

    public void switchToYoungFamily() {
        youngFamilyCheckbox.click();
    }
}
