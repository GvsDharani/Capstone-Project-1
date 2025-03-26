package com.LUMA.pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.LUMA.browser.Browser;
import com.LUMA.locators.AddToCartObjects;
import com.LUMA.screenShot.Capture;
import com.aventstack.extentreports.Status;

public class AddToCartPage extends Browser {
    static AddToCartObjects obj;

    
//      Method to select a product size
     
    public static void selectSize(String size) throws Exception {
        logger1.log(Status.INFO, "Selection of size");
        try {
            obj = new AddToCartObjects();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfAllElements(obj.sizeOptions));
            
            for (WebElement sizeOption : obj.sizeOptions) {
                if (sizeOption.getText().equalsIgnoreCase(size)) {
                    sizeOption.click();
                    System.out.println("Selected size: " + size);
                    logger1.log(Status.PASS, "Size is selected");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in selectSize: " + e);
            logger1.log(Status.FAIL, "Size is not selected");
        }
    }

//    Method to select a product color
     
    public static void selectColor(String color) {
        logger1.log(Status.INFO, "Selection of color");
        try {
            obj = new AddToCartObjects();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfAllElements(obj.colorOptions));
            
            for (WebElement colorOption : obj.colorOptions) {
                if (colorOption.getDomAttribute("option-label").equalsIgnoreCase(color)) {
                    colorOption.click();
                    System.out.println("Selected color: " + color);
                    logger1.log(Status.PASS, "Color is selected");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in selectColor: " + e);
            logger1.log(Status.FAIL, "Color is not selected");
        }
    }

   
//      Method to enter quantity of the product
     
    public static void enterQuantity(String quantity) {
        logger1.log(Status.INFO, "Selection of Quantity");
        try {
            obj = new AddToCartObjects();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(obj.quantityBox));
            
            obj.quantityBox.clear();
            obj.quantityBox.sendKeys(quantity);
            System.out.println("Entered quantity: " + quantity);
            logger1.log(Status.PASS, "Quantity is selected");
        } catch (Exception e) {
            System.out.println("Exception in enterQuantity: " + e);
            logger1.log(Status.FAIL, "Quantity is not selected");
        }
    }

   
//      Method to click the "Add to Cart" button
    
    public static void clickAddToCart() {
        logger1.log(Status.INFO, "Items should be added to cart");
        try {
            obj = new AddToCartObjects();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(obj.addToCartButton));
            
            obj.addToCartButton.click();
            System.out.println("Clicked on Add to Cart button");
            logger1.log(Status.PASS, "Cart icon is clicked");
        } catch (Exception e) {
            System.out.println("Exception in clickAddToCart: " + e);
            logger1.log(Status.FAIL, "Cart icon is not clicked");
        }
    }

//    Method to get the confirmation message after adding a product to the cart
    
    public static String getCartMessage() {
        logger1.log(Status.INFO, "Visited cart");
        try {
            obj = new AddToCartObjects();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(obj.cartMessage));
            
            String message = obj.cartMessage.getText();
            logger1.addScreenCaptureFromPath(Capture.screenShot("Add to cart"));
            System.out.println("Cart message: " + message);
            logger1.log(Status.PASS, "Items added message displayed");
            return message;
        } catch (Exception e) {
            System.out.println("Exception in getCartMessage: " + e);
            logger1.log(Status.FAIL, "No items are added");
            return null;
        }
    }

    // Method to get the total amount displayed in the cart
   
    public static String getCartAmount() {
        logger1.log(Status.INFO, "Cart Total amount");
        try {
            obj = new AddToCartObjects();
            wait.until(ExpectedConditions.visibilityOf(obj.cartAmountElement));
            
            String message = obj.cartAmountElement.getText();
            logger1.addScreenCaptureFromPath(Capture.screenShot("Cart amount"));
            logger1.log(Status.PASS, "Amount is visible");
            
            System.out.println("Cart Amount: " + message);
            return message;
        } catch (Exception e) {    
            System.out.println("Exception in getCartAmount: " + e);
            logger1.log(Status.FAIL, "Amount is not visible");
            return null;
        }
    }

//     Method to click the cart icon/symbol
     
    public static void clickCartSymbol() {
        logger1.log(Status.INFO, "Clicking Add To Cart Symbol");
        try {
            obj = new AddToCartObjects();
            wait.until(ExpectedConditions.elementToBeClickable(obj.cartSymbolElement));
            
            obj.cartSymbolElement.click();
            System.out.println("Clicked on Add to Cart Symbol");
            logger1.log(Status.PASS, "Cart Symbol clicked successfully");
        } catch (Exception e) {
            logger1.log(Status.FAIL, "Clicking cart symbol failed");
            System.out.println("Exception in clickCartSymbol: " + e);
        }
    }
}

