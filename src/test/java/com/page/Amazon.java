package com.page;

import com.elements.ElementsOfWebAmazon;
import com.elements.ElementsOfWebFlipkart;
import org.openqa.selenium.WebDriver;


public class Amazon extends ElementsOfWebAmazon {

    static String getPriceAfterAddingToCartAmazon;

    public Amazon(WebDriver driver) {
        super(driver);
    }


    public boolean enterSearchItemNameInAmazon(String s) {
        try {
            super.enterInSearchTextBox1Amazon(s);
            return true;
        }catch (Exception e){
            System.out.println("Unable to search");
            return false;
        }
    }

    public boolean clickSameItemAsOnFlipkart() {
        try {
            super.waitForVisibility("(//*[@id=\"search\"]//span[contains(text(),'New Apple iPhone 12 (64GB) - Blue')])[1]");
            super.clickSameItemAsOnFlipkart1();
            return true;
        }catch (Exception e){
            System.out.println("Unable to click on Same Item");
            return false;
        }
    }

    public boolean getItemPriceAmazon(){
        try {
            super.applyImplicitWait();
            super.switchToChildWindowHandle();
            String getItemPrice1Amazon = super.getItemPrice1Amazon();
            System.out.println("Price of item in Amazon Before Adding to Cart: "+ getItemPrice1Amazon);
            return true;
        }catch (Exception e){
            System.out.println("Unable to fetch firstItemPrice");
            return false;
        }
    }

    public boolean clickAddToCartInAmazon() {
        try {
            super.clickAddToCart1Amazon();
            return true;
        }catch (Exception e){
            System.out.println("Unable to click on AddToCart1");
            return false;
        }
    }

    public boolean goToCartInAmazon(){
        try {
            super.waitForVisibility("//*[@id=\"attach-sidesheet-view-cart-button\"]//input[@class='a-button-input']");
            super.clickOnCartAmazon();
            return true;
        }catch (Exception e){
            System.out.println("Unable to Increase Quantity");
            return false;
        }
    }

    public boolean getPriceAfterAddingToCartAmazon() {
        try {
            super.waitForVisibility("//span[@id=\"sc-subtotal-amount-buybox\"]");
            getPriceAfterAddingToCartAmazon = super.getPriceAfterAddingToCart1Amazon().replace(",","");
            System.out.println("Price in Amazon After Adding to Cart: "+ getPriceAfterAddingToCartAmazon);
            return true;
        }catch (Exception e){
            System.out.println("Unable to get the Price After Adding To Cart in Amazon");
            return false;
        }
    }

    public boolean comparePrice() {
        try {
            int priceInAmazon = Integer.parseInt(getPriceAfterAddingToCartAmazon.substring(0,getPriceAfterAddingToCartAmazon.length()-3).trim());
            int priceInFlipkart = Integer.parseInt(Flipkart.priceBeforeIncreasingQuantity.replace(",","").trim());
            if(priceInAmazon>priceInFlipkart) {
                System.out.println("Price in amazon: " + priceInAmazon + "\nPrice In Flipkart: " + priceInFlipkart
                + "\nPrice in Amazon is more than Price in Flipkart");
            }else if(priceInAmazon<priceInFlipkart) {
                System.out.println("Price in amazon: " + priceInAmazon + "\nPrice In Flipkart: " + priceInFlipkart
                        + "\nPrice in Flipkart is more than Price in Amazon");
            }else {
                System.out.println("Price in amazon: " + priceInAmazon + "\nPrice In Flipkart: " + priceInFlipkart
                        + "\nPrice in Flipkart and Amazon is same");
            }

            return true;
        }catch (Exception e){
            int priceInAmazon = Integer.parseInt(getPriceAfterAddingToCartAmazon.substring(0,getPriceAfterAddingToCartAmazon.length()-3).trim());
            int priceInFlipkart = Integer.parseInt(Flipkart.priceBeforeIncreasingQuantity.replace(",","").trim());
            System.out.println("priceInAmazon: "+priceInAmazon);
            System.out.println("priceInFlipkart: "+ priceInFlipkart);
            System.out.println("Unable to Compare Price");
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




