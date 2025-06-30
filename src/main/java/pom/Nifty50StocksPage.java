package pom;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Nifty50StocksPage {

    static WebDriver driver;

    public Nifty50StocksPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[text()='View More']")
    static WebElement ViewMoreButton;

    public static void Click_On_ViewMore() throws InterruptedException {
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();", ViewMoreButton);
        Actions action = new Actions(driver);
        action.moveToElement(ViewMoreButton).click(ViewMoreButton);
        action.perform();
//        action.contextClick();
//        action.scrollToElement(ViewMoreButton);
//        js.executeScript("window.scrollBy(1190,20)","");
//        ViewMoreButton.isDisplayed();
//        ViewMoreButton.click();
    }

}
