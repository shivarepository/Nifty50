package testComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utility.ExtentReportManage;

public class Listeners extends  BaseClass implements ITestListener {

    ExtentTest test;
    ExtentReports extentReport = ExtentReportManage.getInstance();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    @Override
    public void onTestStart(ITestResult result)
    {
        test = extentReport.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result){
        extentTest.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result){
        extentTest.get().log(Status.FAIL, result.getThrowable());
    }
}
