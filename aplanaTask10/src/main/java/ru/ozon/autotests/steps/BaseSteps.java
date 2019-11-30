package ru.ozon.autotests.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.ozon.autotests.util.TestProperties;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class BaseSteps {
    private static WebDriver driver;
    private static Properties properties = TestProperties.getInstance().getProperties();
    private static Map<String, String> selectedGoods = new HashMap<>();

    public static WebDriver getDriver() {
        return driver;
    }

    @Before
    public static void setUp() throws Exception {
        if ("firefox".equals(properties.getProperty("browser"))) {
            System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
            driver = new FirefoxDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
            driver = new ChromeDriver();
        }

        String baseUrl = properties.getProperty("app.url");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @After
    public static void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) BaseSteps.getDriver())
                        .getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        selectedGoods.clear();
        driver.quit();
    }

    @Attachment(type = "text/plain", value = "Товары")
    public static byte[] takeTextAttach(String fileName) {
        try {
            return Files.readAllBytes(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new AssertionError("Не найден файл");
    }

    public static Map<String, String> getSelectedGoods() {
        return selectedGoods;
    }
}
