package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//p[text()='NIFTY 50'])[4]")
    WebElement link_Nifty50;

    public Nifty50StocksPage clickNifty50()
    {
        link_Nifty50.click();
        return new Nifty50StocksPage(driver);
    }
}
