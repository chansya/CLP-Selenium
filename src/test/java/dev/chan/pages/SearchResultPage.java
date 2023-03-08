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

    @FindBy(xpath="///div[@innertext='Sorry, no results found!']")
    public WebElement errorMsg;

}
