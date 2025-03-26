package com.LUMA.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.LUMA.browser.Browser;
import com.LUMA.locators.RegistrationPageObjects;
import com.LUMA.screenShot.Capture;
import com.aventstack.extentreports.Status;

public class RegistrationPage extends Browser {

    // Object reference for RegistrationPageObjects
    static RegistrationPageObjects obj;

//  Method to enter the first name in the registration form

    public static void enterFirstName(String firstName) throws Exception {
        logger1.addScreenCaptureFromPath(Capture.screenShot("Register"));
        logger1.log(Status.INFO, "Details are entered");
        try {
            obj = new RegistrationPageObjects();
            wait.until(ExpectedConditions.visibilityOf(obj.firstNameElement));
            obj.firstNameElement.sendKeys(firstName);
            System.out.println("Entered First Name: " + firstName);
            logger1.log(Status.PASS, "First name is entered");
        } catch (Exception e) {
            System.out.println("Exception in enterFirstName method: " + e);
            logger1.log(Status.FAIL, "Could not enter first name");
        }
    }

//    Method to enter the last name in the registration form
 
    public static void enterLastName(String lastName) {
        try {
            wait.until(ExpectedConditions.visibilityOf(obj.lastNameElement));
            obj.lastNameElement.sendKeys(lastName);
            System.out.println("Entered Last Name: " + lastName);
            logger1.log(Status.PASS, "Last name is given");
        } catch (Exception e) {
            System.out.println("Exception in enterLastName method: " + e);
            logger1.log(Status.FAIL, "Could not enter last name");
        }
    }

//  Method to enter the email address in the registration form
   
    public static void enterEmail(String str) {
        try {
            wait.until(ExpectedConditions.visibilityOf(obj.emailElement));
            obj.emailElement.clear();
            obj.emailElement.sendKeys(str);
            System.out.println("Entered Email: " + str);
            logger1.log(Status.PASS, "Email is given");
        } catch (Exception e) {
            System.out.println("Exception in enterEmail method: " + e);
            logger1.log(Status.FAIL, "Email is not given");
        }
    }

//  Method to enter the password in the registration form
 
    public static void enterPassword(String password) {
        try {
            wait.until(ExpectedConditions.visibilityOf(obj.passwordElement));
            obj.passwordElement.sendKeys(password);
            System.out.println("Entered Password");
            logger1.log(Status.PASS, "Password is entered");
        } catch (Exception e) {
            System.out.println("Exception in enterPassword method: " + e);
            logger1.log(Status.FAIL, "Password is not entered");
        }
    }

//   Method to enter the confirmation password in the registration form
  
    public static void enterConfirmPassword(String confirmPassword) {
        try {
            wait.until(ExpectedConditions.visibilityOf(obj.confirmPasswordElement));
            obj.confirmPasswordElement.sendKeys(confirmPassword);
            System.out.println("Entered Confirm Password");
            logger1.log(Status.PASS, "Confirm Password entered");
        } catch (Exception e) {
            System.out.println("Exception in enterConfirmPassword method: " + e);
            logger1.log(Status.FAIL, "Could not enter confirm password");
        }
    }

//     Method to click the "Create an Account" button in the registration form
   
    public static void clickCreateAnAccount() throws Exception {
        logger1.addScreenCaptureFromPath(Capture.screenShot("Click"));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(obj.createAnAccountElement));
            obj.createAnAccountElement.click();
            System.out.println("Clicked Create an Account");
            logger1.log(Status.PASS, "Create account button clicked");
        } catch (Exception e) {
            System.out.println("Exception in clickCreateAnAccount method: " + e);
            logger1.log(Status.FAIL, "Could not click create account button");
        }
    }

//  Method to get the error message displayed for an invalid email
  
    public static String emailErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOf(obj.emailErrorElement));
            String message = obj.emailErrorElement.getText();
            System.out.println("Email Error Message: " + message);
            logger1.log(Status.PASS, "Error message displayed");
            return message;
        } catch (Exception e) {
            System.out.println("Exception in emailErrorMessage method: " + e);
            logger1.log(Status.FAIL, "Could not see the email error message");
            return null;
        }
    }
}

