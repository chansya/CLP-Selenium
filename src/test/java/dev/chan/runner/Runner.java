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

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = "steps")
public class Runner {

    public static WebDriver driver;
    public static Homepage homepage;


    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        homepage = new Homepage(driver);
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }

}