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

//        driver.findElement(By.xpath("//*[@class='market_turnover']//span[text()='View More']")).isEnabled();
//        driver.findElement(By.xpath("//*[@class='market_turnover']//span[text()='View More']")).click();
        Thread.sleep(20000);

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
                js.executeScript("window.scrollBy(0,1500)","");
                Thread.sleep(20000);
                driver.findElement(By.xpath("//span[text()='View More']")).isEnabled();
                driver.findElement(By.xpath("//span[text()='View More']")).click();
                Thread.sleep(20000);
            }
        }
        getScreenShot(driver);
    }
}
