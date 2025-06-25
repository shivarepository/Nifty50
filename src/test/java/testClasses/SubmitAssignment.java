package testClasses;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.Nifty50StocksPage;
import testComponents.BaseClass;

public class SubmitAssignment extends BaseClass {

    @Test
    public void Submit() throws InterruptedException {
        System.out.println("Hello");
        HomePage po = new HomePage(driver);
        po.clickNifty50();
        Nifty50StocksPage.Click_On_ViewMore();

//        driver.switchTo().window("NSE - National Stock Exchange of India Ltd: Live Share/Stock Market News &amp; Updates, Quotes- Nseindia.com");
//        driver.findElement(By.xpath("(//a[text()='View More'])[1]")).click();
//        driver.switchTo().window("Equity Market Watch, Live Nifty & Sensex Charts & News - NSE India");

    }
}
