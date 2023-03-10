package dev.chan.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class SearchResultPage {
    public WebDriver driver;
    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "._10Ermr")
    public WebElement resultText;

    @FindBy(css="._3uTeW4")
    public WebElement errorMsg;

    @FindBy(css = "div:nth-of-type(2) > ._13oc-S > div > ._2kHMtA > ._1fQZEK")
    public WebElement firstProduct;

}
