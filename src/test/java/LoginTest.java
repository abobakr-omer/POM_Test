import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest  ;
import org.testng.annotations.Test;

public class LoginTest {

    //Variables
    private WebDriver driver;
    //LoginPage loginPage;

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



    //Test methods
    @Test
    public void validLoginTC(){
       new LoginPage(driver)
               .login("standard_user","secret_sauce")
               .isLoggedIn("https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void inValidLoginTC(){
        new LoginPage(driver).login("inValid User","secret_sauce");
    }







}
