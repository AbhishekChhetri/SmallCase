package com.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ElementsOfWebAmazon {
    public WebDriver driver;


    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    WebElement searchTextBoxAmazon;

    @FindBy(xpath = "(//*[@id=\"search\"]//span[contains(text(),'New Apple iPhone 12 (64GB) - Blue')])[1]")
    WebElement sameItemAsOnFlipkart;

    @FindBy(xpath = "//*[@id=\"priceblock_dealprice\"]")
    WebElement getPriceOfItem;

    @FindBy(xpath = "//input[@id=\"add-to-cart-button\"]")
    WebElement addToCartAmazon;

    @FindBy(xpath = "//*[@id=\"attach-sidesheet-view-cart-button\"]//input[@class='a-button-input']")
    WebElement goToCart;

//    @FindBy(xpath = "//*[@id=\"container\"]//button[2]")
//    WebElement increaseQuantity;

    @FindBy(xpath = "//span[@id=\"sc-subtotal-amount-buybox\"]")
    WebElement getPriceAfterAddingToCart;


    public ElementsOfWebAmazon(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    public void clickCloseLoginScreenBtn1() {
//        closeLoginScreenBtn.click();
//    }

    public void enterInSearchTextBox1Amazon(String s) {
        this.searchTextBoxAmazon.sendKeys(s);
        this.searchTextBoxAmazon.sendKeys(Keys.ENTER);
    }

    public void clickSameItemAsOnFlipkart1() {
        sameItemAsOnFlipkart.click();
    }

    public String getItemPrice1Amazon() {
        String s = getPriceOfItem.getText();
        return s;
    }

    public void clickAddToCart1Amazon() {
        addToCartAmazon.click();
    }

    public void clickOnCartAmazon() {
        goToCart.click();
    }

    public String getPriceAfterAddingToCart1Amazon() {
        String s = getPriceAfterAddingToCart.getText().trim();
        return s;
    }

    public String getParentWindowHandleAmazon() {
        String parent = driver.getWindowHandle();
        return parent;
    }

    public Set getWindowHandles() {
        Set<String> s = driver.getWindowHandles();
        return s;
    }

    public void switchToChildWindowHandle() {
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> I1 = windowHandles.iterator();
        String child_window = "";
        while (I1.hasNext()) {
            child_window = I1.next();
        }
        driver.switchTo().window(child_window);
    }

    public void waitForVisibility(String strXpath) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strXpath)));
    }

    public void applyImplicitWait() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void closeBrowser1() {
        driver.close();
        driver.quit();
    }

}
