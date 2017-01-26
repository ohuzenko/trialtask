package tests;

import appmanager.ApplicationManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import org.testng.log4testng.Logger;
import ru.yandex.qatools.allure.annotations.Attachment;


/**
 * Created by sunny_IT on 1/26/2017.
 */

public class TestListeners implements ITestListener {



    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        TestBase.logger.info("result: Success");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        TestBase.logger.error("ERROR:\n Test Failed :"+result.getThrowable().getMessage());

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
