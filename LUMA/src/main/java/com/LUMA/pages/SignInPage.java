package com.LUMA.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

import com.LUMA.browser.Browser;
import com.LUMA.locators.SignInObjects;
import com.LUMA.screenShot.Capture;
import com.aventstack.extentreports.Status;

public class SignInPage extends Browser {

    static SignInObjects obj;

//    Method to enter an invalid email in the email field
  
    public static void enterInvalidEmail(String email) throws Exception {
        logger1.addScreenCaptureFromPath(Capture.screenShot("SignIn"));
        obj = new SignInObjects();
        try {
            // Wait until the email field is visible and then enter the invalid email
            wait.until(ExpectedConditions.visibilityOf(obj.emailElement));
            obj.emailElement.clear();
            obj.emailElement.sendKeys(email);
            logger1.log(Status.PASS, "Invalid email is given");
        } catch (Exception e) {
            System.out.println("Exception in enterInvalidEmail method: " + e);
        }
    }

//   Method to enter an invalid password in the password field
    
    public static void enterInvalidPassword(String password) {
        try {
            // Wait until the password field is visible and then enter the invalid password
            wait.until(ExpectedConditions.visibilityOf(obj.passwordElement));
            obj.passwordElement.clear();
            obj.passwordElement.sendKeys(password);
            logger1.log(Status.PASS, "Invalid password is given");
        } catch (Exception e) {
            System.out.println("Exception in enterInvalidPassword method: " + e);
        }
    }

//     Method to enter valid credentials (email and password) in the sign-in form
  
    public static void enterValidCredentials(String email, String password) {
        obj = new SignInObjects();
        try {
            // Wait until the email field is visible and then enter the email
            wait.until(ExpectedConditions.visibilityOf(obj.emailElement));
            obj.emailElement.clear();
            obj.emailElement.sendKeys(email);

            // Wait until the password field is visible and then enter the password
            wait.until(ExpectedConditions.visibilityOf(obj.passwordElement));
            obj.passwordElement.clear();
            obj.passwordElement.sendKeys(password);
            
            logger1.log(Status.PASS, "Valid credentials are given");
        } catch (Exception e) {
            System.out.println("Exception in enterValidCredentials method: " + e);
        }
    }

//   Method to click the "Sign In" button
    
    public static void clickSignIn() {
        try {
            // Wait until the Sign In button is clickable and then click on it
            wait.until(ExpectedConditions.elementToBeClickable(obj.signInElement));
            obj.signInElement.click();
            logger1.log(Status.PASS, "Sign In button is clicked");
        } catch (Exception e) {
            System.out.println("Exception in clickSignIn method: " + e);
            logger1.log(Status.FAIL, "Could not click Sign In button");
        }
    }

//    Method to get the error message displayed after entering invalid credentials
     
    public static String getErrorMessage() {
        String errorMessage = null;
        try {
            // Wait until the error message element is visible and then fetch the message
            wait.until(ExpectedConditions.visibilityOf(obj.errorElement));
            errorMessage = obj.errorElement.getText();
            logger1.log(Status.PASS, "Error message is displayed");
        } catch (Exception e) {
            System.out.println("Exception in getErrorMessage method: " + e);
            logger1.log(Status.FAIL, "Could not see any error message");
        }
        return errorMessage;
    }
}

