package testClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.Nifty50StocksPage;
import testComponents.BaseClass;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class SubmitAssignment extends BaseClass {

    @Test
    public void Submit() throws InterruptedException, IOException {
        System.out.println("Hello");
        HomePage po = new HomePage(driver);
        po.clickNifty50();

//        Nifty50StocksPage.Click_On_ViewMore();

//        driver.switchTo().window("NSE - National Stock Exchange of India Ltd: Live Share/Stock Market News &amp; Updates, Quotes- Nseindia.com");
//        driver.findElement(By.xpath("(//a[text()='View More'])[1]")).click();
//        driver.switchTo().window("Equity Market Watch, Live Nifty & Sensex Charts & News - NSE India");

        Set<String> parent = driver.getWindowHandles();
        Set<String> child = driver.getWindowHandles();
        Iterator<String> itr1 = child.iterator();
        while (itr1.hasNext())
        {
            String child_window = itr1.next();
            if(!parent.equals(child_window))
            {
                driver.switchTo().window(child_window);
                System.out.println(driver.switchTo().window(child_window).getTitle());
                Thread.sleep(10000);
                JavascriptExecutor js = (JavascriptExecutor)driver;
                js.executeScript("window.scrollBy(0,1400)","");
                Thread.sleep(10000);
                driver.findElement(By.xpath("//a[text()='View More'])[1]")).click();
            }
        }
        getScreenShot(driver);
    }
}
