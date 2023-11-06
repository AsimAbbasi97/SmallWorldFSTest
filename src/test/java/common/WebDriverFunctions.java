package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class WebDriverFunctions {

    public static WebDriver initializeWebDriver() throws IOException {
        //change chrome option with another browser to execute it in another browser
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "D:\\Chrome Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com");

//        if(driver==null){
//            try {
//                Assert.assertNotNull(driver,"Driver doesn't initialized successfully");
//            }catch (AssertionError assertionError){
//                throw assertionError;
//            }
//        }
        try{
            driver.manage().window().maximize();
        }catch (WebDriverException webDriverException){
            throw webDriverException;
        }

        return driver;
    }
    public static void quitWebDriver(WebDriver driver){
        driver.quit();
    }

}