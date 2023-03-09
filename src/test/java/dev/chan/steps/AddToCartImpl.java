package dev.chan.steps;

import dev.chan.pages.*;
import dev.chan.runner.TestRunner;

import org.openqa.selenium.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.*;
public class AddToCartImpl {
    public WebDriver driver = TestRunner.driver;
    public Homepage homepage = TestRunner.homepage;
    public SearchResultPage searchResultPage = TestRunner.searchResultPage;


}
