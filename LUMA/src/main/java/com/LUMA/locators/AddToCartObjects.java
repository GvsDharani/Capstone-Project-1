package com.LUMA.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.LUMA.browser.Browser;
import java.util.List;

public class AddToCartObjects extends Browser {

    // Constructor to initialize web elements using PageFactory
    public AddToCartObjects() {
        PageFactory.initElements(driver, this);
    }

    // List of size options available on the product page
    @FindBy(xpath = "//div[@attribute-code='size']/div/div")
    public List<WebElement> sizeOptions;

    // List of color options available on the product page
    @FindBy(xpath = "//div[contains(@class, 'swatch-option color')]")
    public List<WebElement> colorOptions;

    // Quantity input box to set the number of items to be added to the cart
    @FindBy(id = "qty")
    public WebElement quantityBox;

    // Button to add the selected product to the shopping cart
    @FindBy(id = "product-addtocart-button")
    public WebElement addToCartButton;

    // Element to capture success message after adding an item to the cart
    @FindBy(css = ".message-success")
    public WebElement cartMessage;

    // Element displaying the total amount in the cart
    @FindBy(xpath = "//span[@class='price']")
    public WebElement cartAmountElement;
    
    // Element representing the cart icon/symbol on the page
    @FindBy(xpath = "//a[@class='action showcart']")
    public WebElement cartSymbolElement;
}

