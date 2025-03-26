package com.LUMA.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.LUMA.browser.Browser;

public class RegistrationPageObjects extends Browser {

    // Constructor to initialize the PageFactory elements
    public RegistrationPageObjects() {
        PageFactory.initElements(driver, this);
    }

    // WebElement for the "First Name" input field
    @FindBy(xpath = "//input[@id='firstname']")
    public WebElement firstNameElement;

    // WebElement for the "Last Name" input field
    @FindBy(xpath = "//input[@id='lastname']")
    public WebElement lastNameElement;

    // WebElement for the "Email Address" input field
    @FindBy(xpath = "//input[@id='email_address']")
    public WebElement emailElement;

    // WebElement for the "Password" input field
    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordElement;

    // WebElement for the "Confirm Password" input field
    @FindBy(xpath = "//input[@id='password-confirmation']")
    public WebElement confirmPasswordElement;

    // WebElement for the "Create an Account" button
    @FindBy(xpath = "//button[@title='Create an Account']")
    public WebElement createAnAccountElement;

    // WebElement for the error message displayed when an invalid email is entered
    @FindBy(xpath = "//div[@id='email_address-error']")
    public WebElement emailErrorElement;
}

