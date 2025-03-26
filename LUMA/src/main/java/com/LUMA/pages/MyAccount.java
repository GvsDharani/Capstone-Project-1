package com.LUMA.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.LUMA.browser.Browser;
import com.LUMA.locators.MyAccountObject;
import com.LUMA.screenShot.Capture;

public class MyAccount extends Browser {

    static MyAccountObject obj;

//    Method to get the registration confirmation message
    public static String getRegistrationText() throws Exception {
        String text = null;
        try {
            obj = new MyAccountObject();
            wait.until(ExpectedConditions.visibilityOf(obj.RegistrationTextElement));

            // Capture screenshot of the registration confirmation text
            logger1.addScreenCaptureFromPath(Capture.screenShot("RegistrationText"));

            // Get the text displayed on the registration success message
            text = obj.RegistrationTextElement.getText();
        } catch (Exception e) {
            System.out.println("Exception in getRegistrationText: " + e.getMessage());
        }
        return text;
    }

// Method to get the "My Account" page title text
    public static String getMyAccountText() {
        String text = null;
        try {
            obj = new MyAccountObject();
            wait.until(ExpectedConditions.visibilityOf(obj.myAccountTextElement));

            // Get the text displayed on the "My Account" page
            text = obj.myAccountTextElement.getText();
        } catch (Exception e) {
            System.out.println("Exception in getMyAccountText: " + e.getMessage());
        }
        return text;
    }

//  Method to enter a search query in the search box
    public static void enterSearchQuery(String searchQuery) {
        try {
            obj = new MyAccountObject();

            // Wait for the search box to be visible
            wait.until(ExpectedConditions.visibilityOf(obj.searchBoxElement));

            // Clear the search box before entering a new query
            obj.searchBoxElement.clear();
            obj.searchBoxElement.sendKeys(searchQuery);
            System.out.println("Entered search query: " + searchQuery);
        } catch (Exception e) {
            System.out.println("Exception in enterSearchQuery: " + e.getMessage());
        }
    }

//     Method to select a suggestion from the search dropdown
    
    public static void selectSuggestion(String suggestion) {
        try {
            // Wait for the list of search suggestions to be visible
            wait.until(ExpectedConditions.visibilityOfAllElements(obj.searchList));

            // Loop through all available suggestions
            for (WebElement e : obj.searchList) {
                System.out.println(e.getText());

                // Click on the suggestion if it matches the input
                if (e.getText().contains(suggestion)) {
                    logger1.addScreenCaptureFromPath(Capture.screenShot("suggestion"));
                    e.click();
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in selectSuggestion: " + e.getMessage());
        }
    }
}

