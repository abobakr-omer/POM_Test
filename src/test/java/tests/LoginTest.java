package tests;

import drivers.WebDriverFactory;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
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
    @Description("Verify that user is able to login with valid credentials")
    @Tag("ValidLogin")
    @Owner("Aboubakr")
    @Severity(SeverityLevel.CRITICAL)
    @Link("www.confluence.jira.com/login")
    @TmsLink("https://ashrafnezam.atlassian.net/projects/TA?selectedItem=com.atlassian.plugins.atlassian-connect-plugin:com.kanoah.test-manager__main-project-page#!/v2/testCase/TA-T1")
    @Issue("https://ashrafnezam.atlassian.net/browse/TA-64")
    public void validLoginTC(){
        Allure.getLifecycle().updateTestCase(testResult -> {
            testResult.setName("Valid Login Test Case");
        });
       new LoginPage(driver)
               .login(jsonReader.getJsonData("username"), jsonReader.getJsonData("password"))
               .isLoggedIn("https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void inValidLoginTC(){
        new LoginPage(driver).login("inValid User","secret_sauce");
    }







}
