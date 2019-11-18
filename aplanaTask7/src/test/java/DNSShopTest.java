import Pages.CartPage;
import Pages.ProductCartPage;
import Pages.ResultPage;
import Pages.SearchPage;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class DNSShopTest extends BaseTest {
    @Test
    public void testComputerUniverse() throws InterruptedException {
        driver.get(baseUrl);
        SearchPage searchPage = new SearchPage(driver);
        searchPage.search("playstation");
        ResultPage resultPage = new ResultPage(driver);
        Product ps4 = new Product("PlayStation 4 Slim Black");
        resultPage.selectProduct(ps4.getName());
        ProductCartPage productCartPage = new ProductCartPage(driver);
        ps4.setPriceWithoutGurantee(productCartPage.getPrice());
        productCartPage.select(2);
        ps4.setGuarantee(2);
        ps4.setPrice(productCartPage.getPrice());
        productCartPage.addToCart();
        Product detroit = new Product("Detroit");
        searchPage.search(detroit.getName());
        detroit.setPrice(productCartPage.getPrice());
        productCartPage.addToCart();
        assertThat(ps4.getPrice() + detroit.getPrice(), equalTo(productCartPage.getTotalPrice()));
        productCartPage.goToCart();
        CartPage cartPage = new CartPage(driver);
        assertThat(true, equalTo(cartPage.checkGuarantee(ps4.getGuarantee())));
        assertThat(ps4.getPriceWithoutGurantee(), equalTo(cartPage.getPrice(1)));
        assertThat(detroit.getPrice(), equalTo(cartPage.getPrice(2)));
        assertThat(ps4.getPrice() + detroit.getPrice(), equalTo(cartPage.getTotalPrice()));
        cartPage.removeItem(2);
        assertThat(false, equalTo(cartPage.checkExistingItem(2)));
        assertThat(ps4.getPrice(), equalTo(cartPage.getTotalPrice()));
        cartPage.addSameItems(2);
        assertThat(ps4.getPrice() * 3, equalTo(cartPage.getTotalPrice()));
        cartPage.restoreLastRemoved();
        assertThat(ps4.getPrice() * 3 + detroit.getPrice(), equalTo(cartPage.getTotalPrice()));
    }
}
