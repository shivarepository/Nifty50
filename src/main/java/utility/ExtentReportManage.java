package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManage {

    public static ExtentReports getInstance(){
            ExtentSparkReporter rp = new ExtentSparkReporter(System.getProperty("user.dir") + "//reports//index.html");
            rp.config().setDocumentTitle("AutomationReport");
            rp.config().setReportName("Test Result");

            ExtentReports extentReports = new ExtentReports();
            extentReports.attachReporter(rp);
            extentReports.setSystemInfo("Automation Tester", "Shivanagayya");
            extentReports.getStats();
            return extentReports;
    }
}
