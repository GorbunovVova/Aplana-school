import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class SberTest {
    private WebDriver driver;
    private String baseUrl;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Petrov", "Petr", "01.01.1990", "Петров", "Петр", "Петрович", "01.01.1990", "1234", "123456", "01.01.2010", "Московским ГОВД"},
                {"Ivanov", "Ivan", "01.01.1991", "Иванов", "Иван", "Иванович", "01.01.1991", "2345", "234567", "01.01.2011", "Саратовским ГОВД"},
                {"Sergeev", "Sergey", "01.01.1992", "Сергеев", "Сергей", "Сергеевич", "01.01.1992", "3456", "345678", "01.01.2012", "Самарским ГОВД"}});
    }

    @Parameterized.Parameter
    public String insuredSurname;
    @Parameterized.Parameter(1)
    public String insuredName;
    @Parameterized.Parameter(2)
    public String insuredBirthDate;
    @Parameterized.Parameter(3)
    public String surname;
    @Parameterized.Parameter(4)
    public String name;
    @Parameterized.Parameter(5)
    public String middleName;
    @Parameterized.Parameter(6)
    public String birthDate;
    @Parameterized.Parameter(7)
    public String docSeries;
    @Parameterized.Parameter(8)
    public String docNumber;
    @Parameterized.Parameter(9)
    public String issueDate;
    @Parameterized.Parameter(10)
    public String issuePlace;

    @Before
    public void setUp() {
//        System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer_x64_3.14.0/IEDriverServer.exe");
//        driver = new InternetExplorerDriver();
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
//        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver-v0.25.0-win64/geckodriver.exe");
//        driver = new FirefoxDriver();
        baseUrl = "http://www.sberbank.ru/ru/person";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TestSber() {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//span[text()='Страхование']")).click();
        driver.findElement(By.xpath("//a[text()='Страхование путешественников' and @class=\"lg-menu__sub-link\"]")).click();
        assertThat(driver.findElement(By.xpath("//h1[text()='Страхование путешественников']")).isDisplayed(), equalTo(true));
        String oldWindow = driver.getWindowHandle();
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p/a/img"))));
        driver.findElement(By.xpath("//p/a/img")).click();
        Set<String> newWindowsSet = driver.getWindowHandles();
        newWindowsSet.remove(oldWindow);
        String newWindowHandle = newWindowsSet.iterator().next();
        driver.switchTo().window(newWindowHandle);
        driver.findElement(By.xpath("//div[text()='Минимальная']")).click();
        driver.findElement(By.xpath("//span[text()='Оформить']")).click();
        fillField(By.name("insured0_surname"), insuredSurname);
        fillField(By.name("insured0_name"), insuredName);
        fillField(By.name("insured0_birthDate"), insuredBirthDate);
        fillField(By.name("surname"), surname);
        fillField(By.name("name"), name);
        fillField(By.name("middlename"), middleName);
        fillField(By.name("birthDate"), birthDate);
        fillField(By.xpath("//input[contains(@ng-model, 'DOCSERIES')]"), docSeries);
        fillField(By.xpath("//input[contains(@ng-model, 'DOCNUMBER')]"), docNumber);
        fillField(By.name("issueDate"), issueDate);
        fillField(By.name("issuePlace"), issuePlace);
        assertThat(driver.findElement(By.name("insured0_surname")).getAttribute("value"), equalTo(insuredSurname));
        assertThat(driver.findElement(By.name("insured0_name")).getAttribute("value"), equalTo(insuredName));
        assertThat(driver.findElement(By.name("insured0_birthDate")).getAttribute("value"), equalTo(insuredBirthDate));
        assertThat(driver.findElement(By.name("surname")).getAttribute("value"), equalTo(surname));
        assertThat(driver.findElement(By.name("name")).getAttribute("value"), equalTo(name));
        assertThat(driver.findElement(By.name("middlename")).getAttribute("value"), equalTo(middleName));
        assertThat(driver.findElement(By.name("birthDate")).getAttribute("value"), equalTo(birthDate));
        assertThat(driver.findElement(By.xpath("//input[contains(@ng-model, 'DOCSERIES')]")).getAttribute("value"), equalTo(docSeries));
        assertThat(driver.findElement(By.xpath("//input[contains(@ng-model, 'DOCNUMBER')]")).getAttribute("value"), equalTo(docNumber));
        assertThat(driver.findElement(By.name("issueDate")).getAttribute("value"), equalTo(issueDate));
        assertThat(driver.findElement(By.name("issuePlace")).getAttribute("value"), equalTo(issuePlace));
        driver.findElement(By.xpath("//span[text()='Продолжить']")).click();
        assertThat(driver.findElement(By.xpath("//div[text()='Заполнены не все обязательные поля']")).isDisplayed(), equalTo(true));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    private void fillField(By locator, String value) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }
}
