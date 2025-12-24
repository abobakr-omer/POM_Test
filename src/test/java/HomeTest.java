import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomeTest {

    //Variables
    private WebDriver driver;

    //Configuration before and after methods
    @BeforeTest
    public void setUp(){
        EdgeOptions options=new EdgeOptions();
        options.addArguments("--start-maximized");
        driver=new EdgeDriver(options);
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    // Test methods

    @Test
    public void addToCartTC(){
        new LoginPage(driver).
                login("standard_user","secret_sauce").
                isLoggedIn("https://www.saucedemo.com/inventory.html").
                addToCartByIndex(3).addToCartByIndex(2).addToCartByIndex(4)
                .validateCartIcon();
    }



}
