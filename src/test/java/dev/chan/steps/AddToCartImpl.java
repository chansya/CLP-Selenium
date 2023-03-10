package dev.chan.steps;

import dev.chan.pages.*;
import dev.chan.runner.TestRunner;

import org.checkerframework.checker.units.qual.C;
import org.junit.Test;
import org.openqa.selenium.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

import static org.junit.Assert.*;
public class AddToCartImpl {
    public WebDriver driver = TestRunner.driver;
    public Homepage homepage = TestRunner.homepage;
    public SearchResultPage searchResultPage = TestRunner.searchResultPage;
    public ProductPage productPage = TestRunner.productPage;
    public CartPage cartPage = TestRunner.cartPage;
    @Given("user is on product list page")
    public void user_is_on_product_list_page() {
        driver.get("https://www.flipkart.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(homepage.closeBtn));
        homepage.closeBtn.click();
        homepage.searchBar.clear();
        homepage.searchBar.sendKeys("iPhone 13 256 GB");
        homepage.searchIcon.click();

    }
    @When("user clicks on the desired product")
    public void user_clicks_on_the_desired_product() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(searchResultPage.firstProduct));
        searchResultPage.firstProduct.click();
        Thread.sleep(3000);
    }
    @When("user clicks the Add To Cart button")
    public void user_clicks_the_add_to_cart_button() throws InterruptedException {
        ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
        //switch to new tab
        driver.switchTo().window(newTb.get(1));
        System.out.println("Page title of new tab: " + driver.getTitle());

        //click add to cart
        productPage.addToCartBtn.click();
        //wait
        Thread.sleep(3000);
        //click on cart icon
        productPage.cartIcon.click();

        //switch to parent window
//        driver.switchTo().window(newTb.get(0));
    }
    @Then("the product should be in the cart")
    public void the_product_should_be_in_the_cart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(cartPage.productInCart));
        String actualName = cartPage.productInCart.getText();
        String expectedName = "APPLE iPhone 13";
        assertNotEquals(-1,actualName.indexOf(expectedName) );

    }



}
