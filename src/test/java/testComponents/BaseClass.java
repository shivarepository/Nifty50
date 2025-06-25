package testComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {

    public WebDriver driver;
    public WebDriver Initialize() throws IOException {
        Properties prop = new Properties();
        FileInputStream fip = new FileInputStream(System.getProperty("user.dir") +
                "//src//main//java//resources//GlobalProperties.property");
        prop.load(fip);
        if(prop.getProperty("BrowserName").equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            this.driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.get(prop.getProperty("AppURL"));
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public void launchApp() throws IOException {
        driver = Initialize();
    }

//    @AfterClass
//    public void tearDown()
//    {
//        driver.quit();
//    }
}
