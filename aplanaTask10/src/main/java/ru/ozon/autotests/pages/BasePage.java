package ru.ozon.autotests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ozon.autotests.steps.BaseSteps;

public class BasePage {

    Wait<WebDriver> wait;

    BasePage() {
        WebDriver driver = BaseSteps.getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 5, 1000);
    }

    public void fillField(WebElement webElement, String value) throws InterruptedException {
        webElement.sendKeys("\b\b\b\b\b\b\b\b");
        Thread.sleep(1000);
        webElement.sendKeys(value);
        Thread.sleep(1000);
    }
}
