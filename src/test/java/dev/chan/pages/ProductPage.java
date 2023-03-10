package dev.chan.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    public WebDriver driver;
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button")
    public WebElement addToCartBtn;

    @FindBy(xpath ="/html/body/div[1]/div/div[1]/div[1]/div[2]/div[6]/div/div/a")
    public WebElement cartIcon;
}
