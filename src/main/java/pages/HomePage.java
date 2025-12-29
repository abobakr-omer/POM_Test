package pages;

import bots.ActionsBot;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.JsonReader;

public class HomePage {

    private WebDriver driver;
    private ActionsBot actionsBot;
    private static int cartCount = 0;

    // Locator for the cart icon (this is still necessary for validation)
    private final By cartIcon = By.cssSelector("[data-test='shopping-cart-link']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.actionsBot = new ActionsBot(driver);
    }

    // Method to add an item to the cart by index (no redundant locator)
    @Step("Add item(s) to cart by index: {index}")
    public HomePage addToCartByIndex(int ...index) {
        // Dynamically generate the XPath based on the provided index
        for (int i : index) {
            By addToCartButton = By.xpath("(//button[contains(text(),'Add to cart')])[" + i + "]");
            actionsBot.click(addToCartButton);
            cartCount++;
        }
        System.out.println("Item added to cart. Current cart count: " + cartCount);
        return this;
    }

    // Method to validate the cart icon count
    @Step("Validate cart icon shows correct item count")
    public HomePage validateCartIcon() {
        String cartIconText = driver.findElement(cartIcon).getText();
        Assert.assertEquals(cartIconText, String.valueOf(cartCount), "Item was not added to cart");
        return this;
    }
}
