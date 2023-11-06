package common.logic;

import common.elements.LoginElements;
import common.pagepath.pagepaths;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class loginvalidations {

        public static void loginScenario (WebDriver driver, String username, String password,boolean expectedResult){
            if (driver.getCurrentUrl().equals(pagepaths.loginURL)) {
                // Refresh the page
                driver.navigate ().refresh ();

                // Find and fill in the username and password fields
                WebElement usernameField = driver.findElement (By.xpath (LoginElements.username));
                WebElement passwordField = driver.findElement (By.xpath (LoginElements.password));
                usernameField.sendKeys (username);
                passwordField.sendKeys (password);

                // Submit the form or perform login action (customize this)
                WebElement loginButton = driver.findElement (By.xpath (LoginElements.login));
                loginButton.click ();

                // Wait for the page to load
                WebDriverWait wait = new WebDriverWait (driver, 10);
                wait.until(d -> {
                    String currentUrl = d.getCurrentUrl();
                    String expectedUrl = expectedResult ? pagepaths.loggedinURL : pagepaths.loginURL;
                    return currentUrl.equals(expectedUrl);
                });

                // Check if the URL matches the expected URL
                String currentUrl = driver.getCurrentUrl ();
                if (currentUrl.equals (expectedResult ? pagepaths.loggedinURL : pagepaths.loginURL)) {
                    System.out.println ("Login successful, as expected.");
                } else {
                    Assert.fail ("User is not able to log in as expected.");
                }
            }
            else {
                System.out.println("The current URL is not" + pagepaths.loginURL);
            }
        }
    }

