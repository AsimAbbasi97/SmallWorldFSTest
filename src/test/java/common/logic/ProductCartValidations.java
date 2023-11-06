package common.logic;

import common.elements.productelements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class ProductCartValidations {

     public static void cartvalidation(WebDriver driver) {

            // Find and click on a product (customize the product element, e.g., by its name or image)
            WebElement product = driver.findElement(By.xpath(productelements.addToCartFirstProduct)); // Example: Click the first product
            String productName = product.getText(); // Get the product name
            product.click();

         // Use WebDriverWait to wait for the cart count to update to "1"
         WebDriverWait wait = new WebDriverWait(driver, 10);
         By cartIconLocator = By.xpath (productelements.carticon);

         // Wait for the cart icon to update to "1" and assert it
         Assert.assertTrue(wait.until(ExpectedConditions.textToBePresentInElementLocated(cartIconLocator, "1")), "Cart count did not update to 1.");

        }

    public static boolean isProductAddedToCart(WebDriver driver) {
        WebElement product = driver.findElement(By.xpath(productelements.addToCartFirstProduct)); // Example: Click the first product
        String selectedproductName = product.getText(); // Get the product name\

        // Navigate to the cart page (customize the cart page URL)
        WebElement cart = driver.findElement(By.xpath(productelements.addToCartFirstProduct)); // Example: Click the first product
        cart.click();

        // Find all product elements in the cart
        List<WebElement> cartProducts = driver.findElements(By.xpath("//div[@class='cart-product']"));

        for (WebElement cartProduct : cartProducts) {
            if (cartProduct.getText().equals(selectedproductName)) {
                return true; // Product found in the cart
            }
        }

        return false; // Product not found in the cart
    }

}

