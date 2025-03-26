package com.LUMA.pages;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.LUMA.browser.Browser;
import com.LUMA.locators.LogoutObjects;
import com.LUMA.screenShot.Capture;

public class LogoutPage extends Browser {

    public static LogoutObjects obj;

    
//     Method to log out from the application
    public static void logout() throws Exception {
        // Capturing a screenshot before logout action
        logger1.addScreenCaptureFromPath(Capture.screenShot("Logout"));
        try {
            obj = new LogoutObjects();
            Actions actions = new Actions(driver);

            // Wait for the account dropdown to be visible and click on it
            wait.until(ExpectedConditions.visibilityOf(obj.accountDropdownElement));
            actions.moveToElement(obj.accountDropdownElement).click().perform();
            System.out.println("Clicked on account dropdown");

            // Wait for the logout option to be visible and click on it
            wait.until(ExpectedConditions.visibilityOf(obj.logoutElement));
            actions.moveToElement(obj.logoutElement).click().perform();
            System.out.println("Clicked on logout");

        } catch (Exception e) {
            System.out.println("Exception in logout method: " + e);
        }
    }
}

