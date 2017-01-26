package tests;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListeners implements ITestListener {



    public void onTestStart(ITestResult result) {

    }

    public void onTestSuccess(ITestResult result) {
        TestBase.logger.info("result: Success");
    }

    public void onTestFailure(ITestResult result) {

        TestBase.logger.error("ERROR:\n Test Failed :"+result.getThrowable().getMessage());

    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

    }
}
