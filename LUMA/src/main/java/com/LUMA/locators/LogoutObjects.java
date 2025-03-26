package com.LUMA.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.LUMA.browser.Browser;

public class LogoutObjects extends Browser {

    // Constructor to initialize the PageFactory elements
    public LogoutObjects() {
        PageFactory.initElements(driver, this);
    }

    // WebElement for the account dropdown menu in the header panel
    @FindBy(xpath = "//div[@class='panel header']//button[@type='button']")
    public WebElement accountDropdownElement;

    // WebElement for the "Sign Out" link inside the account dropdown
    @FindBy(xpath = "//a[contains(text(),'Sign Out')]")
    public WebElement logoutElement;
}

