package common.helper;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

public class FindElement {
    public static WebElement element = null;
    static boolean exist = false;
    private static Select select = null;

    public static WebElement id(WebDriver driver, String ID){
        element = driver.findElement(By.id(ID));
        return element;
    }
    public static WebElement xpath(WebDriver driver, String xPath){
        element = driver.findElement(By.xpath(xPath));
        System.out.println(element.getTagName());
        return element;
    }
    public static WebElement cssSelector(WebDriver driver, String css_Selector){
        element = driver.findElement(By.cssSelector(css_Selector));
        return element;
    }
    public static Select dropDown(WebDriver driver, String xPath){
        select = new Select(driver.findElement(By.xpath(xPath)));
        return select;
    }
    public static WebElement xpathExistold(WebDriver driver, String xPath) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10); // Adjust the timeout as needed
            return wait.until(d -> d.findElement(By.xpath(xPath)));
        } catch (org.openqa.selenium.TimeoutException e) {
            return null; // Element does not exist
        }
    }
    public static boolean xpathExist(WebDriver driver, String xPath) {
        try {
            driver.findElement(By.xpath(xPath));
            return true; // Element exists
        } catch (NoSuchElementException e) {
            return false; // Element does not exist
        }
    }

    public static WebElement waitVisibilityOfXPath(WebDriver driver, String xPath, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until((Function<? super WebDriver, WebElement>) ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xPath))));
    }
}
