package com.stepdefinations;

import com.page.Flipkart;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class FlipkartStepDef {
    public static WebDriver driver;
    Flipkart ecom;

    @Given("^user is on flipkart homepage$")
    public void user_is_on_flipkart_homepage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\10651361\\Downloads\\Chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String baseUrl = "https://www.flipkart.com/";
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }


//    @When("Search for any item")
//    public void enterSearchItemName() throws Throwable {
//     ecom = new Flipkart(driver);
//     Assert.assertTrue(ecom.clickCloseLoginScreenBtn());
//        Assert.assertTrue(ecom.enterSearchItemName());
//    }

    @When("^Search for \"([^\"]*)\" any item$")
    public void enterSearchItemName(String s) throws Throwable {
        ecom = new Flipkart(driver);
        Assert.assertTrue(ecom.clickCloseLoginScreenBtn());
        Assert.assertTrue(ecom.enterSearchItemName(s));
    }


    @And("^Click on the First Item in the list$")
    public void clickFirstItem() throws Throwable{
        ecom = new Flipkart(driver);
        Assert.assertTrue(ecom.clickFirstItem());
    }

    @And("^Print Price of the Item$")
    public void getFirstItemPrice() throws Throwable {
        ecom = new Flipkart(driver);
        Assert.assertTrue(ecom.getFirstItemPrice());
    }

    @Then("^Add to cart in guest mode$")
    public void clickAddToCart() throws Throwable{
        ecom = new Flipkart(driver);
        Assert.assertTrue(ecom.clickAddToCart());
    }

    @Then("^Add to cart in guest mode in Flipkart$")
    public void clickAddToCartInFlipkart() throws Throwable{
        ecom = new Flipkart(driver);
        Assert.assertTrue(ecom.switchToChildWindow());
        Assert.assertTrue(ecom.clickAddToCart());
    }

    @And("^Increase Quantity by 1$")
    public void clickIncreaseQuantity() throws Throwable{
        ecom = new Flipkart(driver);
        Assert.assertTrue(ecom.clickIncreaseQuantity());
    }

    @And("^Get price of item after adding to cart$")
    public void getPriceOfItem() throws Throwable{
        ecom = new Flipkart(driver);
        Assert.assertTrue(ecom.getPriceBeforeIncreasingQuantity());
        Assert.assertTrue(ecom.closeBrowser());
    }


    @And("^Print the Price after addition of Quantity$")
    public void getPriceAfterIncreasingQuantity() throws Throwable{
        ecom = new Flipkart(driver);
        Assert.assertTrue(ecom.getPriceAfterIncreasingQuantity());
        Assert.assertTrue(ecom.closeBrowser());
    }

    @Then("^success message is displayed$")
    public void success_message_is_displayed() throws Throwable {
        ecom = new Flipkart(driver);
        String exp_message = "Please enter valid Email ID/Mobile number";
        String actual = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/span[3]/span")).getText();
        Assert.assertEquals(exp_message, actual);
        driver.quit();
    }


}