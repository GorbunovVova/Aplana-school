package ru.sberbank.autotests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.sberbank.autotests.steps.BaseSteps;


public class DataEntryPage extends BasePage {
    @FindBy(id = "estateCost")
    private WebElement estateCostField;
    @FindBy(id = "initialFee")
    private WebElement initialFeeField;
    @FindBy(id = "creditTerm")
    private WebElement creditTermField;
    @FindBy(xpath = "//div[@class='dcCalc_frame__discounts']/div[2]//div[@class='dcCalc_switch-tablet__switch']")
    private WebElement sberbankClientCheckbox;
    @FindBy(xpath = "//div[text()='Есть возможность подтвердить доход справкой']")
    private WebElement proofOfIncomeCheckbox;
    @FindBy(xpath = "//div[@class='dcCalc_frame__discounts']/div[5]//div[@class='dcCalc_switch-tablet__switch']/label")
    private WebElement youngFamilyCheckbox;
    @FindBy(xpath = "//span[@data-test-id='amountOfCredit']")
    private WebElement amountOfCredit;
    @FindBy(xpath = "//span[@data-test-id='monthlyPayment']")
    private WebElement monthlyPayment;
    @FindBy(xpath = "//span[@data-test-id='requiredIncome']")
    private WebElement requiredIncome;
    @FindBy(xpath = "//span[@data-test-id='rate']")
    private WebElement rate;
    @FindBy(xpath = "//a[@class='cookie-warning__close']")
    private WebElement cookieWindow;

    public void goToCalculateFrame() throws InterruptedException {
        try {
            cookieWindow.click();
        } catch (Exception ignored) {
        }
        WebDriver driver = BaseSteps.getDriver();
        WebElement iframe = driver.findElement(By.id("iFrameResizer0"));
        wait.until(ExpectedConditions.visibilityOf(iframe));
        driver.switchTo().frame(driver.findElement(By.id("iFrameResizer0")));
        Thread.sleep(2000);
    }

    public void fillField(String fieldName, String fieldValue) throws InterruptedException {
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

    public void switchSberbankClient() throws InterruptedException {
        sberbankClientCheckbox.click();
        Thread.sleep(1000);
    }

    public void waitForProofOfIncome() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(proofOfIncomeCheckbox));
        Thread.sleep(1000);
    }

    public void switchYoungFamily() throws InterruptedException {
        youngFamilyCheckbox.click();
        Thread.sleep(1000);
    }

    public String getFieldValue(String fieldName) {
        switch (fieldName) {
            case "Сумма кредита":
                return amountOfCredit.getText();
            case "Ежемесячный платеж":
                return monthlyPayment.getText();
            case "Необходимый доход":
                return requiredIncome.getText();
            case "Процентная ставка":
                return rate.getText();
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }
}
