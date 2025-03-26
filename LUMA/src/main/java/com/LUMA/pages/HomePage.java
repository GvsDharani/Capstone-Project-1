package com.LUMA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.LUMA.browser.Browser;
import com.LUMA.locators.HomePageObjects;
import com.LUMA.screenShot.Capture;
import com.aventstack.extentreports.Status;

import java.time.Duration;
import java.util.List;

public class HomePage extends Browser {

    static HomePageObjects obj;
    
//      Method to click on the "Sign In" link
    
    public static void clickOnSignIn() throws Exception {
        logger1.addScreenCaptureFromPath(Capture.screenShot("Click on signin"));
        try {
            obj = new HomePageObjects();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(obj.signinLink));
            obj.signinLink.click();
            System.out.println("Clicked on Sign In link");
            logger1.log(Status.PASS, "Signin is clicked");
        } catch (Exception e) {
            System.out.println("Exception in clickOnSignIn method: " + e);
            logger1.log(Status.FAIL, "Signin is not clicked");
        }
    }
//     Method to click on the "Create New Account" link
     
    public static void clickOnCreateNewAccount() {
        try {
            obj = new HomePageObjects();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(obj.createNewAccountLink));
            obj.createNewAccountLink.click();
            System.out.println("Clicked on Create New Account link");
            logger1.log(Status.PASS, "Create new account is clicked");
        } catch (Exception e) {
            System.out.println("Exception in clickOnCreateNewAccount method: " + e);
            logger1.log(Status.FAIL, "Did not click create new account");
        }
    }

//     Method to get the homepage title text
    
    public static String getHomePageText() {
        try {
            obj = new HomePageObjects();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(obj.homepageText));
            String text = obj.homepageText.getText();
            System.out.println("Homepage text: " + text);
            logger1.log(Status.PASS, "Homepage is seen");
            return text;
        } catch (Exception e) {
            System.out.println("Exception in getHomePageText method: " + e);
            logger1.log(Status.FAIL, "Homepage is not seen");
            return null;
        }
    }
//     Method to click on the shopping cart icon

    public static void clickCartIcon() {
        logger1.log(Status.INFO, "Clicking on cart icon");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header/div[2]/div[1]/a/span[2]/span[1]")));
            obj.cartIcon.click();
            logger1.log(Status.PASS, "Clicked on Cart icon");
        } catch (Exception e) {
            System.out.println("Exception in clickCartIcon method: " + e);
            logger1.log(Status.FAIL, "Failed clicking on Cart icon");
        }
        extent.flush();
    }

    
//     Method to check if the total price is displayed in the cart
     
    public static boolean totalprice() {
        logger1 = extent.createTest("Verify total price displayed or not");
        logger1.log(Status.INFO, "Verify Total Price");
        try {
            wait.until(ExpectedConditions.visibilityOf(obj.totalPrice));
            logger1.log(Status.PASS, "Verified Total Price Displayed");
        } catch (Exception e) {
            System.out.println("Exception in totalprice method: " + e);
            logger1.log(Status.FAIL, "Failed Verifying Total Price");
        }
        return obj.totalPrice.isDisplayed();
    }

//      Method for dynamically deleting items from the cart
     
    public static void deleteingCartData() {
        obj = new HomePageObjects();
        if (js == null) {
            js = (JavascriptExecutor) driver; // Ensure JavaScript executor is initialized
        }

        logger1.log(Status.INFO, "Dynamically deleting products from cart");
        try {  
            // If the cart is empty, exit the method
            if (obj.counterElement.isEmpty()) {
                return;
            }

            // Click on the cart icon to open the cart
            wait.until(ExpectedConditions.elementToBeClickable(obj.counterElement.getFirst()));
            obj.cartIcon.click();

            // Loop to remove each item from the cart
            while (true) {
                List<WebElement> cartItems = obj.cartList;
                if (cartItems.isEmpty()) {
                    break;
                }

                // Get the first item and click on remove
                WebElement firstItem = cartItems.get(0);
                wait.until(ExpectedConditions.visibilityOf(firstItem));
                js.executeScript("arguments[0].click()", firstItem);

                // Click on confirmation popup accept button
                wait.until(ExpectedConditions.elementToBeClickable(obj.popUpAcceptElement));
                js.executeScript("arguments[0].click()", obj.popUpAcceptElement);

                // If only one item is left, close the cart after deleting
                if (cartItems.size() == 1) {
                    wait.until(ExpectedConditions.elementToBeClickable(obj.closingButtonElement));
                    js.executeScript("arguments[0].click()", obj.closingButtonElement);
                    break;
                }

                // Wait until the deleted item disappears
                wait.until(ExpectedConditions.stalenessOf(firstItem));
            }
            logger1.log(Status.PASS, "Successfully deleted the products from cart");

        } catch (Exception e) {
            logger1.log(Status.FAIL, "Error in deleting products from cart: " + e);
            System.out.println("Exception in deleteingCartData method: " + e);
        }
    }
}

