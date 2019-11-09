import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SeleniumTest {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://www.sberbank.ru/ru/person";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TestSber() {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//header//div[@class='hd-ft-region__title']")).click();
        fillField(By.xpath("//input[@class='kit-input__control' and @type='search']"), "ниже");
        driver.findElement(By.linkText("Нижегородская область")).click();
        assertEquals("Нижегородская область", driver.findElement(By.xpath("//header//div[@class='hd-ft-region__title']/span")).getText());
        assertTrue(driver.findElement(By.className("footer__social")).isDisplayed());
        System.out.println("Тест прошел успешно");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public void fillField(By locator, String value) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }
}
