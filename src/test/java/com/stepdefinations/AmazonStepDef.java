package com.stepdefinations;

import com.page.Amazon;
import com.page.Flipkart;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class AmazonStepDef {
    public static WebDriver driver;
    Amazon amazon;


    @And("^user is on amazon homepage$")
    public void user_is_on_amazon_homepage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\10651361\\Downloads\\Chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        amazon = new Amazon(driver);
        String baseUrl = "https://www.amazon.in/";
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


//    @When("^Search for any item in Amazon$")
//    public void enterSearchItemName() throws Throwable {
//      amazon = new Amazon(driver);
//        Assert.assertTrue(amazon.enterSearchItemNameInAmazon());
//    }

    @When("^Search for \"([^\"]*)\" any item in Amazon$")
    public void enterSearchItemName(String s) throws Throwable {
        amazon = new Amazon(driver);
        Assert.assertTrue(amazon.enterSearchItemNameInAmazon(s));
    }


    @And("^Click on the same item as on Flipkart in the list$")
    public void clickFirstItem() throws Throwable{
         amazon = new Amazon(driver);
        Assert.assertTrue(amazon.clickSameItemAsOnFlipkart());
    }

    @And("^Print Price of the Item from Amazon$")
    public void getFirstItemPrice() throws Throwable {
         amazon = new Amazon(driver);
        Assert.assertTrue(amazon.getItemPriceAmazon());
    }

    @Then("^Add to cart in guest mode in Amazon$")
    public void clickAddToCart() throws Throwable{
         amazon = new Amazon(driver);
        Assert.assertTrue(amazon.clickAddToCartInAmazon());
        Assert.assertTrue(amazon.goToCartInAmazon());
    }


    @And("^Print the Price after addition of item in cart$")
    public void getPriceAfterIncreasingQuantity() throws Throwable{
         amazon = new Amazon(driver);
        Assert.assertTrue(amazon.getPriceAfterAddingToCartAmazon());
    }

    @And("^Compare price of same product in both site$")
    public void comparePrice() throws Throwable{
        amazon = new Amazon(driver);
        Assert.assertTrue(amazon.comparePrice());
        Assert.assertTrue(amazon.closeBrowser());
    }


}