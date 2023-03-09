package dev.chan.runner;

import dev.chan.pages.*;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/dev/chan/features", glue = "dev.chan.steps")
public class TestRunner {

    public static WebDriver driver;
    public static Homepage homepage;
    public static SearchResultPage searchResultPage;
    public static CartPage cartPage;

    @BeforeClass
    public static void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        homepage = new Homepage(driver);
        searchResultPage = new SearchResultPage(driver);
        cartPage = new CartPage(driver);
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }

}