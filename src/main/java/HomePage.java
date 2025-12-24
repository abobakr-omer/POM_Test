import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {

    private WebDriver driver;
    private static int cartCount = 0;

    // Locator for the cart icon (this is still necessary for validation)
    private final By cartIcon = By.cssSelector("[data-test='shopping-cart-link']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to add an item to the cart by index (no redundant locator)
    public HomePage addToCartByIndex(int ...index) {
        // Dynamically generate the XPath based on the provided index
        By dynamicAddToCartButton = By.xpath("(//button[text()='Add to cart'])[" + index + "]");
        driver.findElement(dynamicAddToCartButton).click();
        cartCount++;
        System.out.println("Item added to cart. Current cart count: " + cartCount);
        return this;
    }

    // Method to validate the cart icon count
    public HomePage validateCartIcon() {
        String cartIconText = driver.findElement(cartIcon).getText();
        Assert.assertEquals(cartIconText, String.valueOf(cartCount), "Item was not added to cart");
        return this;
    }
}
