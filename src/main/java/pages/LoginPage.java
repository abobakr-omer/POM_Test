package pages;

import bots.ActionsBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

    //Variables
    private WebDriver driver;
    private ActionsBot actionsBot;


    //Locators
    private final By userName=By.id("user-name");
    private final By password=By.id("password");
    private final By loginBtn=By.id("login-button");
    private final By errorMsg=By.cssSelector("h3[data-test=\"error\"]");





    //Constructor
    public LoginPage(WebDriver driver){
        this.driver=driver;
        this.actionsBot=new ActionsBot(driver);
    }




    //Actions

    public LoginPage login(String username, String pass){
        actionsBot.type(userName,username);
        actionsBot.type(password,pass);
        actionsBot.click(loginBtn);
        return this;
    }

    public HomePage isLoggedIn(String expectedUrl){
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl,"Login failed - URL mismatch");
        return new HomePage(driver);
    }

    public boolean notLogin(String expectedErrorMsg){
        return  actionsBot.getText(errorMsg).equals(expectedErrorMsg);
    }





}
