package Flows;


import common.WebDriverFunctions;
import common.elements.LoginElements;
import common.helper.RunTimeUtilities;
import org.openqa.selenium.WebDriver;
import common.logic.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class PreRequisiteTestCases  {
    public static WebDriver driver;

    public static boolean passCasesInPreReq = false;
    @BeforeTest(description = "Initialize Web-Driver")
    public void initializeWebDriver() throws IOException {
        if(!RunTimeUtilities.isDriverInitialized){
            driver = WebDriverFunctions.initializeWebDriver();
            RunTimeUtilities.isDriverInitialized = true;
        }
    }
    @Test(priority = 1)
    public void applicationNavigation(){
        if(!RunTimeUtilities.isSystemIsLogin){
            loginLogic.frontendnavigation(driver);
            RunTimeUtilities.isSystemIsLogin = true;
        }
    }
    @Test(priority = 2, dependsOnMethods = {"applicationNavigation"})
    public void checkvalid_usernameinvalid_password(){
        loginvalidations.loginScenario (driver, LoginElements.valid_username, LoginElements.invalid_password, false);
    }
    @Test(priority = 3, dependsOnMethods = {"applicationNavigation"})
    public void checkinvalid_usernameinvalid_password(){
        loginvalidations.loginScenario (driver, LoginElements.invalid_usernameFs, LoginElements.invalid_passwordFs, false);
    }
    @Test(priority = 4, dependsOnMethods = {"applicationNavigation"})
    public void checkinvalid_usernamevalid_password(){
        loginvalidations.loginScenario (driver, LoginElements.invalid_username, LoginElements.valid_password, false);
    }
    @Test(priority = 4, dependsOnMethods = {"applicationNavigation"})
    public void checkvalid_usernamevalid_password(){
        loginvalidations.loginScenario (driver, LoginElements.valid_usernameTs, LoginElements.valid_passwordTs, true);
    }

}


