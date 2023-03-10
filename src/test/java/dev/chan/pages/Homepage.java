package dev.chan.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
public class Homepage {
    public WebDriver driver;
    public Homepage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input")
    public WebElement searchBar;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[1]/div[2]/div[2]/form/div/button")
    public WebElement searchIcon;

    @FindBy(xpath = "/html/body/div[2]/div/div/button")
    public WebElement closeBtn;

    @FindBy(xpath = "/html/body/div/div/div[1]/div[1]/div[2]/div[1]/div/a[1]")
    public WebElement homeIcon;



}
