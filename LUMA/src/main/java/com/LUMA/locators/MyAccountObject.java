package com.LUMA.locators;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.LUMA.browser.Browser;

public class MyAccountObject extends Browser {

    // Constructor to initialize the PageFactory elements
    public MyAccountObject() {
        PageFactory.initElements(driver, this);
    }

    // WebElement representing the "My Account" page title text
    @FindBy(xpath = "//span[@class='base']")
    public WebElement myAccountTextElement;

    // WebElement for the search box where users can enter search queries
    @FindBy(xpath = "//input[@id='search']")
    public WebElement searchBoxElement;

    // List of WebElements representing the dropdown suggestions from the search box
    @FindBy(xpath = "//ul[@role='listbox']/li/span[1]")
    public List<WebElement> searchList;

    // WebElement for displaying messages related to registration (e.g., success or error messages)
    @FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
    public WebElement RegistrationTextElement;
}

