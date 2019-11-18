import Pages.CartPage;
import Pages.HomePage;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ComputerUniverseTest extends BaseTest {
    @Test
    public void testComputerUniverse() throws InterruptedException {
        driver.get(baseUrl);
        HomePage homePage = new HomePage(driver);
        homePage.search("macbook pro");
        homePage.selectMacBook();
        double price = homePage.getPrice();
        homePage.addToCart();
        homePage.goToCart();
        CartPage cartPage = new CartPage(driver);
        assertThat(price, equalTo(cartPage.getPrice()));
        assertThat(price, equalTo(cartPage.getTotalPrice()));
        cartPage.select(2);
        assertThat(price * 2, equalTo(cartPage.getTotalPrice()));
    }
}
