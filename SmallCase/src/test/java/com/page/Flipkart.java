package com.page;

import com.elements.ElementsOfWebFlipkart;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Flipkart extends ElementsOfWebFlipkart {

    static String priceAfterIncreasingQuantity;
    static String priceBeforeIncreasingQuantity;
    public Flipkart(WebDriver driver) {
        super(driver);
    }


    public boolean clickCloseLoginScreenBtn(){
        try {
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_ESCAPE);
            r.keyRelease(KeyEvent.VK_ESCAPE);
            return true;
        }catch (Exception e){
            System.out.println("Not visible");
            return false;
        }
    }

    public boolean enterSearchItemName(String s) {
        try {
            super.waitForVisibility("//input[@name ='q' and @type='text']");
            super.enterInSearchTextBox1(s);
            return true;
        }catch (Exception e){
            System.out.println("Unable to search");
            return false;
        }
    }

    public boolean clickFirstItem() {
        try {
            super.waitForVisibility("//*[@id=\"container\"]//div[contains(text(),'APPLE iPhone 12 (Blue, 64 GB)')]");
            super.clickFirstItem1();
            super.applyImplicitWait();
            return true;
        }catch (Exception e){
            System.out.println("Unable to click on First Item");
            return false;
        }
    }

    public boolean getFirstItemPrice(){
        try {
            super.applyImplicitWait();
            super.switchToChildWindowHandle();
            String firstItemPrice = super.getFirstItemPrice1();
            System.out.println("firstItemPrice: "+ firstItemPrice);
            return true;
        }catch (Exception e){
            System.out.println("Unable to fetch firstItemPrice");
            return false;
        }
    }

    public boolean switchToChildWindow(){
        try {
            super.applyImplicitWait();
            super.switchToChildWindowHandle();
            return true;
        }catch (Exception e){
            System.out.println("Unable to fetch firstItemPrice");
            return false;
        }
    }


    public boolean clickAddToCart() {
        try {
            super.waitForVisibility("//div[@id=\"container\"]//child::li[1]//button[text()='ADD TO CART']");
            super.clickAddToCart1();
            return true;
        }catch (Exception e){
            System.out.println("Unable to click on AddToCart1");
            return false;
        }
    }

    public boolean getPriceBeforeIncreasingQuantity(){
        try {
            super.switchToChildWindowHandle();
            super.waitForVisibility("//*[@id=\"container\"]//descendant::div[11]//span[1]//descendant::div[1]//span[1]");
            priceBeforeIncreasingQuantity = super.getPriceAfterIncreasingQuantity1().replace("₹","");
            System.out.println("Price in Flipkart after adding item to cart: "+ priceBeforeIncreasingQuantity);
            return true;
        }catch (Exception e){
            System.out.println("Unable to Increase Quantity");
            return false;
        }
    }

    public boolean navigateToUrl(String url){
        try {
            super.navigateTo(url);
            super.applyImplicitWait();
            return true;
        }catch (Exception e){
            System.out.println("Unable to Navigate to different Url");
            return false;
        }
    }

    public boolean clickIncreaseQuantity(){
        try {
            super.applyImplicitWait();
            super.switchToChildWindowHandle();
            super.clickIncreaseQuantity1();
            return true;
        }catch (Exception e){
            System.out.println("Unable to Increase Quantity");
            return false;
        }
    }

    public boolean getPriceAfterIncreasingQuantity() {
        try {
            Thread.sleep(2000);
            priceAfterIncreasingQuantity = super.getPriceAfterIncreasingQuantity1();
            System.out.println("PriceAfterIncreasingQuantity: "+ priceAfterIncreasingQuantity);
            return true;
        }catch (Exception e){
            System.out.println("Unable to get the Price After Increasing Quantity");
            return false;
        }
    }

    public boolean closeBrowser(){
        try {
            super.closeBrowser1();
            return true;
        }catch (Exception e){
            System.out.println("Unable to close browser");
            return false;
        }
    }




}




