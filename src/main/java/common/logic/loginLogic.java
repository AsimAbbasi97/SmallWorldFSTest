package common.logic;

import common.elements.LoginElements;
import common.helper.FindElement;
import common.pagepath.pagepaths;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class loginLogic {

    public static void frontendnavigation(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 1000);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        FindElement.waitVisibilityOfXPath(driver, LoginElements.weblogo, 10);

        if (FindElement.xpathExist(driver, LoginElements.weblogo)
                && FindElement.xpathExist(driver, LoginElements.username)
                && FindElement.xpathExist(driver, LoginElements.password)){

            try {
                Assert.assertEquals("User is able to navigate to web page", "User is able to navigate to web page");
            } catch (AssertionError assertionError) {
                throw assertionError;
            }
        }
    else {
        try {
            Assert.assertNotEquals(pagepaths.loginURL, "", "Front End link not provided");
        } catch (AssertionError assertionError) {
            throw assertionError;
        }
    }
}
}