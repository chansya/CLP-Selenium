package dev.chan.steps;

import dev.chan.pages.*;
import dev.chan.runner.Runner;

import org.openqa.selenium.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.*;
public class ProductSearchImpl {
    public WebDriver driver = Runner.driver;
    public Homepage homepage = Runner.homepage;
    public SearchResultPage searchResultPage = Runner.searchResultPage;


    @Given("user is on the home page")
    public void user_is_on_the_home_page() {
        driver.get("https://www.flipkart.com/");
    }
    @When("user types a valid product name in the search bar")
    public void user_types_a_valid_product_name_in_the_search_bar() {
        homepage.searchBar.sendKeys("iPhone 13 256 GB");
    }
    @When("user presses the search icon")
    public void user_presses_the_search_icon() {
        homepage.searchIcon.click();
    }
    @Then("A page showing the search result should appear")
    public void a_page_showing_the_search_result_should_appear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(searchResultPage.resultText));

        String resultText = searchResultPage.resultText.getText();
        assertNotEquals(-1, resultText.indexOf("results for \"iPhone 13 256 GB\""));
    }

    @When("user types an invalid product name in the search bar")
    public void user_types_an_invalid_product_name_in_the_search_bar() {
        homepage.searchBar.sendKeys("cdjhvvi");

    }


    @Then("A page showing no result is found should appear")
    public void a_page_showing_no_result_is_found_should_appear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(searchResultPage.errorMsg));

        String expectedMsg = "Sorry, no results found!";
        String actualMsg = searchResultPage.errorMsg.getText();
        assertEquals(expectedMsg, actualMsg);
    }

}
