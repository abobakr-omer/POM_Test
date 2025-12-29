package tests.webPortal.login;

import drivers.WebDriverFactory;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
    @BeforeMethod
     public void setUp(){
        jsonReader=new JsonReader("data");
        driver= WebDriverFactory.initDriver();
        driver.get(PropertyReader.getProperty("baseUrl"));
    }

    @AfterMethod
    public void tearDown(){
        WebDriverFactory.quitDriver();
    }



    //Test methods
    @Test(priority = 1)
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

    //Behavioral-based hierarchy
    @Epic("Web Portal Login")
    @Feature("Login Feature")
    @Story("As a user, I should not be able to login with invalid credentials")
    @Test(priority = 2)
    public void inValidLoginTC(){
        new LoginPage(driver).login("inValid User","secret_sauce");
    }







}
