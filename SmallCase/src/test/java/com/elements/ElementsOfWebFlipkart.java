package com.elements;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ElementsOfWebFlipkart {
    public WebDriver driver;

    @FindBy(xpath = "//following::div[@tabindex='-1']//child::div[1]/button[1]")
    WebElement closeLoginScreenBtn;

    @FindBy(xpath = "//input[@name ='q' and @type='text']")
    WebElement searchTextBox;

    @FindBy(xpath = "//*[@id=\"container\"]//div[contains(text(),'APPLE iPhone 12 (Blue, 64 GB)')]")
    WebElement firstItem;

    @FindBy(xpath = "//div[@class='aMaAEs']//descendant::div[10]")
    WebElement getFirstItemPrice;

    @FindBy(xpath = "//div[@id=\"container\"]//child::li[1]//button[text()='ADD TO CART']")
    WebElement addToCart;

    @FindBy(xpath = "//*[@id=\"container\"]//button[2]")
    WebElement increaseQuantity;

    @FindBy(xpath = "//*[@id=\"container\"]//descendant::div[11]//span[1]//descendant::div[1]//span[1]")
    WebElement getPriceAfterIncreasingQuantity;


    public ElementsOfWebFlipkart(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickCloseLoginScreenBtn1(){
                closeLoginScreenBtn.click();
    }

    public void enterInSearchTextBox1(String s){
        this.searchTextBox.sendKeys(s);
        this.searchTextBox.sendKeys(Keys.ENTER);
    }

    public void clickFirstItem1(){
        firstItem.click();
    }

    public String getFirstItemPrice1(){
        String s = getFirstItemPrice.getText();
        return s;
    }

    public void clickAddToCart1(){
        addToCart.click();
    }

    public void clickIncreaseQuantity1(){
        increaseQuantity.click();
    }

    public String getPriceAfterIncreasingQuantity1(){
        String s = getPriceAfterIncreasingQuantity.getText();
        return s;
    }

    public String getParentWindowHandle(){
        String parent=driver.getWindowHandle();
        return parent;
    }

    public void navigateTo(String url){
        driver.navigate().to(url);
    }

    public Set getWindowHandles() {
        Set<String> s = driver.getWindowHandles();
        return s;
    }

    public void switchToChildWindowHandle() {
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> I1= windowHandles.iterator();
        String child_window = "";
        while(I1.hasNext())
        {
            child_window=I1.next();
        }
        driver.switchTo().window(child_window);
    }

    public void waitForVisibility(String strXpath){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strXpath)));
    }

    public void applyImplicitWait(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void closeBrowser1(){
        driver.close();
        driver.quit();
    }

}
