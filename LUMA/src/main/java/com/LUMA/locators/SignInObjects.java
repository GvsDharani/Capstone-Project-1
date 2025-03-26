package com.LUMA.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.LUMA.browser.Browser;

public class SignInObjects extends Browser {

    // Constructor to initialize the PageFactory elements
    public SignInObjects() {
        PageFactory.initElements(driver, this);
    }

    // WebElement for the "Email" input field in the sign-in form
    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailElement;

    // WebElement for the "Password" input field in the sign-in form
    @FindBy(xpath = "//fieldset[@class='fieldset login']//input[@id='pass']")
    public WebElement passwordElement;

    // WebElement for the "Sign In" button in the login form
    @FindBy(xpath = "//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]")
    public WebElement signInElement;

    // WebElement for capturing and displaying login error messages
    @FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
    public WebElement errorElement;
}

