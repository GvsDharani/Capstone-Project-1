package com.LUMA.locators;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.LUMA.browser.Browser;

public class HomePageObjects extends Browser {

    // Constructor to initialize web elements using PageFactory
    public HomePageObjects() {
        PageFactory.initElements(driver, this);
    }

    // WebElement for 'Sign In' link in the header panel
    @FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
    public WebElement signinLink;

    // WebElement for 'Create New Account' link in the header panel
    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[3]/a")
    public WebElement createNewAccountLink;

    // WebElement for homepage text (e.g., page title or welcome text)
    @FindBy(xpath = "//span[@class='base']")
    public WebElement homepageText;
    
    // WebElement for the shopping cart icon
    @FindBy(xpath="//a[@class='action showcart']")
    public WebElement cartIcon;
    
    // WebElement for displaying the total price of items in the cart
    @FindBy(xpath="//div[2]/div[2]/div/span/span")
    public WebElement totalPrice;

    // List of WebElements representing all items in the cart
    @FindBy(xpath = "//a[@title='Remove item'] ")
    public List<WebElement> cartList;
    
    // WebElement for the confirmation pop-up 'Accept' button after removing an item from the cart
    @FindBy(xpath = "//button[@class='action-primary action-accept'] ")
    public WebElement popUpAcceptElement;
    
    // List of WebElements for the counter that shows the number of items in the cart
    @FindBy(xpath="//span[@class='counter qty'] /span[@class='counter-number']  ")
    public List<WebElement> counterElement;
    
    // WebElement for the 'Proceed to Checkout' button in the cart dropdown
    @FindBy(xpath="//button[@id='top-cart-btn-checkout'] ")
    public WebElement proceedToCartElement;
    
    // WebElement for the 'Close' button to close the cart dropdown or pop-ups
    @FindBy(xpath="//button[@data-action='close'] ")
    public WebElement closingButtonElement;
}

