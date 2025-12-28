package tests;

import drivers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest  ;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.JsonReader;
import utils.PropertyReader;

public class LoginTest {

    //Variables
    private WebDriver driver;
    //pages.LoginPage loginPage;
    JsonReader jsonReader;

    //Configuration before and after methods
    @BeforeTest
     public void setUp(){
        driver= WebDriverFactory.initDriver();
        jsonReader=new JsonReader("data");
        driver.get(PropertyReader.getProperty("baseUrl"));
    }

    @AfterMethod
    public void tearDown(){
        WebDriverFactory.quitDriver();
    }



    //Test methods
    @Test
    public void validLoginTC(){
       new LoginPage(driver)
               .login(jsonReader.getJsonData("username"), jsonReader.getJsonData("password"))
               .isLoggedIn("https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void inValidLoginTC(){
        new LoginPage(driver).login("inValid User","secret_sauce");
    }







}
