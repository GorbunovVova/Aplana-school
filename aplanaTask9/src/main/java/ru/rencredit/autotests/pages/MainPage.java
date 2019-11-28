package ru.rencredit.autotests.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {
    @FindBy(xpath = "//div[@class='service__title-text']")
    List<WebElement> services;

    public void selectService(String serviceName) {
        for (WebElement service : services) {
            if (service.getText().equalsIgnoreCase(serviceName)) {
                service.findElement(By.xpath("../a[1]")).click();
                return;
            }
        }
        Assert.fail("Не найден сервис - " + serviceName);
    }
}
