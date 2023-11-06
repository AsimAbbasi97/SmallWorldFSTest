package Flows;


import common.logic.ProductCartValidations;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductCartFlows {
    public static WebDriver driver;

    @BeforeClass(dependsOnGroups = "PreRequisiteTestCases", description = "This class will only execute when cases related to login will pass from PreReq class")
    @Test(priority = 1)
    public void checkproducttocart(){
        ProductCartValidations.cartvalidation (driver);
    }
    @Test(priority = 2)
    public void checkaddedproductname(){
        ProductCartValidations.isProductAddedToCart (driver);
    }
}
