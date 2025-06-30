package testComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.*;
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

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

    public String getScreenShot(WebDriver driver) throws IOException {
        TakesScreenshot screenShot = (TakesScreenshot)driver;
        File srcFile = screenShot.getScreenshotAs(OutputType.FILE);
//        File destFile = new File(System.getProperty("user.dir") + "//screenshot" + ".png");
        File destFile = new File("C:\\Users\\Administrator\\IdeaProjects\\SDETAssignment\\screenshot" + ".png");
        FileUtils.copyDirectory(srcFile, destFile);
        return System.getProperty("C:\\Users\\Administrator\\IdeaProjects\\SDETAssignment\\screenshot" + ".png");

    }
}
